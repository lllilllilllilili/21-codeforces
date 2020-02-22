package SSAFY;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1번 {

	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int init = 10;
		int ans = 0;
		int index = 1;
		int start = 1;
		while(true) {	
			if(init>n) {
				ans += (n-init/10+1)*index;
				break;
			}else {
				ans += ((init-1)-start+1) *index;
				init *= 10;
				start *= 10;
				index +=1;
			}
		}//end of while loop
		System.out.println(ans);
	}
}
