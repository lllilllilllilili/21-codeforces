package helloworld;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_모의SW역량테스트_요리사 {

	static int t, N;
	static ArrayList<Integer> team1 = new ArrayList<>();
	static ArrayList<Integer> team2 = new ArrayList<>();
	static int[][] glocery;
	static int ans = Integer.MAX_VALUE;
	static void go(int nn) {
		if(nn==N) {
			//N까지 간 후에, 각  ArrayList team1, team2 에  N/2 값이 들어가있는지 확인합니다.  
			if(team1.size()!=N/2) return;
			if(team2.size()!=N/2) return;
			int team1Sum = 0;
			for(int i=0; i<team1.size(); i++) {
				for(int j=0; j<team1.size(); j++) {
					team1Sum += glocery[team1.get(i)][team1.get(j)];
				}
			}
			int team2Sum = 0;
			for(int i=0; i<team2.size(); i++) {
				for(int j=0; j<team2.size(); j++) {
					team2Sum+=glocery[team2.get(i)][team2.get(j)];
				}
			}
			if( ans>Math.abs(team1Sum-team2Sum)) ans = Math.abs(team1Sum-team2Sum);
		}else {
			//team을 나누는 로직 
			team1.add(nn);
			go(nn+1);
			team1.remove(team1.size()-1);
			
			team2.add(nn);
			go(nn+1);
			team2.remove(team2.size()-1);
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			// testcase 동작횟수
			N = Integer.parseInt(br.readLine());
			glocery = new int[N][N];
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int z = 0; z < N; z++) {
					glocery[j][z] = Integer.parseInt(st.nextToken());
				}
			} // glocery 입력 받음
			go(0);
			System.out.println("#"+i+" "+ans);
			ans = Integer.MAX_VALUE;
		}//end of t 
	}

}
