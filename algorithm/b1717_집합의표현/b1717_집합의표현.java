package backjun_re;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1717_집합의표현 {

	static int n,m;
	static int[] p; 
	static int find(int x) {
		if(p[x]==x)
			return x;
		else 
			return p[x] = find(p[x]); //경로압축 
		
	}
	static void union(int x, int y) {
		int f = find(x);
		int s = find(y);
		p[f]=s;
	}
	static boolean search(int x, int y) {
		int f = find(x);
		int s = find(y);
		if(f!=s)
			return false;
		else
			return true;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		for(int i=1; i<=n; i++)
			p[i] = i;
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			if(f==0) {
				//합집합 
				union(s,l);
			}else if(f==1) {
				//포함되어 있는지 확인 
				boolean t = search(s,l);
				if(t==false) System.out.println("NO"); //포함X
				else
					System.out.println("YES"); //포함 
			}
			
		}
		
	}

}
