package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_수영장 {

	static int total;
	static int[] cost;
	static int[] plan;
	static int ans = Integer.MAX_VALUE;

	static void go(int month, int sum) {
		if (month >= 12) { //주어진 달은 12월 달 까지임
			if (ans > sum)
				ans = sum; //갱신 
			return;
		} else {
			if (plan[month] == 0) { //달에 수영장에 갈 계획이 없다면
				go(month + 1, sum);
			}
			go(month + 1, sum + plan[month] * cost[0]); //1일 기준으로 갈때 발생하는 비용 
			go(month + 1, sum + cost[1]); //1달 기준으로 갈때 발생하는 비용
			go(month + 3, sum + cost[2]); //3달 기준으로 갈때 발생하는 비용
			go(month + 12, sum + cost[3]); //1년 기준으로 갈때 발생하는 비용=
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(br.readLine());
		for (int ufo = 0; ufo < total; ufo++) {
			cost = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			go(0, 0);
			System.out.println("#"+(ufo+1)+" "+ans);
			ans = Integer.MAX_VALUE;
		}
	}

}
