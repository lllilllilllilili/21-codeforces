package backjun;

import java.util.*;
import java.io.*;
public class BOJ_9251_LCS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String n1 = st.nextToken();
		char[] cn1 = n1.toCharArray();
		st = new StringTokenizer(br.readLine());
		String n2 = st.nextToken();
		char[] cn2 = n2.toCharArray();
		
		int cn1Len = cn1.length;
		int cn2Len = cn2.length;
		int[][] DP = new int[cn1Len+1][cn2Len+1];

		for(int i=1; i<=cn1Len; i++) {
			for(int j=1; j<=cn2Len; j++) {
				if(cn1[i-1] == cn2[j-1]) {
					DP[i][j] = DP[i-1][j-1]+1;
				}else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}//end of for loop
		
		System.out.println(DP[cn1Len][cn2Len]);
	}
}
