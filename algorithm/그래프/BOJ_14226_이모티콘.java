import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	private static int time = Integer.MAX_VALUE;
	private static boolean[][] visit;
	private static int goal = 0;
	private static int BFS(int goal) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1,0,0}); //화면, 클립보드, 시간
		while(!q.isEmpty()) {
			int[] p = q.remove();

			if(goal == p[0]) {
				time = p[2];
				return time;
			}

			if(p[0]>1000 || p[1]>1000) continue;
			if(visit[p[0]][p[1]]==false && p[0]>=1) { //클립 보드 복사 어떻게?
				q.add(new int[] {p[0],p[0],p[2]+1});
				q.add(new int[] {p[0]-1,p[1],p[2]+1});
			}

			if(visit[p[0]][p[1]]==false && p[1]>=1) {
				q.add(new int[] {p[0]+p[1],p[1],p[2]+1});
			}
			visit[p[0]][p[1]] = true;
		}
		return time;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		goal = Integer.parseInt(br.readLine());
		visit = new boolean[1001][1001];

		System.out.println(BFS(goal));
	}

}
