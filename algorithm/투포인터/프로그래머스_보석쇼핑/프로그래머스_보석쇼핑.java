package programmers;

import java.util.*;
public class 프로그래머스_보석쇼핑 {

	static HashMap<String, Integer> hm = new HashMap<>();
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		for(int i=0; i<gems.length; i++)
			hs.add(gems[i]);
		int[] answer = new int[2];
		int min =0, start = 0, end =0;

		for(String ele : gems) {
			if(hm.containsKey(ele))
				hm.replace(ele, hm.get(ele)+1);
			else
				hm.put(ele, 1);

			if(hm.size() == hs.size())
				break;
			end++;
		}
		min = end - start;
		while(end<gems.length) {
			String jewName = gems[start];
			hm.replace(jewName, hm.get(jewName)-1);
			start++;

			if(hm.get(jewName)==0) {
				end++;
				for(int j=end; j<gems.length; j++) {
					hm.replace(gems[j], hm.get(gems[j])+1);
					if(jewName == gems[j])
						break;
					end++;
				}
			}//end of if

			if(min>end-start) {
				answer[0] = start+1;
				answer[1] = end+1;
				min = end - start;
			}
			System.out.println();
		}//end of while


		System.out.println(Arrays.toString(answer));
	}
}