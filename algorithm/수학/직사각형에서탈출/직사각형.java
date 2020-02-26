package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형 {

	static int nx, ny ;
	static int gx, gy ;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nx = Integer.parseInt(st.nextToken());
		ny = Integer.parseInt(st.nextToken());
		gx = Integer.parseInt(st.nextToken());
		gy = Integer.parseInt(st.nextToken());
		
		int ans = Integer.MAX_VALUE;
		
		//가로
		for(int i=0; i<gy; i++) {
			if(ans>Math.abs(ny-i)+nx) ans = Math.abs(ny-i)+nx;
			
		}
		
		
		//아래 가로 
		for(int i=0; i<gy; i++) {
			if(ans>Math.abs(ny-i)+Math.abs(gx-nx)) ans = Math.abs(ny-i)+Math.abs(gx-nx);
			
		}
		
		//세로
		for(int i=0; i<gx; i++) {
			if(ans>Math.abs(i-nx)+ny) ans = Math.abs(i-nx)+ny;
		}
		
		
		//오른 세로
		for(int i=0; i<gx; i++) {
			if(ans>Math.abs(i-nx)+Math.abs(gy-ny)) ans = Math.abs(i-nx)+Math.abs(gy-ny);
		}
		System.out.println(ans);
	}

}
