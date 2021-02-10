import java.util.*;
import java.io.*;
class Solution {
	static int max = Integer.MAX_VALUE;
	public long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> time = new PriorityQueue<>(Collections.reverseOrder());

		for(int w : works){
			time.offer(w);
		}
		for(int i = 0; i<n; i++){
			int max = (int)time.poll();
			if(max<=0) break;
			time.offer(max-1);
		}
		while(!time.isEmpty()){
			answer += Math.pow(time.poll(), 2);
		}
		//DFS(n, 0, 0, works);
		return answer;
	}
	static void DFS(int n, int value, int index, int[] works){
		if(value>n) return ;
		if(n-value==0 ){
			int sum = 0;
			System.out.println("1");
			for(int i=0; i<works.length; i++){
				System.out.print(works[i]+" ");
			}
			System.out.println();
			for(int i=0; i<works.length; i++){
				sum+=Math.pow(works[i],2);
			}
			if(max>sum)
				max = sum;
			return ;
		}
		for(int i=1; i<=n; i++){
			int temp = works[index];
			works[index]-=i;
			DFS(n, value+i, index+1, works);
			works[index] = temp;
		}
	}
}