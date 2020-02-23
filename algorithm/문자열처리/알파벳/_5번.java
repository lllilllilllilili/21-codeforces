
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5번 {

	static int n,m;
	static char[][] map;
	static boolean[] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans = Integer.MIN_VALUE;
	static int DFS(int nn) {
		int x = nn/m;
		int y = nn%m;
		int a = 0;
		for(int i=0; i<4; i++) {
			int ddx = x + dx[i];
			int ddy = y + dy[i];
			if(ddx<0 || ddx>=n || ddy<0 || ddy>=m) continue;
			if(visit[map[ddx][ddy]-'A']==false) {
				visit[map[ddx][ddy]-'A'] = true;
				int next = DFS(ddx*m+ddy);
				if(a<next) a = next;
				visit[map[ddx][ddy]-'A'] = false;
			}
		}
		return a+1; 
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String test = st.nextToken();
			map[i] = test.toCharArray();
		}//end of for loop
		visit = new boolean[26];
		visit[map[0][0]-'A']=true;
		System.out.println(DFS(0));
		
	}

}
