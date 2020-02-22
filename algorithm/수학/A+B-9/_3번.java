package SSAFY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _3번 {

	static int n,m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		BigInteger first = new BigInteger(a);
		BigInteger second = new BigInteger(b);
		BigInteger result = first.add(second);
		System.out.println(result);
		
		
	}

}
