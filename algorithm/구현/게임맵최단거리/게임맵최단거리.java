import java.util.*;

class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public int solution(int[][] maps) {
		int answer = -987654321;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0,1});
		int N = maps.length;
		int M = maps[0].length;
		boolean[][] visit = new boolean[N][M];
		visit[0][0] =true;
		while(!q.isEmpty()){
			int[] pos = q.poll();
			if(pos[0] == N-1 && pos[1] == M-1){
				answer = pos[2];
				break;
			}
			for(int i=0; i<4; i++){
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(maps[nx][ny]==0 || visit[nx][ny]) continue;
				visit[nx][ny] = true;

				q.add(new int[]{nx,ny,pos[2]+1});
			}
		}

		if(answer == -987654321)
			return -1;
		else
			return answer;
	}
}