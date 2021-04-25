import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] max_sushi = new int[3001];
		int answer = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cnt=0;
		Queue<Integer> deque = new ArrayDeque<>();
		for(int i=0; i<k; i++) {
			deque.add(arr[i]);
			if(max_sushi[arr[i]]++==0) { //종류는 유지되어야 하지만 해당 초밥 번호가
				//몇번 나오는지 체크
				cnt+=1;
			}
			answer = Math.max(cnt, answer);
		}//초밥의 종류를 파악한다.

		for(int i=0; i<N-1; i++) {
			deque.poll();
			if((--max_sushi[arr[i]])==0) //초밥 개수가 유지되지 않으면 여기서 문제생
				cnt--;
			deque.add(arr[(i+k)%N]);
			if(max_sushi[arr[(i+k)%N]]++==0) {
				//종류는 유지되어야 하지만 해당 초밥 번호가
				//몇번 나오는지 체크
				cnt+=1;
			}
			if(max_sushi[c]==0) {
				answer = Math.max(answer, cnt+1);
			}else
				answer = Math.max(answer, cnt);
		}
		System.out.println(answer);

	}
}
