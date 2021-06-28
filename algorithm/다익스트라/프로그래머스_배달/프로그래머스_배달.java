import java.util.*;

class Solution {

	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		int[][] map = new int[N+1][N+1];
		int[] dist = new int[N+1];

		for(int i=0; i<=N; i++)
			dist[i] = Integer.MAX_VALUE;


		ArrayList<int[]> al = new ArrayList<>();
		for(int i=0; i<road.length; i++){
			int fromNode = road[i][0];
			int toNode = road[i][1];
			int distance = road[i][2];

			al.add(new int[]{fromNode, toNode, distance});
			al.add(new int[]{toNode, fromNode, distance});
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(1, new Comparator<int[]>(){
			@Override
			public int compare(int[] v1, int[] v2){
				if(v1[1] == v2[1])
					return v1[0] - v2[0];
				return v1[1] - v2[1];
			}
		});

		pq.add(new int[]{1, 0});
		dist[1] = 0;
		while(!pq.isEmpty()){
			int[] point = pq.poll();

			int start = point[0];
			int price = point[1];

			for(int i=0; i<al.size(); i++){
				if(al.get(i)[0] != start) continue;

				if(dist[al.get(i)[1]] > al.get(i)[2] + price){

					dist[al.get(i)[1]] = al.get(i)[2] + price;
					pq.add(new int[]{al.get(i)[1], dist[al.get(i)[1]]});
				}
			}
		}


		for(int i=1; i<=N; i++){
			if(dist[i]<=K)
				answer+=1;
		}
		return answer;
	}
}