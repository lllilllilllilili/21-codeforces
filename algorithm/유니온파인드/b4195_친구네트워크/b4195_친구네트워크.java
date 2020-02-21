import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int f;
	static int[] p, r, l;
	static int index = 1;
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();

	static int find(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = find(p[x]);
	}

	static void union(int f, int s) {
		int pf = find(f);
		int ps = find(s);

		if (pf == ps) {
			System.out.println(r[ps]);
			return;
		}

//		if(l[pf]>l[ps]) {
//			int temp = pf;
//			pf = ps;
//			ps = temp;
//		}

		p[pf] = ps;
		r[ps] += r[pf]; //ps가 부모이므로 자식을 더함
		System.out.println(r[ps]);
		// if(l[pf] == l[ps]) l[ps]+=1;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int w = 1; w <= n; w++) {
			f = Integer.parseInt(br.readLine());

			p = new int[f * 2 + 1];
			r = new int[f * 2 + 1];
			l = new int[f * 2 + 1];
			
			for (int i = 1; i <= f * 2; i++) {
				p[i] = i;
				r[i] = 1;
			}

			for (int i = 1; i <= f; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String first = st.nextToken();
				String second = st.nextToken();
				if (!hm.containsKey(first)) {
					hm.put(first, index++);
				}
				if (!hm.containsKey(second)) {
					hm.put(second, index++);
				}

				int tf = hm.get(first);
				int ts = hm.get(second);

				union(tf, ts);
			}
		}
	}

}
