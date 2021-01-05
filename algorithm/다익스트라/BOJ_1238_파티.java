package backjun;

import java.util.*;
import java.io.*;
public class BOJ_1238_파티 {

	static int N,M,X;
	static int[] dist, revdist;
	static ArrayList<ArrayList<Node>> list;
	static ArrayList<ArrayList<Node>> revlist;
	static class Node implements Comparable<Node>{
		int index;
		int time;
		public Node(int index, int time) {
			this.index = index;
			this.time = time;
		}
		public int compareTo(Node n) {
			return this.time - n.time;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		revdist = new int[N+1];
		
		//1-1. 초기화 
		list = new ArrayList<>();
		revlist = new ArrayList<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(revdist, Integer.MAX_VALUE);
		for(int i=0; i<=M; i++) { //error. i=1 부터 시작하면 RUNTIMEERROR Why? 시작점 or 끝점가 0으로 들어올 수도 있습니다.
			list.add(new ArrayList<>());
			revlist.add(new ArrayList<>());
		}
		
		//2. M만큼 돌면서 거리 시작점, 끝점, 소요시간을 저장합니다. 
		//2-1. 목적지 -> 도착지 2번 
		//2-2. 참석하려고 가는 경우(목적지를 제외한 모든 노드가 다익스트라를 사용), 목적지에서 다시 돌아올 경우 
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int sp = Integer.parseInt(st.nextToken());
			int ep = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			list.get(sp).add(new Node(ep, time));
			revlist.get(ep).add(new Node(sp,time));
		}
		
		//3. 위 경우에 대한 다익스트라 알고리즘을 활용 
		dijkstra(list, dist, X);
		dijkstra(revlist, revdist, X);
		
		//4. 다익스트라 함수를 통해 계산해둔 dist, revdist 배열안에 i번째 학생이 목적지로 갈 때의 시간과 되돌아올 때의 시간을 더하여 최댓값을 갱신합니다.
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans,dist[i]+revdist[i]);
		}
		System.out.println(ans);
	}
	static void dijkstra(ArrayList<ArrayList<Node>> list, int[] time, int start) {
		boolean[] visit = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		time[start] = 0;
		
		while(!pq.isEmpty()) {
			int idx = pq.poll().index; 
			if(visit[idx]) continue;
			else
				visit[idx] = true;
			//3. idx에 연결된 노드들을 찾아봅니다. 
			for(Node node : list.get(idx)) {
				//3-1. 미리 저장되어있는 다음 위치에서의 도달 시간의 값과 현재 위치의 도달 시간의 값 더하기 다음 노드까지 걸리는데 시간을 더해줍니다.
				if(time[node.index] > time[idx] + node.time) {
					time[node.index] = time[idx] + node.time;
					//3-2. 갱신된 위치와 시간값을 pq에 넣고 다시 연산을 반복수행하게 됩니다. 
					pq.add(new Node(node.index, time[node.index])); 
				}
			}
		}
		
	}
}
