package backjun;

import java.util.*;
import java.io.*;
public class BOJ_14890_경사로 {

	static int[][] map;
	static int answer = 0;
	static boolean[][] visit;
	static int n,l;
	
	static boolean boundOutAndSub(int bx, int by, int ax, int ay, int expression) {
		if(Math.abs(map[bx][by]-map[ax][ay])>1 || expression<0 || expression>=n) {
			return true;
		}else
			return false; 
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end of for loop
		
		//오른쪽
		visit = new boolean[n][n];
		boolean[] row = new boolean[n];
		boolean[] column = new boolean[n];
		for(int i=0; i<n; i++) {
			boolean flag=false;
			k:for(int j=0; j<n-1; j++) {
				if(map[i][j]<map[i][j+1]) {
					if(boundOutAndSub(i,j,i,j+1,j-(l-1))) {
						flag=true;
						break;
					}
					
					for(int k=0; k<l; k++) {
						if(visit[i][j-k]) {
							flag=true;
							break k;
						}else
							visit[i][j-k]=true;
					}
					
					int tempj =j;
					for(int k=0; k<l-1; k++) {
						if(map[i][tempj]!=map[i][tempj-1]) {
							flag=true;
							break k;
						}
						tempj-=1;
					}
				//왼쪽이 더 큰 값을 만남
				}else if(map[i][j]>map[i][j+1]) {
					if(boundOutAndSub(i,j,i,j+1, j+1+(l-1))) {
						flag=true;
						break;
					}
					
					int tempj=j+1;
					for(int k=0; k<l; k++) {
						if(visit[i][tempj+k]) {
							flag=true;
							break k;
						}else
							visit[i][tempj+k]=true;
					}
					tempj=j+1;
					for(int k=0; k<l-1; k++) {
						if(map[i][tempj]!=map[i][tempj+1]) {
							flag=true;
							break k;
						}
						tempj+=1;
					}
				}
			}
			if(flag==false)
				row[i]=true;
			
		}
		
		
		//왼쪽
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			boolean flag=false;
			if(row[i]) continue;
			k:for(int j=n-1; j>=1; j--) {
				//오른쪽이 더 큼
				if(map[i][j]>map[i][j-1]) {
					if(boundOutAndSub(i,j,i,j-1,j-1-(l-1))) {
						flag=true;
						break;
					}
					for(int k=1; k<=l; k++) {
						if(visit[i][j-k]) {
							flag=true;
							break k;
						}else
							visit[i][j-k]=true;
					}					
					int tempj=j-1;
					for(int k=0; k<l-1; k++) {
						if(map[i][tempj]!=map[i][tempj-1]) {
							flag=true;
							break k;
						}
						tempj+=1;
					}
					
				
					
					
				//왼쪽이 더 큼
				}else if(map[i][j]<map[i][j-1]) {
					if(boundOutAndSub(i,j,i,j-1,j+(l-1))) {
						flag=true;
						break;
					}
					for(int k=0; k<l; k++) {
						if(visit[i][j+k]) {
							flag=true;
							break k;
						}else{
							visit[i][j+k]=true;
						}
					}

					
					int tempj=j;
					for(int k=0; k<l-1; k++) {
						if(map[i][tempj]!=map[i][tempj+1]) {
							flag=true;
							break k;
						}
						tempj+=1;
					}
					
					
				}
			}
			if(flag==false)
				row[i]=true;
			
		}
		//아래쪽
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			boolean flag=false;
			k:for(int j=n-1; j>=1; j--) {
				//더 아래쪽 있는것이 큼
				if(map[j][i]>map[j-1][i]) {
					if(boundOutAndSub(j,i,j-1,i,j-1-(l-1))) {
						flag=true;
						break;
					}
					int tempj =j-1;
					for(int k=0; k<l-1; k++) {
						if(map[tempj][i]!=map[tempj-1][i]) {
							flag=true;
							break k;
						}
						tempj-=1;
					}
					//겹치면 안되니까 2칸 확보! 
					tempj=j-1;
					for(int k=0; k<l; k++) {
						if(visit[tempj-k][i]) {
							flag=true;
							break k;
						}else
							visit[tempj-k][i]=true;
					}
					
					
				//더 위쪽에 있는것이 큼
				}else if(map[j][i]<map[j-1][i]) {
					if(boundOutAndSub(j,i,j-1,i,j+(l-1))){
						flag=true;
						break;
					}
					for(int k=0; k<l; k++) {
						if(visit[j+k][i]) {
							flag=true;
							break k;
						}else {
							visit[j+k][i]=true;
						}
					}

					int tempj =j;
					for(int k=0; k<l-1; k++) {
						if(map[tempj][i]!=map[tempj+1][i]) {
							flag=true;
							break k;
						}
						tempj+=1;
					}
					
				}
			}
			if(flag==false)
				column[i]=true;
			
		}
		//위쪽
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			boolean flag=false;
			if(column[i]) continue;
			k:for(int j=0; j<n-1; j++) {
				//위쪽이 더 큼
				if(map[j][i]>map[j+1][i]) {
					if(boundOutAndSub(j,i,j+1,i,j+1+(l-1))) {
						flag=true;
						break;
					}
					int tempj=j+1;
					for(int k=0; k<l; k++) {
						if(visit[tempj+k][i]) {
							flag=true;
							break k;
						}else
							visit[tempj+k][i]=true;
					}
					tempj =j+1;
					for(int k=0; k<l-1; k++) {
						if(map[tempj][i]!=map[tempj+1][i]) {
							flag=true;
							break k;
						}
						tempj+=1;
					}

					
				//아래쪽이 더 크다.
				}else if(map[j][i]<map[j+1][i]){
					if(boundOutAndSub(j,i,j+1,i,j-(l-1))) {
						flag=true;
						break;
					}
					for(int k=0; k<l; k++) {
						if(visit[j-k][i]) {
							flag=true;
							break k;
						}else
							visit[j-k][i]=true;
					}

					int tempj =j;
					for(int k=0; k<l-1; k++) {
						if(map[tempj][i]!=map[tempj-1][i]) {
							flag=true;
							break k;
						}
						tempj-=1;
					}

				}
			}
			if(flag==false)
				column[i]=true;
		
		}	
		for(int i=0; i<row.length; i++) {
			if(row[i])
				answer+=1;
			if(column[i])
				answer+=1;
		}
		
		System.out.println(answer);
	}
}
