package backjun;

import java.util.*;
import java.io.*;
public class BOJ_1080_행렬 {

	static int row;
	static int column;
	static char[][] row_map;
	static char[][] aim_map;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		
		row_map = new char[row][column];
		for(int i=0; i<row; i++) {
			row_map[i] = br.readLine().toCharArray();
		}
		
		aim_map = new char[row][column];
		for(int i=0; i<row; i++) {
			aim_map[i] = br.readLine().toCharArray(); 
		}
		
		System.out.println(DFS(0, row_map, aim_map, 0));
		//System.out.println(n);
	}
	static int DFS(int r, char[][] row_map, char[][] aim_map, int count) {
		boolean find = false;
		if(r>row*column-1) return -1;
		int rrow = r/column;
		int ccolumn = r%column;
		for(int i=0; i<row_map.length; i++) {
			for(int j=0; j<row_map[i].length; j++) {
				if(row_map[i][j] != aim_map[i][j])
					find = true;
			}
		}//end of for loop
		if(!find) {
			return count;
		}
		
		if(row_map[rrow][ccolumn]!=aim_map[rrow][ccolumn]) {
			if(rrow+2>=row || ccolumn+2>=column) 
				 return -1;
			for(int i=rrow; i<=rrow+2; i++) {
				for(int j=ccolumn; j<=ccolumn+2; j++) {
					if(row_map[i][j] == '1')
						row_map[i][j] = '0';
					else
						row_map[i][j] = '1';
				}
			}//end of for loop
			return DFS(r+1, row_map, aim_map, count+1);
		}else
		return DFS(r+1, row_map, aim_map, count);
		
	}

}
