package 제7회천하제일싸피대회;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 과제안내신분 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] visit = new int[31];
		for(int i=0; i<28; i++) {
			int s = Integer.parseInt(br.readLine());
			visit[s] = 1;
		}
		for(int i=1; i<=30; i++) {
			if(visit[i] == 0) {
				System.out.println(i);
			}
		}
			
	}

}
