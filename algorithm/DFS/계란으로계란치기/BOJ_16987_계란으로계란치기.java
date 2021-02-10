import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int n, cnt, ans = Integer.MIN_VALUE;
	private static int[] s; private static int[] w;
	private static void DFS(int nn) {
		if(nn==n) {
			//갱신
			for(int i=0; i<n; i++) {
				if(s[i]<=0) cnt+=1;
			}
			if(ans<cnt)
				ans = cnt;
			cnt = 0;
			return ;
		}


		boolean find = false;
		if(s[nn]<0)
			DFS(nn+1);
		else {
			for(int i=0; i<n; i++) {
				if(i==nn) continue;
				if(s[i]>0) {
					find = true;
					s[nn] -=w[i];
					s[i] -=w[nn];
					DFS(nn+1);
					s[nn] +=w[i];
					s[i] +=w[nn];
				}
			}
			if(find == false) DFS(nn+1);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n];	w = new int[n];
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			s[i] = Integer.parseInt(str[0]);
			w[i] = Integer.parseInt(str[1]);
		}//end of for loop
		StringBuilder sb = new StringBuilder();
		DFS(0);
		sb.append(ans).append("\n");
		System.out.println(sb);
	}

}
