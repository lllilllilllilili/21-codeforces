package backjun;

import java.util.*;
import java.io.*;
public class BOJ_13460_구슬탈출2 {

	static char[][] map;
	static boolean[][][][] visit;
	static int n,m;
	static int[] redHolePos=new int[2];
	static int[] blueHolePos=new int[2];


	static class Info{
		int rx;
		int ry;
		int bx;
		int by;
		int cnt;
		Info(int rx, int ry, int bx, int by, int cnt){
			this.rx=rx;
			this.ry=ry;
			this.bx=bx;
			this.by=by;
			this.cnt=cnt;
		}
	}
	static int answer = Integer.MAX_VALUE;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		int bx=0, by=0;
		int rx=0, ry=0;
		int hx=0, hy=0;
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j]=line.charAt(j);
				if(map[i][j]=='B') {
					bx=i;
					by=j;
					map[i][j]='.';
				}else if(map[i][j]=='R') {
					rx=i;
					ry=j;
					map[i][j]='.';
				}else if(map[i][j]=='O') {
					hx=i;
					hy=j;
				}
			}
		}//eofl

		visit = new boolean[n][m][n][m];
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(rx, ry, bx, by, 1));
		int go =0;

		while(!q.isEmpty()) {

			Info s = q.poll();
			if(s.cnt>10) continue;
			for(int i=0; i<4; i++) {
				int tempRx=s.rx;
				int tempRy=s.ry;
				int tempBx=s.bx;
				int tempBy=s.by;
				int redCnt=0;
				int blueCnt=0;
				redHolePos=new int[2];
				blueHolePos=new int[2];

				boolean redHole = false;
				boolean blueHole=false;
//				System.out.println(i +"번! 0번오른쪽 1번왼쪽 2번아래쪽 3번위쪽 ");
//				System.out.println("Red");
				//빨강 굴리기
				while(!outbound(tempRx+dx[i],tempRy+dy[i]) && map[tempRx+dx[i]][tempRy+dy[i]]!='#') {
					tempRx=tempRx+dx[i];
					tempRy=tempRy+dy[i];
//					System.out.println(tempRx+" "+tempRy);
					if(goRedHole(tempRx,tempRy)) {
						redHole=true;
						break;
					}
					redCnt+=1;
				}
//				System.out.println("-----------------");
//
//				System.out.println("Blue");
				//파랑 굴리기
				while(!outbound(tempBx+dx[i], tempBy+dy[i]) && map[tempBx+dx[i]][tempBy+dy[i]]!='#') {
					tempBx=tempBx+dx[i];
					tempBy=tempBy+dy[i];
//					System.out.println(tempBx+" "+tempBy);
					if(goBlueHole(tempBx,tempBy)) {
						blueHole=true;
						break;
					}
					blueCnt+=1;
				}
//				System.out.println("-----------------");
				if(redHole && !blueHole) {
					if(answer>s.cnt)
						answer=s.cnt;
					continue;
				}
				//파란 구슬이 구멍에 빠지면 실패다.
				if(!redHole && blueHole) continue;

				//파란 구슬과 빨간 구슬이 동시에 빠지면 실패다.
				if(redHole && blueHole && redHolePos[0]==blueHolePos[0] && redHolePos[1]==blueHolePos[1]) continue;

				//거리계산해서 거리 작은애를 좌표 -1 해주기
				if(tempRx==tempBx && tempRy==tempBy) {
					if(redCnt<blueCnt) {
						tempBx-=dx[i];
						tempBy-=dy[i];
					}else {
						tempRx-=dx[i];
						tempRy-=dy[i];
					}
				}
				if(visit[tempRx][tempRy][tempBx][tempBy])
					continue;
				else
					visit[tempRx][tempRy][tempBx][tempBy]=true;

				q.add(new Info(tempRx,tempRy,tempBx,tempBy,s.cnt+1));

			}//eofl
		}
		if(answer==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);


	}
	static boolean goRedHole(int rx, int ry) {
		if(map[rx][ry]=='O')return true;
		else
			return false;
	}
	static boolean goBlueHole(int bnx, int bny) {
		if(map[bnx][bny]=='O')return true;
		else
			return false;
	}
	static boolean outbound(int nx, int ny) {
		if(nx<0 || nx>=n || ny<0 || ny>=m) return true;
		return false;
	}
}
