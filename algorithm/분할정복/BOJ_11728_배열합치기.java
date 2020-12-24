package backjun;

import java.util.*;
import java.io.*;
public class BOJ_11728_배열합치기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.valueOf(line[0]);
		int m = Integer.valueOf(line[1]);
		int[] a = new int[n];
		line = br.readLine().split(" ");
		//1.입력
		for(int i=0; i<n; i++) {
			a[i] = Integer.valueOf(line[i]);
		}
		int[] b = new int[m];
		line = br.readLine().split(" ");
		for(int i=0; i<m; i++) {
			b[i] = Integer.valueOf(line[i]);
		}
		
		//2.임시배열 값을 생성해서 a,b 배열의 작은값을 차례대로 담습니다. 
		int[] c = new int[n+m];
		{
			int i=0;
			int j=0;
			int k=0;
			//3.n,m 범위 안에서 값의 대소비교를 수행합니다. 
			while(i<n || j<m) {
				//4.j가 m의 범위를 넘어서면 j는 이미 임시배열안에 다 채워진것이기 때문에 대소비교할 필요없이 i번째 데이터를 c 배열에 추가해줍니다.
				//4-1. a[i] 번째 값을 임시배열에 넣는것이므로 a[i]<=b[j] 만족시켜야 합니다. 
				if(j>=m || (i<n && a[i]<=b[j])) {
					c[k++] = a[i++];
				}else {
					//5. 그렇지 않은 경우 b[j]값을 임시배열에 저장합니다. 
					c[k++] = b[j++];
				}
			}
		}//end 
		//6.속도를 향상시키기 위해서 StringBuilder 사용 > System.out.println 보다 속도가 빠르므로 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n+m; i++) {
			sb.append(c[i]+" ");
		}
		System.out.println(sb);
	}

}
