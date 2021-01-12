package backjun;

import java.util.*;
import java.io.*;
public class BOJ_14925_목장건설하기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int M,N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[][] MAP = new int[M+1][N+1];
		int MAX = 0;
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==0) {
					//O(n^2) 이긴 하지만 장애물 없는 경우, 왼쪽 위 부터 보니까 3면의 minimum +1 
					MAP[i][j] = 1;
					MAP[i][j] = Math.min(MAP[i-1][j-1], Math.min(MAP[i-1][j], MAP[i][j-1]))+1;
					if(MAX<MAP[i][j])
						MAX = MAP[i][j];
				}
			}
		}
		System.out.println(MAX);
		
	}
}
