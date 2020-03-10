import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {

	private static int n,m;
	private static String[][] map;
	private static int[][] waterTime;
	private static int[][] hedgehogTime;
	private static int x,y,x2,y2,x3,y3;
	private static int ans = Integer.MAX_VALUE;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static Queue<int[]> wq = new LinkedList<>();
	private static void BFS(int x2, int y2) { //물 
		
		waterTime[x2][y2] = 1;
		while(!wq.isEmpty()) {
			int[] pos = wq.remove();
			int gox = pos[0];
			int goy = pos[1];
			
			for(int i=0; i<4; i++) {
				int ddx = gox + dx[i];
				int ddy = goy + dy[i];
				
				if(ddx<0 || ddx>=n || ddy<0 || ddy>=m) continue;
				
				if(waterTime[ddx][ddy] == 0 && !map[ddx][ddy].equals("X") && !map[ddx][ddy].equals("D")) {
					waterTime[ddx][ddy] = waterTime[gox][goy] + 1;
					wq.add(new int[] {ddx,ddy});
				}
			}
			
		}
	}
	private static void BFS2(int xt, int yt) { // 고슴도치 
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {xt,yt});
		hedgehogTime[xt][yt] =1;
		while(!q.isEmpty()) {
			int[] pos = q.remove();
			int x = pos[0];
			int y = pos[1];
			
			for(int i=0; i<4; i++) {
				int ddx = x + dx[i];
				int ddy = y + dy[i];
				
				if(ddx<0 || ddx>=n || ddy<0 || ddy>=m) continue;
				
				if(hedgehogTime[ddx][ddy] == 0 && 
						!map[ddx][ddy].equals("X") && (hedgehogTime[x][y]+1 < waterTime[ddx][ddy] || waterTime[ddx][ddy] == 0)) {
					
					hedgehogTime[ddx][ddy] = hedgehogTime[x][y]+1;
					q.add(new int[] {ddx,ddy});
				}
				if(map[ddx][ddy].equals("D")) {
					
					if(ans>hedgehogTime[x][y]+1)
						ans = hedgehogTime[x][y]+1;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][m];
		
		/**
		 * 고슴도치 위치  = S
		 */
		
		x=0;
		y=0;
		
		/**
		 * 
		 * 물의 위 = * 
		 */
		x2 = 0;
		y2 = 0;
		
		/** 비버의 집 위치
		 * 
		 * 
		 * 
		 * 
		 */
		x3 = 0;
		y3 = 0;

		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.substring(j, j+1);
				//System.out.print(map[i][j]+" ");
				if(map[i][j].equals("S")) {
					x = i;
					y = j;
				}
				if(map[i][j].equals("*")) {
					
					x2=i;
					y2=j;

					
					wq.add(new int[] {x2,y2});
					
				}
				if(map[i][j].equals("D")) {
					x3 = i;
					y3 = j;
				}
			}
			//System.out.println();
		}//end of for loop
		waterTime = new int[n][m];
		BFS(x2,y2);
		
		hedgehogTime = new int[n][m];
		BFS2(x,y);
		
		if(ans == Integer.MAX_VALUE)
			System.out.println("KAKTUS");
		else
			System.out.println(ans-1);
		
	}

}
