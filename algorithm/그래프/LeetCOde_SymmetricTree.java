package programmers;

import java.util.*;
import java.io.*;
public class BOJ_5052_전화번호목록 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int total = Integer.parseInt(br.readLine());
		for(int i=0; i<total; i++) {
			int next = Integer.parseInt(br.readLine());
			String[] arr = new String[next];
			for(int j=0; j<next; j++) {
				arr[j] = br.readLine().replace(" ", "");
			}//end of for loop

			Arrays.sort(arr);
			boolean judge = true;
			for(int j=0; j<next-1; j++) {
				if(arr[j].length()<arr[j+1].length()) {
					if(arr[j+1].indexOf(arr[j])>-1) {
						judge = false;
						break;
					}
				}
			}//end of for loop
			if(judge == true) {
				sb.append("YES\n");
			}else
				sb.append("NO\n");
		}
		System.out.println(sb.toString());

	}
}
