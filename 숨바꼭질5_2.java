package backjun;

import java.util.*;
import java.io.*;
public class BOJ_17071_숨바꼭질5_2 {

	static class store{
		int pos;
		int time;
		store(int pos, int time){
			this.pos = pos;
			this.time = time;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] jusin_path = new int[2][500001];

		Arrays.fill(jusin_path[0], -1);
		Arrays.fill(jusin_path[1], -1);

		Queue<store> q = new LinkedList<>();
		q.add(new store(N,0));
		while(!q.isEmpty()) {
			store s = q.poll();
			if(s.pos<0 || s.pos>500000) continue;
			if(jusin_path[s.time%2][s.pos]!=-1) continue;
			jusin_path[s.time%2][s.pos] = s.time; //어느 위치에 몇초만에 갈 수 있는지가 핵심이다.
			q.add(new store(s.pos-1, s.time+1));
			q.add(new store(s.pos+1, s.time+1));
			q.add(new store(s.pos*2, s.time+1));
		}

		int bro_sum = 0;
		int sequence_variable = 0;
		int answer = -1;
		while(true) {
			int sequence = sequence_variable*(sequence_variable+1)/2;
			bro_sum = K + sequence;
			if(bro_sum>500000) break;
			if(jusin_path[sequence_variable%2][bro_sum]!=-1 && jusin_path[sequence_variable%2][bro_sum]<=sequence_variable) {
				answer = sequence_variable; //최초로 서로 만난 위치
				break;
			}
			sequence_variable+=1;
		}
		System.out.println(answer);
	}
}
