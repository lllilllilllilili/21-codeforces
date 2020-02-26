package 제7회천하제일싸피대회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {

	static int n,m;
	static String[] c;
	static void dfs(int nn, int index, String str) {
		if(nn==n) {
			String[] c = {"a","e","i","o","u"};
			int cnt = 0;
			for(int i=0; i<c.length; i++) {
				if(str.contains(c[i])) {
					cnt +=1;
				}
			}
			String[] k = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
			int cnt2 = 0;
			for(int i=0; i<k.length; i++) {
				if(str.contains(k[i])) cnt2+=1;
			}
			if(cnt>=1 && cnt2>=2)
				System.out.println(str);
		}else {
			for(int j=index; j<c.length; j++) {
				dfs(nn+1,j+1,str+c[j]);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = new String[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			c[i] = st.nextToken();
		}
		Arrays.sort(c);
		dfs(0,0,"");
	}

}
