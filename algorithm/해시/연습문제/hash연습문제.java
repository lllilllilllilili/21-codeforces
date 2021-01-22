package study_group;

import java.util.*;
import java.io.*;
public class p3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] card = {1,3,2,5,3,1};
		int[] card = {1, 2, 3, 4, 4, 3, 2, 5};
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<card.length; i++) {
			if(hm.containsKey(card[i])) {
				hm.put(card[i], hm.get(card[i])+1);
			}else {
				hm.put(card[i], 1);
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		for(int key : hm.keySet()) {
			if(hm.get(key)!=2) {
				al.add(key);
			}
		}
		Collections.sort(al);
		int[] answer = new int[al.size()];
		for(int i=0; i<al.size(); i+=1)
			answer[i] = al.get(i);
		
		System.out.println(Arrays.toString(answer));
	}
}
