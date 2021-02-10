import java.io.*;
import java.util.*;
class Solution {
	static ArrayList<String> al = new ArrayList<>();
	static void DFS(String[][] tickets, int nn, boolean[] visit, String next, String ans)     {
		if(nn == tickets.length){
			al.add(ans);
			return;
		}
		for(int i=0; i<tickets.length; i++){
			if(visit[i] == false && tickets[i][0].equals(next)){
				visit[i] = true;
				DFS(tickets, nn+1, visit, tickets[i][1], ans+tickets[i][1]);
				visit[i] = false;
			}
		}
	}

	public String[] solution(String[][] tickets) {
		String[] answer = {};
		boolean[] visit = new boolean[10000];
		DFS(tickets, 0, visit, "ICN", "ICN");
		Collections.sort(al);
		char[] cstr = al.get(0).toCharArray();
		answer = new String[cstr.length/3];
		int index = 0;
		int cnt = 0;
		String letter = "";
		System.out.println(cstr);
		for(int i=0; i<cstr.length; i++){
			letter += cstr[i];
			cnt+=1;
			if(cnt == 3){
				answer[index++] = letter;
				letter = "";
				cnt = 0;
			}
		}
		System.out.println(answer);
		return answer;
	}
}