package backjun;

import java.io.*;
import java.util.*;
public class BOJ_14620_꽃길 {

	static int n;
	static boolean[][] visit;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new int[n][n];
		//1.입력 
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[n][n];
		//2. 꽃잎을 심습니다. 
		petal(1, 0, 0);
		System.out.println(MIN);
	}
	static void petal(int y, int petalCnt, int cost) {
		if(petalCnt == 3) {
			MIN = Math.min(MIN, cost);
			return ;
		}
		
		//2-1. 씨앗을 둡니다.
		//2-2. 꽃잎이 만개한다. 꽃잎이 만개할 때 맵을 벗어나는지, 다른 꽃잎과 만나는지 확인합니다.		
		for(int i=y; i<n-1; i++) {
			for(int j=1; j<n-1; j++) {
				//2-1. 씨앗을 둘 수 있을까요?
				if(visit[i][j]) continue; 
				
				//System.out.println("1");
				boolean personWhoTouchesFlowers = false;
				for(int k=0; k<4; k++) {
					//2-2. 꽃잎 만개할 수 있을까요?
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx<0 || nx>=n || ny<0 || ny>=n || visit[nx][ny]) {
						personWhoTouchesFlowers = true;
						break;
					}
				}
				//System.out.println("2");
				if(personWhoTouchesFlowers) {
					continue;
				}
				visit[i][j] = true;
				int temp = map[i][j];
				for(int k=0; k<4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					temp+=map[nx][ny];
					visit[nx][ny] = true;
				}
				//System.out.println("before petal");
				petal(i,petalCnt+1,cost+temp);
				for(int k=0; k<4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					visit[nx][ny] = false;
				}
				visit[i][j] = false;
			}
		}
	}
}
