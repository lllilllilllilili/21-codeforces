import java.util.*;
import java.io.*;
class Solution {
	public String[] solution(String[] record) {
		List<String> ansList = new ArrayList<>();
		Map<String, String> idmap = new HashMap<>();

		for(String str : record){
			StringTokenizer st = new StringTokenizer(str);
			String cmd = st.nextToken();
			if(cmd.equals("Enter") || cmd.equals("Change")){
				String id = st.nextToken();
				String name = st.nextToken();
				idmap.put(id, name);
			}
		}
		for(String str : record){
			StringTokenizer st = new StringTokenizer(str);
			String cmd = st.nextToken();
			if(cmd.equals("Enter")){
				String id = st.nextToken();
				ansList.add(idmap.get(id)+"님이 들어왔습니다.");
			}else if(cmd.equals("Leave")){
				String id = st.nextToken();
				ansList.add(idmap.get(id)+"님이 나갔습니다.");
			}
		}

		String[] answer = new String[ansList.size()];
		ansList.toArray(answer);
		return answer;
	}
}