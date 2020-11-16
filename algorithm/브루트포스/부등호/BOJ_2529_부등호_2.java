package backjun;

import java.util.*;
import java.io.*;
public class BOJ_2529_부등호_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		
		long[] big = new long[n+1];
		long[] small = new long[n+1];
		
		long[] visit = new long[10];
		big_DFS(0, n+1, big, visit, arr);
		visit = new long[10];
		small_DFS(0, n+1, small, visit, arr);
	}
	static int big_DFS(int nn, int target, long[] big, long[] visit, String[] arr) {
		if(nn==target) {
			boolean find = false;
			String k = "";
			for(int i=0; i<big.length; i++)
				k+=big[i];
			for(int i=0; i<arr.length; i++) {
				if(arr[i].equals("<")) {
					if(big[i]<big[i+1]) continue;
					else {
						find = true;
						break;
					}
				}else {
					if(big[i]>big[i+1]) continue;
					else {
						find = true;
						break;
					}
				}
			}//end of loop
			if(find == false) {
				System.out.println(k);
				return 1;
			}
		}else {
			for(int i=9; i>=0; i--) {
				if(visit[i]==0) {
					visit[i] = 1;
					big[nn] = i;
					int m = big_DFS(nn+1, target, big, visit, arr);
					if(m==1) return 1;
					visit[i] = 0;
					
				}
			}
		}
		return 0;
	}
	static int small_DFS(int nn, int target, long[] small, long[] visit, String[] arr) {
		if(nn==target) {
			boolean find = false;
			String k = "";
			for(int i=0; i<small.length; i++)
				k+=small[i];
			for(int i=0; i<arr.length; i++) {
				if(arr[i].equals("<")) {
					if(small[i]<small[i+1]) continue;
					else {
						find = true;
						break;
					}
				}else {
					if(small[i]>small[i+1]) continue;
					else {
						find = true;
						break;
					}
				}
			}
			if(find == false) {
				System.out.println(k);
				return 1;
			}
		}else {
			for(int i=0; i<=9; i++) {
				if(visit[i]==0) {
					visit[i] = 1;
					small[nn] = i;
					int m = small_DFS(nn+1, target, small, visit, arr);
					if(m==1) return 1;
					visit[i] = 0;
				}
			}
		}
		return 0;
	}
}
