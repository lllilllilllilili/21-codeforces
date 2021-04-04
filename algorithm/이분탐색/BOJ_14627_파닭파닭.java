package backjun;

import java.util.*;
import java.io.*;
public class BOJ_14627_파닭파닭 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long S = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long[] arr = new long[1000000];
		long min = Long.MIN_VALUE;
		long sum = 0;
		for(int i=0; i<S; i++) {
			long element = Long.parseLong(br.readLine());
			sum+=element;
			arr[i]=element;
			min=Math.max(arr[i], min);
		}
		long left = 1;
		long right = min;
		long cnt=0;
		while(left<=right) {
			
			long mid = (left+right)/2;
			
			long chickenCnt=0;
			for(int i=0; i<arr.length; i++) {
				//114
				//114*1, 114*2, 114*3
				chickenCnt+=(arr[i]/mid);	
				
			}
//			System.out.println(chickenCnt);
			
			if(chickenCnt>=C) {
				left=mid+1;
				cnt=mid;
			}else {
				right=mid-1;
				
			}
		}
//		System.out.println(mid);
		long answer = sum-cnt*C;
		System.out.println(answer);
	}
}
