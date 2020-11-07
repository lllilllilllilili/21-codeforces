package programmers;

import java.util.*;
import java.io.*;
public class 프로그래머스_특정거리의도시찾기2  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //도시 개수 
		int M = Integer.parseInt(st.nextToken()); //도로의 개수
		int K = Integer.parseInt(st.nextToken()); //거리 정보
		int X = Integer.parseInt(st.nextToken()); //출발 도시의 번호
		
		ArrayList<Integer>[] map = (ArrayList<Integer>[])new ArrayList[N+1];
		int[] visit = new int[N+1];
		for(int i=1; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			map[f].add(s);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		visit[X] = 1;
		pq.add(new int[] {X,0});
		PriorityQueue<Integer> ans = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			int[] k = pq.poll();
			int Edge = k[0];
			int depth = k[1];
			
			if(depth == K) {
				ans.add(Edge);
				continue;
			}
			
			for(int i=0; i<map[Edge].size(); i++) {
				int next = map[Edge].get(i);
				if(visit[next]==0) {
					visit[next] = 1;
					pq.add(new int[] {next, depth+1});
				}
			}//end of for loop
		}
		if(ans.size()==0)
			System.out.println("-1");
		else {
			while(!ans.isEmpty())
				System.out.println(ans.poll());
		}
	}
}
