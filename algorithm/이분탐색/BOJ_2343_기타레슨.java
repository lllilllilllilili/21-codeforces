package backjun;

import java.util.*;
import java.io.*;
public class BOJ_2343_기타레슨 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int high = 0;
		int low = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			low = Math.max(low, arr[i]);
			high+=arr[i];
		}

		while(low<=high) {
			int mid = (low+high)/2;
			int tempSum=0;
			int tape=0;
			for(int i=0; i<n; i++) {
				if(tempSum+arr[i]>mid) {
					tempSum=0;
					tape+=1;
				}
				tempSum+=arr[i];
			}
			if(tempSum!=0) tape+=1;
			if(tape<=m) {
				high=mid-1;
			}else if(tape>m){
				low=mid+1;
			}
		}
		System.out.println(low);

	}
}