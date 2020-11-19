package backjun;

import java.util.*;
import java.io.*;
public class BOJ_14888_연산자끼워넣기_v2 {

	static class Pair{
		int max;
		int min;
		Pair(int max, int min){
			this.max = max;
			this.min = min;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//end of for loop
		
		st = new StringTokenizer(br.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multi = Integer.parseInt(st.nextToken());
		int divide = Integer.parseInt(st.nextToken());
		
		Pair ans = DFS(arr, 1, n, arr[0], plus, minus, multi, divide);
		System.out.println(ans.max);
		System.out.println(ans.min);
	}
	static Pair DFS(int[] arr, int nn, int target, int cur, int plus, int minus, int multi, int divide) {
		if(nn==target) {
			return new Pair(cur,cur);
		}else {
			ArrayList<Pair> ap = new ArrayList<>();
			if(plus>0) {
				ap.add(DFS(arr, nn+1, target, cur+arr[nn], plus-1, minus, multi, divide));
			}
			if(minus>0) {
				ap.add(DFS(arr, nn+1, target, cur-arr[nn], plus, minus-1, multi, divide));
			}
			if(multi>0) {
				ap.add(DFS(arr, nn+1, target, cur*arr[nn], plus, minus, multi-1, divide));
			}
			if(divide>0) {
				ap.add(DFS(arr, nn+1, target, cur/arr[nn], plus, minus, multi, divide-1));
			}
			
			Pair p = ap.get(0);
			for(Pair k : ap) {
				if(p.max<k.max)
					p.max = k.max;
				if(p.min>k.min)
					p.min = k.min;
			}
			return p;
		}
	}
}
