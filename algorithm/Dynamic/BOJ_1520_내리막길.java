package backjun;

import java.util.*;
import java.io.*;
public class BOJ_1520_내리막길2 {

	static int n,m;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end of for loop
		
		int[][] dp = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println( DFS(dp, 0));
	}
	static int DFS(int[][] dp, int nn) {
		int x = nn/m;
		int y = nn%m;
		if(dp[x][y]>0)
			return dp[x][y];
		dp[x][y]=0;
		if(x==0 && y==0) {
			return 1;
		}
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
			if(map[x][y]<map[nx][ny]) {
				dp[x][y]+=DFS(dp,nx*m+ny);
			}
		}
		return dp[x][y];
	}
}
