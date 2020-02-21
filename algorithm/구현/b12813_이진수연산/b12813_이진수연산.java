package backjun_re;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b12813_이진수연산 {

	static String a,b;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = br.readLine();
		b = br.readLine();
		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();
		char[] cc = new char[ca.length];
		for(int i=0; i<cc.length; i++) {
			cc[i] = ca[i] == '1' && cb[i] == '1' ? '1' : '0';
			System.out.print(cc[i]);
		}
		System.out.println();
		for(int i=0; i<cc.length; i++) {
			cc[i] = ca[i] == '1' || cb[i] == '1' ? '1' : '0';
			System.out.print(cc[i]);
		}
		System.out.println();
		for(int i=0; i<cc.length; i++) {
			cc[i] = ca[i] != cb[i]  ? '1' : '0';
			System.out.print(cc[i]);
		}
		System.out.println();
		for(int i=0; i<cc.length; i++) {
			cc[i] = ca[i] =='1' ? '0' : '1';
			System.out.print(cc[i]);
		}
		System.out.println();
		for(int i=0; i<cc.length; i++) {
			cc[i] = cb[i] =='1' ? '0' : '1';
			System.out.print(cc[i]);
		}
		System.out.println();
		
	}

}
