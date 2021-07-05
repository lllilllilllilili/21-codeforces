package programmers;

import java.util.*;
import java.io.*;
public class nQueen {

	static int[][] map;
	static boolean[][] a = new boolean[15][15];
	static boolean[] ccol = new boolean[15];
	static boolean[] cdig = new boolean[30];
	static boolean[] cdig2 = new boolean[30];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		System.out.println(DFS(0, N));
	}
	static int DFS(int row, int N) {
		if(row == N) {
			return 1;
		}else {
			int cnt = 0;
			for(int col = 0; col<N; col++) {
				if(check(row, col, N)) {
					ccol[col] = true;
					cdig[row+col] = true;
					cdig2[row-col+(N-1)] = true;
					cnt+= DFS(row+1, N);
					cdig2[row-col+(N-1)] = false;
					cdig[row+col] = false;
					ccol[col] = false;
					
				}
			}
			return cnt;
		}//end of else
		
	}//end of function
	static boolean check(int row, int col, int N) {
		if(ccol[col]) {
			return false;
		}
		if(cdig[row+col]) {
			return false;
		}
		if(cdig2[row-col+N-1]) {
			return false;
		}
		return true;
	}
}
