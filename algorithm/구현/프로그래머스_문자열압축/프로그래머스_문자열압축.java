import java.util.*;
import java.io.*;
class Solution {
	static int ans = Integer.MAX_VALUE;
	public int solution(String s) {
		char[] cstr = s.toCharArray();
		int slide = 0;

		ArrayList<String> al;
		for(int k=0; k<=cstr.length/2; k++){
			al = new ArrayList<>();
			slide+=1;
			int temp = slide;
			String cuttingLetter = "";
			for(int i=0; i<cstr.length; i++) {
				if(temp--==0) {
					al.add(cuttingLetter);
					cuttingLetter ="";
					temp = slide;
					i--;
				}else {
					cuttingLetter+=cstr[i];
				}
			}//end of for loop
			al.add(cuttingLetter);


			int cnt = 1;
			String answer = "";

			String before = al.get(0);
			for(int i=1; i<al.size(); i++) {
				if(before.equals(al.get(i))) {
					cnt+=1;
				}else {
					if(cnt>=2) {
						answer += (cnt+before);
						//before을 al.get(i)라고 생각할 수 있지?
						cnt = 1;
					}else {
						answer += before;
						//얘도 before이네
						cnt = 1;
					}
				}
				before = al.get(i);
			}
			if(cnt>=2)
				answer += (cnt+before);
			else
				answer += before;
			//cnt, before을 어떻게 생각해 ...
			if(ans>answer.length())
				ans = answer.length();
			//if(slide==cstr.length/2) break;
		}
		return ans;
	}
}