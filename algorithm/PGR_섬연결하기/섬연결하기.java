package backjun;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
public class º∂ø¨∞·«œ±‚ {

	static int[] d;
	static int[] rank;
	static ArrayList<int[]> al = new ArrayList<>();
	static int find(int island) {
		if(island == d[island]) return island;
		else {
			return d[island] = find(d[island]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
		int[][] costs = new int[][] {
			{0,1,1},
			{0,2,2},
			{1,2,5},
			{1,3,1},
			{2,3,8}
		};
		d = new int[costs.length];
		rank = new int[costs.length];
		
		for(int i=0; i<costs.length; i++) {
				al.add(new int[] {costs[i][0], costs[i][1], costs[i][2]});
		}
		
		
		for(int i=0; i<d.length; i++) {
			d[i] = i;
			rank[i] = 1;
		}
		
		Collections.sort(al, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
//		
//		for(int i=0; i<costs.length; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print(costs[i][j]+" ");
//			}
//			System.out.println();
//		}//end of for loop
		
		int ans = 0;
		for(int i=0; i<costs.length; i++) {
			int first = find(al.get(i)[0]);
			int next = find(al.get(i)[1]);
			int cost = al.get(i)[2];
			
			if(first==next) continue;
			
			if(first!=next) {
				if(rank[first]>rank[next]) {
					int temp = first;
					first = next;
					next = temp;
				}
				d[first] = next;
				if(rank[first]==rank[next]) rank[next] +=1;
				ans += cost;
			}
		}
		System.out.println(ans);
	}
}
