
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4번 {

	static int n,m;
	static char[][] s;
	static int[][] visit;
	static int[][] cost;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static String str = "";
	static int cnt = 1;
	static int ans = Integer.MIN_VALUE;
	static void DFS(int nn, int cnt) {
		if(ans<cnt) ans = cnt;
		for(int i =0; i<4; i++) {
			int ddx = (nn/m) + dx[i];
			int ddy = (nn%m) + dy[i];
			if(ddx<0 || ddx>=n || ddy<0 || ddy>=m) continue;
			String temp = "";
			temp += s[ddx][ddy];
			if(visit[ddx][ddy]==0 && !str.contains(temp)) {
				visit[ddx][ddy] = 1;
				String k = str;
				str+=s[ddx][ddy];
				
				DFS(ddx*m+ddy,cnt+1);
				str = k;
				visit[ddx][ddy] = 0;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = new char[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String tte = st.nextToken();
			s[i] = tte.toCharArray();
		}//end of for loop
		
		visit = new int[n][m];
		str += s[0][0];
		visit[0][0] = 1;
		DFS(0,1);
		System.out.println(ans);
	}

}
