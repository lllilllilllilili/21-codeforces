package backjun;

import java.util.*;
import java.io.*;
public class DFS와BFS {

	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		//정점의개수, 간선의개수, 탐색을 시작하는 정점의 번호
		
		int[][] graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int bef = Integer.parseInt(st.nextToken());
			int aft = Integer.parseInt(st.nextToken());
			
			graph[bef][aft] = 1;
			graph[aft][bef] = 1;
		}//end of for loop
		
		//DFS
		boolean[] visit = new boolean[N+1];
		visit[V]=true;
		DFS(V, graph, visit);
		System.out.println();
		//BFS
		visit = new boolean[N+1];
		BFS(V, graph, visit);
		
	}
	static void DFS(int S, int[][] graph, boolean[] visit) {
		
			System.out.print(S+" ");
			for(int j=1; j<=N; j++) {
			if(graph[S][j]==1 && visit[j]==false) {
				visit[j] = true;
				DFS(j, graph, visit);
			}
		}
	}//end of DFS
	
	static void BFS(int start, int[][] graph, boolean[] visit) {
		Queue<Integer> q = new LinkedList<>();
		visit[start]=true;
		q.add(start);
		while(!q.isEmpty()) {
			int p = q.poll();
			System.out.print(p+" ");
			for(int i=1; i<=N; i++) {
				if(graph[p][i]==1 && visit[i]==false) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
}
