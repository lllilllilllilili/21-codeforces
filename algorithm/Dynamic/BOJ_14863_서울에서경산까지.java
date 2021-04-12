package backjun;

import java.util.*;
import java.io.*;
public class BOJ_14863_서울에서경산까지 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][K+1];
		//도시
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			//도보 시간, 요금액
			int roadTime = Integer.parseInt(st.nextToken());
			int roadCost = Integer.parseInt(st.nextToken());
			//자전거 시간, 요금액 
			int bycleTime = Integer.parseInt(st.nextToken());
			int bycleCost = Integer.parseInt(st.nextToken());
			
			if(i==1) {
				//1. 초기값을 세웁니다. 
				dp[i][roadTime] = roadCost;
				dp[i][bycleTime] = Math.max(dp[i][bycleTime], bycleCost);
			}else {
				for(int j=0; j<=K; j++) {
					
//					if(dp[i-1][j]==0) continue;
//					else {
						
						if(j+roadTime<=K)
							dp[i][j+roadTime]=Math.max(dp[i][j+roadTime], dp[i-1][j]+roadCost);
						
						if(j+bycleTime<=K)
							dp[i][j+bycleTime]=Math.max(dp[i][j+bycleTime], dp[i-1][j]+bycleCost);
					//}
				}
			}//end of for loop
		}//end of for loop
		
		int answer = -1;
		for(int l=1; l<=K; l++) {
			answer = Math.max(answer, dp[N][l]);
		}
		System.out.println(answer);
		
	}
}
