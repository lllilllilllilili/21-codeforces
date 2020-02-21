package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 명령프롬프트_1032 {

	static int n;
	static char[][] str;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		str = new char[n][50];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			str[i] = s.toCharArray();
		}
		
		ArrayList<Character> a = new ArrayList<>();
		for(int i =0; i<str[0].length; i++) {
			boolean find = false;
			for(int j=1; j<n; j++) {
				if(str[0][i] != str[j][i])
					find = true;
			}
			if(find == false)
				a.add(str[0][i]);
			else
				a.add('?');
		}
		String b = "";
		for(int i=0; i<a.size(); i++)
			b += a.get(i);
		System.out.println(b);
	}

}
