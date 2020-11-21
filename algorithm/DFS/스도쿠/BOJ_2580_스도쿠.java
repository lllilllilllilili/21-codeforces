package backjun;

import java.util.*;
import java.io.*;
public class BOJ_2580_스도쿠 {

	
	static int[][] map = new int[9][9];
	static boolean[][] map_row = new boolean[9][10]; //행, 행값
	static boolean[][] map_col = new boolean[9][10]; //열, 열값 
	static boolean[][] map_squ = new boolean[9][10]; //몇사분면, 값
	static int square(int x, int y) {
		return (x/3)*3+(y/3);
	}
	static boolean DFS(int nn) {
		if(nn==81) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			return true;
		}//end of for loop
		int x = nn/9;
		int y = nn%9;
		
		     
		if(map[x][y]!=0) {
			DFS(nn+1);
		}else {
			for(int i=1; i<=9; i++) {
				if(map_row[x][i] == false && map_col[y][i] == false && map_squ[square(x,y)][i] == false) {
					map_row[x][i] = true;
					map_col[y][i] = true;
					map_squ[square(x,y)][i] = true;
					map[x][y] = i;
					if(DFS(nn+1))
						return true;
					map[x][y] = 0;
					map_squ[square(x,y)][i] = false;
					map_col[y][i] = false;
					map_row[x][i] = false;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					map_row[i][map[i][j]] = true;
					map_col[j][map[i][j]] = true;
					map_squ[square(i,j)][map[i][j]] = true;
				}
			}//end of for second loop
		}//end of for first loop
	
		DFS(0);
	}
}
