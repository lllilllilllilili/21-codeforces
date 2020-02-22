package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 완전제곱수 {

	static int m;
	static int n; 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=1; i<=100; i++) {
			int s = i * i;
			if(s>=m && s<=n) {
				al.add(s);
			}
		}//end of for loop
		int sum = 0;
		for(int i=0; i<al.size(); i++) {
			sum += al.get(i);
		}//end of for loop
		
		if(al.size() == 0)
			System.out.println(-1);
		else
			System.out.println(sum+" "+al.get(0));
		
	}

	
}
