package backjun_re;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class �̺б׷��� {

	private static int n, vertex, line;
	private static int[] a;
	private static ArrayList<Integer>[] a2;

	private static void DFS(int vertex, int c) {
		a[vertex] = c;
		for (int i = 0; i < a2[vertex].size(); i++) {
			int next = a2[vertex].get(i);
			if (a[next]==0)
				DFS(next, 3 - c);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int z = 1; z <= n; z++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			line = Integer.parseInt(st.nextToken());
			a = new int[vertex + 1];
			a2 = (ArrayList<Integer>[]) new ArrayList[vertex + 1];
		
			for (int i = 1; i <= vertex; i++) {
				a2[i] = new ArrayList<Integer>();
			}
			for (int i = 1; i <= line; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				a2[from].add(to);
				//map[from][to] = 1;
			}
			for (int i = 1; i <= vertex; i++) {
				if (a[i] == 0) {
					DFS(i, 1);
				}
			}
			
			boolean ok = false;
			for (int i = 1; i <= vertex; i++) {
				for (int s = 0; s <a2[i].size(); s++) {
					int next = a2[i].get(s);
					if (a[i] == a[next]) {
						ok = true;
						break;
					}
				}
			}
			if (ok == true)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

}
