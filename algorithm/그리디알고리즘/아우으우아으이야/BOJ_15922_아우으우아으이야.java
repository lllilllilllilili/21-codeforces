package backjun;

import java.util.*;
import java.io.*;
public class BOJ_15922_아우으우아으이야 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pre_start = Integer.parseInt(st.nextToken());
		int pre_end = Integer.parseInt(st.nextToken());
		int answer = 0;
		boolean flag = false;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(end<pre_end) //case1. 포함되는 경우 
				continue;
			else if(start<pre_end) { //case2. 일부 포함되는 경우 
				pre_end = Math.max(pre_end,end);
			}else { //case3. 따로 떨어져있는 경우
				
				int len = pre_end-pre_start;
				answer+=len;
				pre_start = start;
				pre_end = end;
				
			}
		}//end of for loop
		int len = pre_end-pre_start;
		answer+=len;
		System.out.println(answer);
	}
}
