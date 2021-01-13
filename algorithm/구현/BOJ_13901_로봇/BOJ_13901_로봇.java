package backjun;

import java.io.*;
import java.util.*;

public class BOJ_13901_로봇 {
	static int dx[] = { 0,-1,1,0,0 };
	static int dy[] = { 0,0,0,-1,1 };
	static int[] d = new int[4];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[R+1][C+1];
		
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				map[i][j] = true;
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		//허들 
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			int bx = Integer.parseInt(st.nextToken());
			int bc = Integer.parseInt(st.nextToken());
			map[++bx][++bc] = false;
		}
		//로봇
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		
		
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		sr++;
		sc++;
		
		boolean cont = true;
		while(cont) {
			int nnr, nnc;
			cont = false;

	        for (int i = 0; i < 4; i++) {
	            nnr = sr + dx[d[(cnt+i)%4]]; nnc = sc + dy[d[(cnt+ i)%4]];
	            if(nnr<1 || nnr>R || nnc<1 || nnc>C) continue;
	            if (map[nnr][nnc]) {
	                cnt = (cnt + i) % 4;
	                map[sr][sc] = false;
	                sr = nnr; sc = nnc;
	                cont = true;
	                break;
	            }
	        }
		}
		
		System.out.println(--sr+" "+--sc);
		}
	}

