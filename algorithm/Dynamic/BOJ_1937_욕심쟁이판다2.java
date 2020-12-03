package backjun;

import java.io.*;
import java.util.*;
public class BOJ_1937_욕심쟁이판다2 {

	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//map
		n = Integer.parseInt(br.readLine()); 
		map = new int[n][n];
		dp = new int[n][n];
		
		//input
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		//dfs
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dp[i][j]==0) {
					max = Math.max(max, DFS(i*n+j));
				}
			}
		}
		System.out.println(max);
	}
	static int DFS(int nn) {
		int x = nn/n;
		int y = nn%n; 
		
		
		if(dp[x][y]!=0) return dp[x][y];
		
		dp[x][y] = 1;
		
		for(int i=0; i<4; i++) {
			int ddx = x + dx[i];
			int ddy = y + dy[i];
			if(ddx<0 || ddx>=n || ddy<0 || ddy>=n) continue;
			if(map[x][y]>=map[ddx][ddy]) continue;
			dp[x][y] = Math.max(dp[x][y], DFS(ddx*n+ddy)+1);
		}
		return dp[x][y];
	}
}
