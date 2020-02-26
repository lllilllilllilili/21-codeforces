package 제7회천하제일싸피대회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 맞았는데왜틀려 {

	static int s1, s2;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s1 = Integer.parseInt(st.nextToken());
		s2 = Integer.parseInt(st.nextToken());
		
		
		boolean s1_flag = false;
		for(int i=0; i<s1; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			if(first != second) {
				s1_flag = true; 
				break;
			}
		}
		
			boolean s2_flag = false;
			for(int j=0; j<s2; j++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				if(first != second) {
					
					s2_flag = true;
					break;
				}
			}//end of for loop
	
		
	if(s1_flag == false && s2_flag == false) System.out.println("Accepted");
	else if(s1_flag ==true && s2_flag ==false) System.out.println("Wrong Answer");
	else
		System.out.println("Why Wrong!!!");
		
	

}
}
