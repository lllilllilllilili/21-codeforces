package backjun;

import java.util.*;
import java.io.*;
public class BOJ_14500_테트로미노 {

	static int[][] map;
	static int[] dx={-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int n=0;
	static int m=0;
	static int answer=Integer.MIN_VALUE;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//end of for loop
		visit = new boolean[n][m];


		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visit[i][j] = true;
				DFS(i,j,1,map[i][j]);
				visit[i][j] = false;
				//ㅜ
				if(j+2<m && i+1<n) {
					int sum = map[i][j]+map[i+1][j+1]+map[i][j+2]+map[i][j+1];
					answer=Math.max(sum, answer);
				}
				//ㅏ
				if(i+2<n && j+1<m) {
					int sum = map[i+1][j]+map[i+1][j+1]+map[i+2][j]+map[i][j];
					answer=Math.max(sum, answer);
				}
				//ㅗ
				if(i-1>=0 && j+2<m ) {
					int sum = map[i][j]+map[i][j+2]+map[i][j+1]+map[i-1][j+1];
					answer=Math.max(sum, answer);
				}
				//ㅓ
				if(j-1>=0 && i+2<n ) {
					int sum = map[i+1][j-1]+map[i][j]+map[i+2][j]+map[i+1][j];
					answer=Math.max(sum, answer);
				}
			}
		}
		System.out.println(answer);
	}

	static void DFS(int x, int y, int cnt, int sum) {
		if(cnt==4) {
			answer=Math.max(answer, sum);
			return ;
		}
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m)continue;
			if(visit[nx][ny]) continue;
			visit[nx][ny]=true;
			DFS(nx,ny,cnt+1,sum+map[nx][ny]);
			visit[nx][ny]=false;
		}
	}
}
