package backjun;

import java.util.*;
import java.io.*;
public class BOJ_14864_줄서기 {

	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a]++;
			arr[b]--;
		}

		boolean flag = false;
		boolean[] visit = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(arr[i]<0 || arr[i]>n)
				flag = true;
			if(visit[arr[i]])
				flag = true;
			visit[arr[i]]=true;
		}
		if(flag)
			System.out.println(-1);
		else {
			for(int i=1; i<=n; i++)
				System.out.print(arr[i]+" ");
		}

	}
}