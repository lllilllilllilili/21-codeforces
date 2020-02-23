package SSAFY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7번 {

	static int n,m;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int left = 0; 
		int right =0; 
		int ans = 0;
		int sum = arr[0];
		while(left<=right && right<n) {
		
			if(sum<m) {
				right +=1;
				if(right<n)
					sum += arr[right];
			}else if(sum == m) {
				right+=1;
				ans +=1;
//				if(right<n)
					sum += arr[right];
			}else if(sum>m){
				
					sum -= arr[left];

//					if(left<n)
						left+=1;
						if (left > right && left < n) {
		                    right = left;
		                    sum = arr[left];
		                }
			}
			
		}//end of for loop
		System.out.println(ans);
	}

}
