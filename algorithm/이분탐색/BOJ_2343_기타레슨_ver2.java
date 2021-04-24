package backjun;

import java.util.*;
import java.io.*;
public class BOJ_2343_기타레슨_ver2 {

	static int n;
	static int m;
	static int[] arr;
	static boolean checkBluraySize(int size) {

		for(int i=0; i<n; i++) {
			if(arr[i]>size) {
				return false;
			}
		}

		int tempSize=size;
		int cnt=0;

		for(int i=0; i<n; i++) {
			if(size-arr[i]<0) {
				size=tempSize;
				cnt++;
			}
			size-=arr[i];
		}

		if(tempSize!=size)
			cnt+=1;

		return cnt<=m;

	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int pSum = 0;

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pSum+=arr[i];
		}
		int answer=0;
		int low=0;
		int hi=pSum;
		while(low<=hi) {
			int size=(low+hi)/2;
			if(checkBluraySize(size)) {
				hi=size-1;
				answer=size;
			}else {
				low=size+1;
			}
		}
		System.out.println(answer);

	}
}
