package study_group;

import java.util.*;
import java.io.*;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> d = new ArrayDeque();
		
//		int[] arrA = {7,8,10};
//		int[] arrB = {10,7,8};
		
		int[] arrA = {4,3,2,1};
		int[] arrB = {5,4,1,2};
		for(int i=0; i<arrA.length; i++)
			d.add(arrA[i]);
		
		int first = arrA[0];
		
		for(int i=0; i<arrA.length; i++) {
			d.addFirst(d.peekLast());
			d.pollLast();
			Iterator<Integer> e = d.iterator();
			int idx = 0;
			boolean flag = false;
			while(e.hasNext()) {
				//System.out.print(e.next()+" ");
				if(e.next() != arrB[idx]) {
					flag = false;
					break;
				}else {
					flag = true;
					idx+=1;
				}
			}
			if(flag == true) {
				System.out.println("true");
				System.exit(0);
			}
			
		}
		
		System.out.println("false");
		
	}
}
