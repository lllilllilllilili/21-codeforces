package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4013_특이한자석 {
	static int total, k;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		total = Integer.parseInt(br.readLine());
		
		//INPUT
		for (int u = 0; u < total; u++) {
			k = Integer.parseInt(br.readLine());
			int[][] cogwheel = new int[4][8];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					cogwheel[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of for loop

			
			for (int uu = 0; uu < k; uu++) {
				//자석의 번호
				//1은 시계방향
				//-1은 반시계 방향
				st = new StringTokenizer(br.readLine());
				int cogwheelNumber = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				
				int[] ddir = new int[4];
				ddir[cogwheelNumber] = dir;
				for(int l=cogwheelNumber+1; l<4; l++) {
					if(cogwheel[l-1][2]==cogwheel[l][6]) {
						ddir[l] = 0;
					}else {
						ddir[l] = ddir[l-1]*(-1);
					}
				}
				for(int l=cogwheelNumber-1; l>=0; l--) {
					if(cogwheel[l+1][6]==cogwheel[l][2]) {
						ddir[l]= 0;
					}else {
						ddir[l] = ddir[l+1]*(-1);
					}
				}
				for(int p=0; p<4; p++) {
					if(ddir[p] == 1) {
						int temp = cogwheel[p][7];
						for(int pp=6; pp>=0; pp--) {
							cogwheel[p][pp+1] = cogwheel[p][pp];
						}
						cogwheel[p][0] = temp;
					}else if(ddir[p] == -1) {
						int temp = cogwheel[p][0];
						for(int pp=1; pp<=7; pp++) {
							cogwheel[p][pp-1] = cogwheel[p][pp];
						}
						cogwheel[p][7] = temp;
					}else {
						//0인 경우, not working
					}
				}//end of rotation
			}
			int ans = 0;
			for(int z=0; z<4; z++) {
				if(cogwheel[z][0] == 1) {
					ans+=Math.pow(2, z);
				}
			}
			System.out.println("#"+u+" "+ans);
		}
	}

}
