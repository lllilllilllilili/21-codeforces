package backjun;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class POS{
	int x;
	int y;
	int cnt;
	POS(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt = cnt;
	}
}
public class BOJ_7576_토마토_2 {

	static int[][] map;
	static int[][] visit;
	static int a;
	static int b;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	static int ans =0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<POS> q = new LinkedList<>();
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		map = new int[b][a];
		visit = new int[b][a];
		
		for(int i=0; i<b; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<a; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==1) {
					q.add(new POS(i,j,0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			POS sxx = q.remove();
			int tempx = sxx.x;
			int tempy = sxx.y;
			int tempcnt = sxx.cnt;
			
			for(int as=0; as<4; as++) {
				int ddx = tempx + dx[as];
				int ddy = tempy + dy[as];
				
				if(0<=ddx && ddx<b && 0<=ddy && ddy<a && map[ddx][ddy]!=-1 && map[ddx][ddy]!=1) {
					map[ddx][ddy] = 1;
					ans = tempcnt+1;
					q.add(new POS(ddx,ddy,tempcnt+1));
				}
			}
			
		}
		for(int f=0; f<b; f++) {
			for(int c=0; c<a; c++) {
				if(map[f][c] ==0)
					ans = -1;
			}
		}
		System.out.println(ans);
		
	}

}
