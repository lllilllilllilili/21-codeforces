package backjun;

import java.util.*;
import java.io.*;
public class BOJ_17612_쇼핑몰 {

	static class Node{
		int id;
		int weight;
		int casherId;
		Node(int id, int weight, int casherId){
			this.id=id;
			this.weight=weight;
			this.casherId=casherId;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>(1000, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.weight==o2.weight)
					return o1.casherId-o2.casherId;
				return o1.weight-o2.weight;
			}
		});

		ArrayList<Node> al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(i<k){
				pq.add(new Node(id, weight, i+1));
			}else {
				pq.add(new Node(id, pq.peek().weight+weight, pq.peek().casherId));
				al.add(pq.peek());
				pq.poll();
			}
		}//end of for loop

		while(!pq.isEmpty()) {
			al.add(pq.peek());
			pq.poll();
		}

		Collections.sort(al,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.weight==o2.weight)
					return o1.casherId-o2.casherId;
				return o2.weight-o1.weight;
			}

		});

		long ans = 0;
		int cnt = 1;
		for(int i=0; i<al.size(); i++) {
			ans+=(long)((al.get(i).id)*(cnt++));
		}
		System.out.println(ans);
	}
}
