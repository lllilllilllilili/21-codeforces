package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class BOJ_1182_부분수열의합_백트래킹 {

	static int aim=0;
	static int[] arr;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		aim = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=arr.length; i++) {
			make(-1, arr.length-1, i, 0, new HashSet<>());
		}
		System.out.println(answer);
	}
	static void make(int a, int b, int c, int d, HashSet<Integer> keySet) {
		if(c==d) {
			long temp =0;
			
			System.out.println();
			for(int k : keySet) {
				temp+=arr[k];
			}
			if(temp==aim) {
				answer+=1;
			}
			return ;
		}
		for(int i=a+1; i<=b; i++) {
			//중복 까지 넣어서 그런듯
			//visit
			//인자로 넘겨줘서 빠른듯
			//커팅 할거없음
			HashSet<Integer> newKeySet = new HashSet<>(keySet);
			
			newKeySet.add(i);
			make(i, b, c, d+1, newKeySet);
		}
	}

}
