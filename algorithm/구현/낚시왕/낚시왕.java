package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 낚시왕 {

	static int r,c,cnt;
	static int map[][];
	static shark[] sarr = new shark[10001];
	static class shark{
		int x;
		int y;
		int speed;
		int dir;
		int z; //크기 
		shark(int x, int y, int speed, int dir, int z){
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.z = z;
		}
	}//class 
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		cnt = Integer.parseInt(st.nextToken());
		map = new int[r+1][c+1];
		
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			int ts = Integer.parseInt(st.nextToken());
			int td = Integer.parseInt(st.nextToken());
			int tz = Integer.parseInt(st.nextToken());
			
			sarr[tz] = new shark(tx,ty,ts,td-1,tz);
			map[tx][ty] = tz;
			//tz 로 상어를 참조한다. 
		}//end of for loop
		
		int ans = 0;
		for(int i=1; i<=c; i++) {
			//상어를 잡고 
			for(int j=1; j<=r; j++) {
				if(map[j][i]!=0) {
					ans += map[j][i]; //맵에 있는 상어 크기를 잡는다.
					sarr[map[j][i]] = null; //상어정보 삭제 
					map[j][i] = 0; //상어 지운다. 
					break; //상어를 잡았으니 탈출 
				}
			}//end of first for loop
			
			//상어가 움직이고
			for(int j=1; j<=10000; j++) {
				//상어무게가 1 부터 10000 이 있다.
				if(sarr[j] == null) continue;
				shark baby = sarr[j]; //j크기를 가진 상어를 빼온다.
				int baby_x = baby.x;
				int baby_y = baby.y; 
				//좌표 가져온다.
				int baby_speed = baby.speed;
				//스피드
				int baby_dir = baby.dir;
				//방향
				int baby_size = baby.z;
				//크기
				int move = 0;
				map[baby_x][baby_y]=0;
				if(baby_dir == 0) {
					//위
					move = baby_speed%((r-1)*2);
					while(move>0) {
						
						if(baby_x==1) {
							//처음 위치
							//{ -1, 1,0,0 }
							baby_dir = 1;
							//내려간다.
						}else if(baby_x==r) {
							baby_dir = 0;
							//올라간다.
						}
						baby_x += dx[baby_dir];
						move-=1;
					}
					sarr[baby_size] = new shark(baby_x, baby_y, baby_speed, baby_dir, baby_size);
				}else if(baby_dir == 1) {
					//아래
					move = baby_speed%((r-1)*2);
					while(move>0) {
						if(baby_x==1) {
							//처음 위치
							//{ -1, 1,0,0 }
							baby_dir = 1;
							//내려간다.
						}else if(baby_x==r) {
							baby_dir = 0;
							//올라간다.
						}
						baby_x += dx[baby_dir];
						move-=1;
					}
					sarr[baby_size] = new shark(baby_x, baby_y, baby_speed, baby_dir, baby_size);
				}else if(baby_dir == 2) {
					//오른쪽
					move = baby_speed%((c-1)*2);
					while(move>0) {
						if(baby_y==1) {
							//처음 위치
							//{0,0, 1, -1 }
							baby_dir = 2;
							//오른쪽으로
						}else if(baby_y==c) {
							baby_dir = 3;
							//왼쪽으로
						}
						baby_y += dy[baby_dir];
						move-=1;
					}
					sarr[baby_size] = new shark(baby_x, baby_y, baby_speed, baby_dir, baby_size);
				}else if(baby_dir == 3) {
					//왼쪽 
					move = baby_speed%((c-1)*2);
					while(move>0) {
						if(baby_y==1) {
							//처음 위치
							//{ 0, 0, 1, -1}
							baby_dir = 2;
							//오른쪽으로
						}else if(baby_y==c) {
							baby_dir = 3;
							//왼쪽으로
						}
						baby_y += dy[baby_dir];
						move-=1;
					}
					sarr[baby_size] = new shark(baby_x, baby_y, baby_speed, baby_dir, baby_size);
				}
			}//상어 이동 완료
			
			for(int j=1; j<=10000; j++) {
				if(sarr[j]==null) continue;
				shark sa = sarr[j];
				int curr_x = sa.x;
				int curr_y = sa.y;
				int curr_size = sa.z;
				if(map[curr_x][curr_y]<curr_size) {
					//이동한 크기가 맵에 저장된 크기보다 크다면 
					sarr[map[curr_x][curr_y]] = null;
					//기존의 사이즈를 가지고 있는 상어는 잡아먹힌다. 
					map[curr_x][curr_y] = curr_size;
					
				}
			}
			
			//중복된 상어는 서로 잡아먹고
			
		}
		System.out.println(ans);
		
	}

}
