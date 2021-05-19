import java.util.*;
class Solution
{
	public int solution(String s)
	{
		int answer = -1;
		char[] chas = s.toCharArray();
		Stack<Character> st = new Stack<>();
		for(int i=0; i<chas.length; i++){
			if(!st.isEmpty() && st.peek()==chas[i]){
				st.pop();
			}else{
				st.push(chas[i]);
			}
		}

		if(st.size()!=0)
			return 0;
		else
			return 1;

	}
}
