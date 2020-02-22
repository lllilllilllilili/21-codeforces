package SSAFY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2번 {

	static int n,m;
	static int[][] map;
	static int[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans = Integer.MIN_VALUE;
	static void go(int x, int y, int sum, int cnt) {
		if(cnt == 4) {
			if(ans<sum) ans = sum;		
			return ;
		}else {
			
			for(int i=0; i<4; i++) {
				int ddx = x + dx[i];
				int ddy = y + dy[i];
				if(ddx<0 || ddx>=n || ddy<0 || ddy>=m) continue;
				
				if(visit[ddx][ddy] == 0) {
					visit[ddx][ddy] = 1;
					go(ddx,ddy,sum+map[ddx][ddy],cnt+1);
					visit[ddx][ddy] = 0;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end of for loop
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visit[i][j] = 1;
				go(i,j,0,0);
				visit[i][j] = 0;
				//i = x, j = y
				//4가지 경우
				if(i-1>=0 && j+1<m && j+2<m) {
					int temp = map[i][j] + map[i-1][j+1] 
							+ map[i][j+1] + map[i][j+2];
					ans = Math.max(ans, temp);
				}//case1
				
				if(j+1<m && j+2<m && i+1<n) {
					int temp = map[i][j] + map[i][j+1]
							+ map[i][j+2] + map[i+1][j+1];
					ans = Math.max(ans, temp);
				}//case2
				
				if(i+1<n && i+2<n && j+1<m) {
					int temp = map[i][j] + map[i+1][j]
							+map[i+1][j+1] + map[i+2][j];
					ans = Math.max(ans, temp);
				}//case3
				
				if(i+1 <n && i+2<n && j-1>=0) {
					int temp = map[i][j] + map[i+1][j-1]
							+ map[i+1][j] + map[i+2][j];
					ans = Math.max(ans, temp);
				}//case4
			}//end of for loop
//			visit = new int[n][m];
		}
		System.out.println(ans);
	}

}
