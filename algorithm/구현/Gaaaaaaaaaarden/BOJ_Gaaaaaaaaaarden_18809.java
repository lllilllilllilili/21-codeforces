import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] pre_map;
	static int[] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int G, R;
	static int x, y;
	static int rearAns = Integer.MIN_VALUE;
	static class POS {
		int x;
		int y;
		POS(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static class TIME{
		int x;
		int y;
		int t;
		int nextNumber;
		TIME(int x, int y, int time, int nextNumber){
			this.x = x;
			this.y = y;
			this.t = time;
			this.nextNumber = nextNumber;
		}
	}
	static ArrayList<POS> al = new ArrayList<>();
	static Queue<TIME> q = new LinkedList<>();

	static void cultureFluidGreen(int nn, int index) {
		if(nn==G) {
			cultureFluidRed(0,0);
		}else {
			for(int i=index; i<al.size(); i++) {
				//배양액을 뿌릴 수 있는 개수 만큼 돌아보고
				if(visit[i] == 0) {
					visit[i] = 1;
					int gx = al.get(i).x;
					int gy = al.get(i).y;
					pre_map[gx][gy] = 3; //초록색은 3으로 지정한다. 
					cultureFluidGreen(nn+1, i+1);
					pre_map[gx][gy] = map[gx][gy];
					visit[i] = 0;
				}
			}
		}
	}

	static void cultureFluidRed(int nn, int index) {
		if(nn==R) {
			makeFlower();
		}else {
			for(int i=index; i<al.size(); i++) {
				if(visit[i] == 0) {
					visit[i] = 1;
					int rx = al.get(i).x;
					int ry = al.get(i).y;
					pre_map[rx][ry] = 4; //레드는 4으로 지정한다.
					cultureFluidRed(nn+1, i+1);
					pre_map[rx][ry] = map[rx][ry];
					visit[i] = 0;
				}
			}
		}
	}
	static void cultureFluidInsertQueue() {
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				if(pre_map[i][j] == 3)
					q.add(new TIME(i,j,1,3));

				if(pre_map[i][j] == 4)
					q.add(new TIME(i,j,1,4));
			}//end of if 
		}//end of for
	}//end of function

	static void makeFlower() {
		cultureFluidInsertQueue();

		int[][][] temp = new int[x][y][2];
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++){
				temp[i][j][0] = pre_map[i][j];
				// System.out.print(temp[i][j][0]+" ");
			}
			// System.out.println();
		}

		int flower = 0;

		while(!q.isEmpty()) {
			TIME t = q.poll();
			int goX = t.x;
			int goY = t.y;
			int time = t.t;
			int nextNumber = t.nextNumber;

			if(temp[goX][goY][0] == 5) continue;

			for(int i=0; i<4; i++) {
				int nx = goX+dx[i];
				int ny = goY+dy[i];

				if(nx<0 || ny<0 || nx==x || ny==y) continue;
				if(temp[nx][ny][0] == 0 || temp[nx][ny][0] ==5) continue;

				if(temp[nx][ny][0] == 1 || temp[nx][ny][0] == 2){
					temp[nx][ny][0] = nextNumber;
					temp[nx][ny][1] = time;
					q.add(new TIME(nx,ny,time+1,nextNumber));
				}else if(temp[nx][ny][0] == 3 && nextNumber == 4 && time == temp[nx][ny][1]){
					temp[nx][ny][0] = 5;
					flower++;
				}else if(temp[nx][ny][0] == 4 && nextNumber == 3 && time == temp[nx][ny][1]){
					temp[nx][ny][0] = 5;
					flower++;
				}
			}//end of for loop
		}//end of while loop

		//업데이트
		rearAns = Math.max(rearAns, flower);
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[x][y];
		pre_map = new int[x][y];

		for(int i=0; i<x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<y; j++) {
				pre_map[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					al.add(new POS(i,j));
				}
			}//end of first loop
		}//end of second loop

		//배양액을 뿌릴 수 있는곳 개수 만큼 visit 배열 생성
		visit = new int[al.size()];

		//visit 으로 G, R를 뿌릴 위치를 찾는다. al.size() 만큼 
		cultureFluidGreen(0,0);
		System.out.println(rearAns);
	}
}