package backjun;

import java.util.*;
import java.io.*;
public class BOJ_1406_에디터 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		char[] cstr = str.toCharArray();
		for(int i=0; i<cstr.length; i++)
			left.push(cstr[i]);
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(m-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String fstr = st.nextToken();
			if(fstr.equals("L")) {
				if(!left.empty()) {
					right.push(left.peek());
					left.pop();
				}
			}else if(fstr.equals("D")) {
				if(!right.empty()) {
					left.push(right.peek());
					right.pop();
				}
			}else if(fstr.equals("B")) {
				if(!left.empty()) {
					left.pop();
				}
			}else if(fstr.equals("P")) {
				char[] sstr = st.nextToken().toCharArray();
				left.push(sstr[0]);
			}
		}
			while(!left.empty()) {
				right.push(left.peek());
				left.pop();
			}
			while(!right.empty()) {
				sb.append(right.peek());
				right.pop();
			}
			System.out.println(sb.toString());
			
		}
	
}
