package backjun;
import java.util.*;
import java.io.*;
public class BOJ_12100_2048 {

	static class Info{
		int[][] map;
		Info(int[][] map){
			this.map=map;
		}
	}
	static int answer = Integer.MIN_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int[][] visit;
	static int[][] copy_map;
	static int n;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		copy_map=new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy_map[i][j]=map[i][j];
			}
		}//eofl

		arr = new int[5];
		go(0);

		System.out.println(answer);
	}
	static void go(int nn) {
		if(nn==5) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j]=copy_map[i][j];
				}
			}
			for(int i=0; i<=4; i++) {
				if(arr[i]==0) {
					up();
				}else if(arr[i]==1) {
					down();
				}else if(arr[i]==2) {
					left();
				}else if(arr[i]==3) {
					right();
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(max<map[i][j]) max = map[i][j];
				}
			}
			if(answer<max) answer = max;
		}else {
			for(int i=0; i<4; i++) {
				arr[nn]=i;
				go(nn+1);
			}
		}
	}

	static void up() {
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int temp=j;
				for(int z=0; z<j; z++) {
					//j=3
					if(map[temp-1][i]==0) {
						map[temp-1][i]=map[temp][i];
						map[temp][i]=0;

						//visit[temp-1][i]=visit[temp][i];
						visit[temp][i]=0;
						temp-=1;

					}else if(map[temp-1][i]!=0 && map[temp-1][i]==map[temp][i]
							&& visit[temp-1][i]!=1) {
						map[temp-1][i]+=map[temp][i];
						map[temp][i]=0;
						visit[temp-1][i]=1;
					}

				}
			}
		}
	}
	static void down() {
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				int temp=j;
				for(int z=n-1; z>j; z--) {
					//j=3
					if(map[temp+1][i]==0) {
						map[temp+1][i]=map[temp][i];
						map[temp][i]=0;

						//visit[temp+1][i]=visit[temp][i];
						visit[temp][i]=0;
						temp+=1;

					}else if(map[temp+1][i]!=0 && map[temp+1][i]==map[temp][i]
							&& visit[temp+1][i]!=1) {
						map[temp+1][i]+=map[temp][i];
						map[temp][i]=0;
						visit[temp+1][i]=1;
					}

				}
			}
		}
	}
	static void left() {
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int temp = j;
				for(int z=0; z<j; z++) {
					if(map[i][temp-1]==0) {
						map[i][temp-1]=map[i][temp];
						map[i][temp]=0;

						//visit[i][temp-1]=visit[i][temp];
						visit[i][temp]=0;
						temp-=1;
					}else if(map[i][temp-1]!=0 && map[i][temp-1]==map[i][temp] && visit[i][temp-1]!=1) {
						map[i][temp-1]+=map[i][temp];
						map[i][temp]=0;
						visit[i][temp-1]=1;
					}
				}

			}
		}
	}
	static void right() {
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				int temp=j;
				for(int z=n-1; z>j; z--) {
					if(map[i][temp+1]==0) {
						map[i][temp+1]=map[i][temp];
						map[i][temp]=0;
						//visit[i][temp+1]=visit[i][temp];
						visit[i][temp]=0;
						temp+=1;
					}else if(map[i][temp+1]!=0 && map[i][temp]==map[i][temp+1]
							&& visit[i][temp+1]!=1) {
						map[i][temp+1]+=map[i][temp];
						map[i][temp]=0;
						visit[i][temp+1]=1;
					}
				}
			}
		}

	}
}
