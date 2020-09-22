package backjun;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;
public class backjun_줄세우기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> go[] = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			go[i] = new ArrayList<>();
		}
		int[] gote = new int[n+1];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			go[a].add(b);
			gote[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(gote[i]==0)
				q.add(i);
		}
		while(!q.isEmpty()) {
			int s = q.poll();
			System.out.print(s+" ");
			for(int i=0; i<go[s].size(); i++) {
				int next= go[s].get(i);
				gote[next]-=1;
				if(gote[next]==0)
					q.add(next);
			}
		}
	}

}
