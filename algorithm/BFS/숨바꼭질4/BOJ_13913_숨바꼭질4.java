package backjun;

import java.io.*;
import java.util.*;
public class BOJ_13913_숨바꼭질4 {

	static void print(int n, int m, int[] from) {
		if(n!=m) {
			print(n, from[m], from);
		}
		System.out.print(m+" ");
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int begin = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		Queue<int[]> q = new LinkedList<>();
		int[] from = new int[100001];
		boolean[] visit = new boolean[100001];
		visit[begin] = true;
		q.add(new int[] {begin,0});
		while(!q.isEmpty()) {
			int[] k = q.poll();
			if(k[0]==target) {
				
				System.out.println();
				System.out.print(k[1]+" ");
				print(begin,target,from);
			}
			if(k[0]+1<=100000 && visit[k[0]+1]==false) {
				visit[k[0]+1] = true;
				q.add(new int[] {k[0]+1,k[1]+1});
				from[k[0]+1] = k[0];
			}
			if(k[0]-1>=0 && visit[k[0]-1]==false) {
				visit[k[0]-1] = true;
				q.add(new int[] {k[0]-1, k[1]+1});
				from[k[0]-1] = k[0];
			}
			if(2*k[0]<=100000 && visit[2*k[0]]==false) {
				visit[2*k[0]] = true;
				q.add(new int[] {2*k[0], k[1]+1});
				from[k[0]*2]=k[0];
			}
		}
	}
}
