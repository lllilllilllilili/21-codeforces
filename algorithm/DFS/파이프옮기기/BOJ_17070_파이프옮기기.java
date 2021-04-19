package backjun;

import java.util.*;
import java.io.*;
public class BOJ_17070_파이프옮기기_v1 {

	static int[][] map;
	static int n;
	static boolean outBound(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=n)
			return true;
		else
			return false;
	}

	static int answer = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end of for loop


		DFS(0,1,1);
		System.out.println(answer);
	}
	static int[] dx = {0,1,1,1,0,1,1};
	static int[] dy = {1,1,0,1,1,0,1};

	static void DFS(int x, int y, int type) {
		if(x==n-1 && y ==n-1) {
			answer+=1;
			return ;
		}
		if(type==1) {
			for(int i=0; i<2; i++) {
				//(0,1), (1,1)
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(outBound(nx,ny)) continue;
				if(dx[i]==1 && dy[i]==1) {
					//if(outBound(nx,ny)|| outBound(nx-1,ny) || outBound(nx,ny-1)) continue;
					if(map[nx][ny]!=0 || map[nx-1][ny]!=0 || map[nx][ny-1]!=0) continue;
				}else {
					if(map[nx][ny]!=0) continue;
				}

				if(i==0)
					DFS(nx,ny,1); //가로 
				else
					DFS(nx,ny,3); //대각선
			}
		}else if(type==2) {
			for(int i=2; i<4; i++) {
				//(1,0), (1,1)
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(outBound(nx,ny)) continue;
				if(dx[i]==1 && dy[i]==1) {
					//if(outBound(nx,ny)|| outBound(nx-1,ny) || outBound(nx,ny-1)) continue;
					if(map[nx][ny]!=0 || map[nx-1][ny]!=0 || map[nx][ny-1]!=0) continue;
				}else {
					if(map[nx][ny]!=0) continue;
				}

				if(i==2)
					DFS(nx,ny,2); //세로  
				else
					DFS(nx,ny,3); //대각선
			}
		}else {
			for(int i=4; i<7; i++) {
				//(0,1), (1,0), (1,1)
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(outBound(nx,ny)) continue;
				if(dx[i]==1 && dy[i]==1) {
					//if(outBound(nx,ny)|| outBound(nx-1,ny) || outBound(nx,ny-1)) continue;
					if(map[nx][ny]!=0 || map[nx-1][ny]!=0 || map[nx][ny-1]!=0) continue;
				}else {
					if(map[nx][ny]!=0) continue;
				}

				if(i==4)
					DFS(nx,ny,1); //가로
				else if(i==5)
					DFS(nx,ny,2); //세로
				else
					DFS(nx,ny,3); //대각선
			}
		}

	}
}