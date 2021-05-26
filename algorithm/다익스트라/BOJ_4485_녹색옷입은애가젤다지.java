import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
	static int[][] cost;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class POS implements Comparable<POS>{
		int x;
		int y;
		int sum;
		POS(int x, int y, int sum){
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
		@Override
		public int compareTo(POS o) {
			// TODO Auto-generated method stub
			return this.sum - o.sum;
			//내림차순
		}

	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int isInput = -1;
		int k = 1;
		while(isInput !=0) {
			//처음 입력한 값은 무조건 들어감
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					//input
					map[i][j] = Integer.parseInt(st.nextToken());
				}//end of first loop
			}//end of second loop
			cost = new int[n][n];

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cost[i][j] = Integer.MAX_VALUE;
					//최소금액을 찾고있으므로 맥스값을 셋팅한다.
				}//end of first loop
			}//end of second loop

			cost[0][0] = map[0][0];
			//시작위치 init

			PriorityQueue<POS> q = new PriorityQueue<>();
			//최소 min 이 맨위로 올라갈 것임
			q.add(new POS(0,0,0));
			//1. x좌표, 2. y좌표, 3. sum 값
			while(!q.isEmpty()) {
				POS tempD = q.poll();
				int x = tempD.x;
				int y = tempD.y;

				//fetch

				for(int i=0; i<4; i++) {
					int ddx = x + dx[i];
					int ddy = y + dy[i];
					//four directions

					if(ddx<0 || ddx>=n || ddy<0 || ddy>=n) continue;

					if(
							cost[ddx][ddy] > map[ddx][ddy] + cost[x][y]
					) {
						cost[ddx][ddy] = map[ddx][ddy] + cost[x][y];
						//방문하지 않았고
						//다음에 업데이트 할 값이 더 작고
						q.add(new POS(ddx,ddy,cost[ddx][ddy]));
					}
				}
			}
			System.out.println("Problem " +(k++)+": "+ cost[n-1][n-1]);


		}
	}

}