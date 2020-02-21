package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.util.Pair;

public class boj_15686_치킨배달 {

	static int n, select;
	static int[][] map;
	static int[] ch;
	static int[] visit;
	static int ans = Integer.MAX_VALUE;
	static ArrayList<Pair> al = new ArrayList<>();
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static void go(int nn, int index) {
		if(nn==select) {
			int total = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 1) {
						int min = Integer.MAX_VALUE;
						for(int z =0; z<ch.length; z++) {
							int temp = Math.abs(i-al.get(ch[z]).x)+Math.abs(j-al.get(ch[z]).y);
							if(min>temp) min = temp;
						}
						total += min;
					}//first
				}//second
			}//third
			if(ans>total) ans = total; //집과 선택된 치킨집 간의 거리의 합을 최솟값으로 갱신
		}else {
			for(int i=index; i<al.size(); i++) {
					int temp = ch[nn];
					ch[nn] = i;
					go(nn+1, i+1);
			}//조합 
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		select = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					al.add(new Pair(i,j));
				}
			}
		}//end of for loop

		ch = new int[select];
		go(0,0);
		System.out.println(ans);
		
	}

}
