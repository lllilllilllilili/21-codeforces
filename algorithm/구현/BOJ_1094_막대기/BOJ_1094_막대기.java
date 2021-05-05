package backjun;

import java.io.*;
import java.util.*;
public class BOJ_1094_막대기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int init_val = 64;
		int cnt =0;
		int sum=0;
		while(X!=sum) {
			if(sum+init_val>X) {
				init_val/=2;

			}else {
				cnt+=1;
				sum+=init_val;
			}


		}
		System.out.println(cnt);
	}
}
