package backjun;

import java.util.*;
import java.io.*;
public class BOJ_17780_새로운게임 {

	static int N, K;
	static int[][] map;
	static mapPosDir[] chess;
	//말의 상태를 관리하는 구조체 배열 
	static class mapPosDir{
		int x;
		int y;
		int dir;
		boolean below; //현재 말이 가장 아래에 있는지 판단
		mapPosDir(int x, int y, int dir, boolean below){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.below = below;
		}
	}
	//맵의 좌표에 말을 둔다. 
	static ArrayList<Integer>[][] al;

	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static int reverseDirection(int dir) {
		int tempDir = dir;
		if(dir == 1) {
			tempDir = 2;
		}else if(dir == 2) {
			tempDir = 1;
		}else if(dir == 3) {
			tempDir = 4;
		}else {
			tempDir = 3;
		}
		return tempDir;
	}
	
	static boolean moveComplete() {
		for(int i=1; i<=K; i++) {
			int x = chess[i].x;
			int y = chess[i].y;
			if(al[x][y].size()>=4) return true;
		}
		return false;
	}
	static void Change_State(int x, int y, int nx, int ny, int Ms) {
		if(Ms == 0) {
			//말이 있는 경우 
			if(al[nx][ny].size()!=0) {
				for(int i=0; i<al[x][y].size(); i++) {
					int idxChess = al[x][y].get(i);
					al[nx][ny].add(idxChess);
					
					chess[idxChess].x = nx;
					chess[idxChess].y = ny;
					chess[idxChess].below=false;
				}

				al[x][y].clear();

			//말이 없는 경우 
			}else {
				for(int i=0; i<al[x][y].size(); i++) {
					int idxChess = al[x][y].get(i);
					al[nx][ny].add(idxChess);
					chess[idxChess].x = nx;
					chess[idxChess].y = ny;
					chess[idxChess].below=false;
				}
				chess[al[x][y].get(0)].below = true;
				al[x][y].clear();
			}
			
		//빨간색 칸으로 이동한 경우 
		}else if(Ms == 1) {
			
			//말이 있는 경우 
			if(al[nx][ny].size()!=0) {
				
				for(int i=0; i<al[x][y].size(); i++) {
					chess[al[x][y].get(i)].below=false;
				}
				
				for(int i=al[x][y].size()-1; i>=0; i--) {
					int idxChess = al[x][y].get(i);
					al[nx][ny].add(idxChess);
					chess[idxChess].x = nx;
					chess[idxChess].y = ny;
				}
				
				
				al[x][y].clear();
				
		
			//말이 없는 경우 
			}else {
			
				
				int size = al[x][y].size();
				int firstChessNumber = al[x][y].get(size-1);
				
				for(int i=al[x][y].size()-1; i>=0; i--) {
					int idxChess = al[x][y].get(i);
					
					al[nx][ny].add(idxChess);
					chess[idxChess].x = nx;
					chess[idxChess].y = ny;
				}
				al[x][y].clear();
				
				//옮긴 후에 다 false처리
				for(int i=0; i<al[nx][ny].size(); i++) {
					chess[al[nx][ny].get(i)].below = false;
				}
				chess[firstChessNumber].below = true;
				
			}
		}else if(Ms == 2) {
			
			int dir = reverseDirection(chess[al[x][y].get(0)].dir);
			//방향을 바꾼다 
			chess[al[x][y].get(0)].dir = dir;
			int nnx = chess[al[x][y].get(0)].x + dx[dir];
			int nny = chess[al[x][y].get(0)].y + dy[dir];
			if(nnx>=0 && nny>=0 && nnx<=N && nny<=N) {
				if(map[nnx][nny]!=2)
					Change_State(x,y,nnx,nny,map[nnx][nny]);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end of for loop
		
		
		al = new ArrayList[N+1][N+1];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				al[i][j] = new ArrayList<>();
			}
		}
		
		chess = new mapPosDir[K+1];
		
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int posX = Integer.parseInt(st.nextToken());
			int posY = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			
			chess[i] = new mapPosDir(posX, posY, dir, true);
			
			al[posX][posY].add(i);
		}
		
		
	
		int depth = 1;
		
		int answer = 0;
		
		boolean isAlreadyGo = false;
		k:while(true) {
		
			if(depth>1000) {
				answer= -1;
				break k;
			}
			
			for(int chessNumber=1; chessNumber<=K; chessNumber++) {
				if(!chess[chessNumber].below) {
					continue;
				}
				int x = chess[chessNumber].x;
				int y = chess[chessNumber].y;
				int dir = chess[chessNumber].dir;
				int nx = chess[chessNumber].x + dx[dir];
				int ny = chess[chessNumber].y + dy[dir];
				
				if( (nx<1 || nx>=N+1 || ny<1 || ny>=N+1) || map[nx][ny] == 2) {
					Change_State(x,y,nx,ny,2);
				}else {
					Change_State(x,y,nx,ny,map[nx][ny]);
				}
			}
			//기저 조건
			if(moveComplete()) {
				answer = depth;
				break k;
			}
			depth++;
		}
		System.out.println(answer);
		
	}
}
