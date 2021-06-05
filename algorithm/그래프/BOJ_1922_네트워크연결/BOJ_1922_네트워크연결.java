
import java.util.*;
import java.io.*;

public class Main {

	static int n,m;

	static ArrayList<Pair>[] al;

	static class Pair{
		int node;
		int cost;
		Pair(int node, int cost){
			this.node=node;
			this.cost=cost;
		}
	}
	static class Comp implements Comparator<Pair>{
		public int compare(Pair p1, Pair p2) {
			return Integer.compare(p1.cost, p2.cost);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		al=new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			al[i] = new ArrayList<>();
		}

		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			al[from].add(new Pair(to,cost));
			al[to].add(new Pair(from,cost));
		}
		boolean[] visit = new boolean[n+1];
		visit[1]=true;
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
		for(Pair next : al[1]) {
			pq.add(next);
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			Pair next = pq.poll();
			if(visit[next.node]) continue;
			visit[next.node] = true;
			ans+=next.cost;
			for(Pair pnext : al[next.node]) {
				pq.add(pnext);
			}
		}
		System.out.println(ans);
	}
}
