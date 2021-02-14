package programmers;

import java.util.*;
import java.io.*;
public class 프로그래머스_문자열압축 {

	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbaccc";
		char[] cstr = s.toCharArray();
		int slide = 0;
		HashMap<String, Integer> hm;
		ArrayList<String> al;
		while(true) {
			hm = new HashMap<>();
			al = new ArrayList<>();
			slide+=1;
			int temp = slide;
			String cuttingLetter = "";
			
			int cnt = 1;
			String answer = "";
			String before = "";
			cuttingLetter+=cstr[0];
			for(int i=1; i<cstr.length; i++) {
				if(--temp==0) {
					if(before.equals("")) ;
					else if(before.equals(cuttingLetter))cnt+=1;
					else {
						if(cnt>=2) {
							answer+=(cnt+before);
							cnt=1;
						}else {
							answer+=before;
							cnt=1;
						}
					}
					before = cuttingLetter;
					
					
					//al.add(cuttingLetter);
					cuttingLetter ="";
					temp = slide;
					i--; 
				}else{
					cuttingLetter+=cstr[i];
				}
			}//end of for loop
			if(cnt>=2)
				answer+=(cnt+before);
			else
				answer+=before;
			//al.add(cuttingLetter);
			System.out.println(answer);
			
//			int cnt = 1;
//			String answer = "";
//			
//			String before = al.get(0);
//			for(int i=1; i<al.size(); i++) {
//				if(before.equals(al.get(i))) {
//					cnt+=1;
//				}else {
//					if(cnt>=2) {
//						answer += (cnt+before);
//						//before을 al.get(i)라고 생각할 수 있지?
//						cnt = 1;
//					}else {
//						answer += before;
//						//얘도 before이네
//						cnt = 1;
//					}
//				}
//				before = al.get(i);
//			}
//			if(cnt>=2)
//				answer += (cnt+before);
//			else
//				answer += before;
			//cnt, before을 어떻게 생각해 ...
			if(ans>answer.length())
				ans = answer.length();
			if(slide==cstr.length/2) break;
		}
		System.out.println(ans);
		
	}

}
