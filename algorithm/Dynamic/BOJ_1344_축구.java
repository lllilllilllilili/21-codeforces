import java.util.*;
import java.io.*;
public class Main {

	static double[][][] dp;
	static double percent_a;
	static double percent_b;
	static int[] prime = {2,3,5,7,11,13,17};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		percent_a = Integer.parseInt(br.readLine());
		percent_b = Integer.parseInt(br.readLine());
		percent_a*=(0.01);
		percent_b*=(0.01);
		dp = new double[19][19][19];

		//top-down
		//double sum = dfs(0,0,0);

		dp[0][0][0] = 1;
		//bottom-up
		for(int i=0; i<18; i++) {
			for(int j=0; j<18; j++) {
				for(int z=0; z<18; z++) {
					boolean find = false;


					dp[i+1][j][z+1]+=(dp[i][j][z]*percent_a*(1-percent_b));
					dp[i][j+1][z+1]+=(dp[i][j][z]*(1-percent_a)*percent_b);
					dp[i][j][z+1]+=(dp[i][j][z]*(1-percent_a)*(1-percent_b));
					dp[i+1][j+1][z+1]+=(dp[i][j][z])*percent_a*percent_b;
				}
			}
		}
		double ans = 1;
		int[] number = new int[]{ 0,1,4,6,8,9,10,12,14,15,16,18 };

		for (int s : number) {
			for (int s2 :number) {
				ans -= dp[s][s2][18];
			}
		}
		System.out.println(ans);
	}
	static double dfs(int a, int b, int cnt) {

		//top-down

		//1step : 기저 조건
		if(cnt==18) {
			for(int i=0; i<7; i++) {
				if(prime[i]==a || prime[i]==b)
					return 1;
			}
			return 0;
		}

		//값이 있으면 return 한다.
		if(dp[a][b][cnt]!=0)
			return dp[a][b][cnt];


		//확률을 구한다. memorization 값을 넣는다.

		//연속된 경우
		dp[a][b][cnt]+=percent_a*(1-percent_b)*dfs(a+1,b,cnt+1);
		//2.
		dp[a][b][cnt]+=(1-percent_a)*percent_b*dfs(a,b+1,cnt+1);
		dp[a][b][cnt]+=(1-percent_a)*(1-percent_b)*dfs(a,b,cnt+1);
		dp[a][b][cnt]+=percent_a*percent_b*dfs(a+1,b+1,cnt+1);
		return dp[a][b][cnt];
		//괜찮아~~~!!~~~~~~~~~~~~~~~~~~~~~~~~~~!!! ~~~~~~~~~!!!!~~
	}
}
