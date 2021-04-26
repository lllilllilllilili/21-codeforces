import java.util.*;
class Solution {

	public int[] solution(int[] prices) {
		int[] answer = {};

		Stack<Integer> st = new Stack<>();
		answer = new int[prices.length];
		for(int i=0; i<prices.length; i++){
			int cnt = 0;
			for(int j=i+1; j<prices.length; j++){
				if(prices[i]<=prices[j]) cnt+=1;
				else{
					cnt+=1;
					break;
				}
			}
			answer[i] = cnt;
		}
		return answer;
	}
}