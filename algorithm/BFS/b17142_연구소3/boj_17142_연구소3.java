package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17142_연구소3 {

	static class Pair{
		int x; int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int n, virus;
	static int[][] laboratory;
	static int[][] time;
	static int[] select;
	static ArrayList<Pair> al = new ArrayList<>();
	static int ans = -1;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void BFS() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				time[i][j] = -1;
			}
		}//time init 
		
		Queue<Pair> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(laboratory[i][j] == -3) { //활성 바이러스를 큐에 다 넣는다. 
					q.add(new Pair(i,j));
					time[i][j] = 0;
				}
			}
		}//활성 바이러스인 영역은 시간을 0 으로 세팅 
		
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int ddx = p.x + dx[i];
				int ddy = p.y + dy[i];
				if(ddx<0 || ddx>=n || ddy<0 || ddy>=n) continue;
				if(laboratory[ddx][ddy] !=1 && time[ddx][ddy] == -1) {
					//벽이 아니고, 바이러스인곳이 아니라면 
					time[ddx][ddy] = time[p.x][p.y]+1;
					q.add(new Pair(ddx,ddy));
				}
			}
		}//end of while loop
		
		int cur = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(laboratory[i][j] == 0) { //바이러스인곳 
					if(time[i][j]==-1) return;
					if(cur<time[i][j]) cur = time[i][j]; //최소시간을 업데이트
				}
			}
		}
		
		if(ans == -1 || ans>cur) ans =cur; //최솟값 갱신
	}
	static void go(int nn, int index) {
		if(nn==virus) {
			BFS();
			
		}else {
			for(int i=index; i<al.size(); i++) {
				select[nn] = i;
				laboratory[al.get(select[nn]).x][al.get(select[nn]).y] = -3; //활성 
				go(nn+1, i+1);
				laboratory[al.get(select[nn]).x][al.get(select[nn]).y] = -2; //비활성
				
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		virus = Integer.parseInt(st.nextToken());
		laboratory = new int[n][n];
		time = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				laboratory[i][j] = Integer.parseInt(st.nextToken());
				if(laboratory[i][j] == 2) {
					laboratory[i][j] = -2; 
					al.add(new Pair(i,j));
				}
			}
		}//end of for loop
		//0은 빈 칸, 1은 벽, 2는 바이러스
		select = new int[virus];
		go(0,0);
		System.out.println(ans);
	}
}
