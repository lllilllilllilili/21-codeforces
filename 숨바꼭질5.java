package backjun;

import java.io.*;
import java.util.*;
public class BOJ_17071_숨바꼭질5 {

	static class store{
		int sujin_site;
		int brother_site;
		int time;
		store(int sujin_site, int brother_site, int time){
			this.sujin_site = sujin_site;
			this.brother_site = brother_site;
			this.time = time;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//수진이 위치, 동생 위치
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<store> q = new LinkedList<>();
		q.add(new store(N,K,0));
		boolean find = false;
		while(!q.isEmpty()) {
			store p = q.poll();
			if(p.sujin_site == p.brother_site) {
				System.out.println(p.time);
				find = true;
				break;
			}
			//수진 케이스
			if(p.sujin_site-1>=0 && p.brother_site+(p.time+1)<=500000) {
				q.add(new store(p.sujin_site-1, p.brother_site+(p.time+1), p.time+1));
			}
			if(p.sujin_site+1<=500000 && p.brother_site+(p.time+1)<=500000) {
				q.add(new store(p.sujin_site+1, p.brother_site+(p.time+1), p.time+1));
			}
			if(p.sujin_site*2<=500000 && p.brother_site+(p.time+1)<=500000) {
				q.add(new store(p.sujin_site*2, p.brother_site+(p.time+1), p.time+1));
			}
		}
		if(!find)
			System.out.println("-1");
	}
}
