package backjun;

import java.util.*;
import java.io.*;
public class BOJ_2573_빙산 {

	static int[][] map; 
	
	static int[] dx = { -1,1,0,0 };
	static int[] dy = { 0,0,-1,1 };
	static class store{
		int x;
		int y;
		int cnt;
		store(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static ArrayList<store> al = new ArrayList<>();
	static int n;
	static int m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		//1.입력 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 1;
		
		while(true) {
			//insert. 빙하와 인접한 면을 가진 al을 초기화.
			al = new ArrayList<>();
			boolean[][] glacialVisit = new boolean[n][m];
			
			//2. while loop 를 돌면서 0이 아닌 수를 발견하면 인접해있는 바다를 카운트하여 어레이리스트에 저장합니다. 
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]!=0) {
						int cnt = 0;
						for(int k=0; k<4; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
							if(map[nx][ny]==0)
								cnt+=1;
						}
						al.add(new store(i,j,cnt));
					}
				}
			}
			
			//3. 빙하를 깎는다.
			for(int i=0; i<al.size(); i++) {
				int adjoiningPart = al.get(i).cnt;
				if(map[al.get(i).x][al.get(i).y]-adjoiningPart<0)
					map[al.get(i).x][al.get(i).y] = 0;
				else
					map[al.get(i).x][al.get(i).y]-=adjoiningPart;
			}
			
			//insert. 빙하의 현재 모습을 출력합니다.
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			//4. 덩어리가 몇개 있는지 체크합니다. 
			int glacialKnot = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]!=0 && !glacialVisit[i][j]) {
						glacialVisit[i][j] = true;
						glacialKnot+=1; 
						glacialCountCheck(i*m+j, glacialVisit);
					}
				}
			}
			
			if(glacialKnot>=2) {
				System.out.println(year);
				break;
			}
			if(glacialKnot==0) {
				System.out.println(0);
				break;
			}
			year += 1;
		}
		
		
	}
	static void glacialCountCheck(int pos, boolean[][] glacialVisit) {
		if(pos>n*m-1) return ;
		int x = pos/m;
		int y = pos%m;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
			if(map[nx][ny]!=0 && !glacialVisit[nx][ny]) {
				glacialVisit[nx][ny] = true;
				glacialCountCheck(nx*m+ny, glacialVisit);
			}
		}
	}
}
