package backjun_re;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1941_소문난칠공주 {

	static char[][] map;
	static int[][] cmap;
	static int[] arr;
	static boolean[] visit;
	static int count = 0;
	static int ans = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void DFS2(int nn) {
		if(count==7) {
			ans +=1;
			count=0;
			return ;
		}else {
			for(int i=0; i<4; i++) {
				int nx = (nn/5)+dx[i];
				int ny = (nn%5)+dy[i];
				if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
				else {
					if(visit[nx*5+ny]==false && cmap[nx][ny] == 1 )
					{
						visit[nx*5+ny]=true;
						count+=1;
						DFS2(nx*5+ny);
					}
				}
			}
		}
	}
	static void DFS(int nn, int index) {
		if(nn==7) {
			int s = 0;
			for(int i=0; i<arr.length; i++) {if(map[arr[i]/5][arr[i]%5]=='S')s+=1;}
			if(s>=4) {
				for(int i=0; i<arr.length; i++)
					cmap[arr[i]/5][arr[i]%5] = 1;
				for(int i=0; i<5; i++) {
					for(int j=0; j<5; j++) {
						if(visit[i*5+j]==false && cmap[i][j] == 1) {
							visit[i*5+j]=true;
							count+=1;
							DFS2(i*5+j);
						}
					}
				}
				Arrays.fill(visit, false);
				for(int z=0; z<5; z++)
					Arrays.fill(cmap[z], 0);
			}
			return ; 
		}
		for(int i=index; i<25; i++) {
			int temp = arr[nn];
			arr[nn] = i;
			DFS(nn+1,i+1);
			arr[nn] = temp;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		cmap = new int[5][5];
		arr = new int[7];
		visit = new boolean[25];
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			char[] s2 = s.toCharArray();
			for(int j=0; j<5; j++) {
				map[i][j] = s2[j];
			}
		}
		
		DFS(0,0);
		System.out.println(ans);
	}

}
