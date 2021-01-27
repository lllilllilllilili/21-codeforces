package backjun;

import java.util.*;
import java.io.*;
public class BOJ_2346_풍선터뜨리기_2 {

	static class store{
		int idx; 
		int value;
		store(int idx, int value){
			this.idx = idx;
			this.value = value;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<store> de = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			de.add(new store(i+1, Integer.parseInt(st.nextToken())));
		}//end of for loop
		
		while(!de.isEmpty()) {
			System.out.print(de.getFirst().idx+" ");
			int a = de.getFirst().value;
			de.pollFirst();
			if(de.isEmpty()) break;
			if(a<0) {
				for(int i=0; i<Math.abs(a); i++) {
					de.addFirst(de.getLast());
					de.pollLast();
				}
			}else {
				for(int i=0; i<a-1; i++) {
					de.addLast(de.getFirst());
					de.pollFirst();
				}
			}
		}
	}
}
