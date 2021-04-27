import java.util.*;
import java.io.*;
class Solution {
	int N, MinCnt;
	int[] Weak;
	int[] Dist;
	static final int INF = 987654321;
	void solve(int cnt, int pos, int visited){
		if(cnt>Dist.length) //범위
			return ;
		if(cnt >= MinCnt) return ; //가지치기

		for(int i=0; i<Weak.length; i++){
			int nextPos = (pos + i)%Weak.length;
			//취약점 방문, %배열의 크기로 나눠주면 해당 인덱스를 돌려서 쓸 수 있다.
			int diff = Weak[nextPos] - Weak[pos];

			if(nextPos < pos)
				//0을 지나갔다는 말, 한바퀴 돌았음
				diff = N + Weak[nextPos] - Weak[pos];

			if(diff > Dist[Dist.length - cnt])
				break;

			visited |= 1<<nextPos; 1<<1 00 | 10 = 10


		}
		if(visited == (1<< Weak.length)-1){
			//1111, 1+2+4+8 15
			//10000, 16 15

			//모든 비트가 1로 켜짐
			//MinCnt = Math.min(MinCnt, cnt);
			MinCnt = cnt; //위에서 가지치기를 했기 때문에 더 작은것을 찾았음
			return ;
		}
		for(int i=0; i<Weak.length; i++){
			if((visited & (1<<i))!=0)//이미 방문한곳
				continue;
			//친구, 위치
			solve(cnt + 1, i, visited);
		}
	}

	public int solution(int n, int[] weak, int[] dist) {
		int answer = 0;
		Arrays.sort(dist);
		N = n;
		Weak = weak;
		Dist = dist;
		MinCnt = INF;

		for(int i=0; i<Weak.length; i++){
			solve(1, i, 0);
		}//1. DFS
		if(MinCnt == INF)
			return -1;
		return MinCnt;
	}
}