package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjun_2048 {

	static int n;
	static int ans = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] c_map;
	static int[] ar;
	static void up() {
		int[][] visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int temp = j;
				for(int z=0; z<j; z++) {
					if(map[temp-1][i]==0) {
						map[temp-1][i] = map[temp][i];
						map[temp][i] = 0;
						temp -=1;
						visit[temp][i] = 0;
					}else if(map[temp-1][i]!=0 && visit[temp-1][i]==0) {
						if(map[temp-1][i] == map[temp][i]) {
							map[temp-1][i]+=map[temp][i];
							map[temp][i] = 0;
							visit[temp-1][i] = 1;
						}
					}
				}
			}
		}
	}
	static void down() {
		int[][] visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				int temp = j;
				for(int z=n-1; z>j; z--) {
					if(map[temp+1][i]==0) {
						map[temp+1][i] = map[temp][i];
						map[temp][i] = 0;
						temp +=1;
						visit[temp][i] = 0;
					}else if(map[temp+1][i]!=0 && visit[temp+1][i]==0) {
						if(map[temp+1][i] == map[temp][i]) {
							map[temp+1][i]+=map[temp][i];
							map[temp][i] = 0;
							visit[temp+1][i] = 1;
						}
					}
				}
			}
		}
	}
	static void left() {
		int[][] visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int temp = j;
				for(int z=0; z<j; z++) {
					if(map[i][temp-1]==0) {
						map[i][temp-1] = map[i][temp];
						map[i][temp] = 0;
						temp -=1;
						visit[i][temp] = 0;
					}else if(map[i][temp-1]!=0 && visit[i][temp-1]==0) {
						if(map[i][temp-1] == map[i][temp]) {
							map[i][temp-1]+=map[i][temp];
							map[i][temp] = 0;
							visit[i][temp-1] = 1;
						}
					}
				}
			}
		}
	}
	static void right() {
		int[][] visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				int temp = j;
				for(int z=n-1; z>j; z--) {
					if(map[i][temp+1]==0) {
						map[i][temp+1] = map[i][temp];
						map[i][temp] = 0;
						temp +=1;
						visit[i][temp] = 0;
					}else if(map[i][temp+1]!=0 && visit[i][temp+1]==0) {
						if(map[i][temp+1] == map[i][temp]) {
							map[i][temp+1]+=map[i][temp];
							map[i][temp] = 0;
							visit[i][temp+1] = 1;
						}
					}
				}
			}
		}
	}
	static void go(int nn) {
		if(nn==5) {
			for(int i=0; i<n; i++)
				System.arraycopy(c_map[i], 0, map[i], 0, c_map[i].length);
			for(int i=0; i<=4; i++) {
				if(ar[i]==0) {
					up();
				}else if(ar[i]==1) {
					down();
				}else if(ar[i]==2) {
					left();
				}else if(ar[i]==3) {
					right();
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(max<map[i][j]) max = map[i][j];
				}
			}
			if(ans<max) ans = max;
			
			
		}else {
			for(int i=0; i<4; i++) {
					
					ar[nn] = i;
					go(nn+1);
					
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		c_map = new int[n][n]; 
		StringTokenizer st = null;
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				c_map[i][j] = map[i][j];
			}
		}//end of for loop
		ar = new int[5];
		
		go(0);

		System.out.println(ans);
	}

}
