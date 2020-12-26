
import java.util.*;
import java.io.*;
public class SWEA_4008_숫자만들기 {

	static int[] pmmd;
	static int[] number;
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		for(int i=1; i<=total; i++) {
			int cd = Integer.parseInt(br.readLine());
			//1. +, -, *, / 
			pmmd = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				pmmd[j] = Integer.parseInt(st.nextToken());
			}
			//2. 입력된 숫자
			number = new int[cd];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<cd; j++) {
				number[j] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0, number[0]);
			
			System.out.println("#"+i+" "+(MAX-MIN));
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
		}
	}
	static void DFS(int n, int sum) {
		//4. number-1 개수에서 값을 갱신합니다. 
		if(n==number.length-1) {
			if(MAX<sum)
				MAX = sum;
			if(MIN>sum)
				MIN=sum;
			
			return ;
		}
		//3. 부호 개수 만큼 돌면서 값을 계산합니다. 
		for(int i=0; i<pmmd.length; i++) {
			if(pmmd[i]<=0) continue;
			//4. 백트래킹으로 부호 중 하나를 사용해서 값을 계산하여 
			pmmd[i]-=1;
			int cal_sum = 0;
			// +
			if(i==0) {
				cal_sum = sum + number[n+1];
			// -
			}else if(i==1) {
				cal_sum = sum - number[n+1];
			// *
			}else if(i==2) {
				cal_sum = sum * number[n+1];
			// /
			}else {
				cal_sum = sum/number[n+1];
			}
			
			DFS(n+1, cal_sum);
			//5. 계산을 다하고 난후에 사용한 부호를 원상복구 합니다. 
			pmmd[i]+=1;
		}
	}
}
