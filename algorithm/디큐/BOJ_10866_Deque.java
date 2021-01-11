import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Deque<Integer> test = new ArrayDeque<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// int countTokens = st.countTokens();
			// for(int j=1; j<=countTokens; j++) {
			String ss = st.nextToken();
			if (ss.equals("push_back")) {
				int t = Integer.parseInt(st.nextToken());
				test.addLast(t);
			} else if (ss.equals("push_front")) {
				int t = Integer.parseInt(st.nextToken());
				test.addFirst(t);
			} else if (ss.equals("front")) {
				if (test.isEmpty())
					System.out.println("-1");
				else
					System.out.println(test.peekFirst());
			} else if (ss.equals("back")) {
				if (test.isEmpty())
					System.out.println("-1");
				else
					System.out.println(test.peekLast());
			} else if (ss.equals("size")) {
				System.out.println(test.size());
			} else if (ss.equals("empty")) {
				if (test.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			} else if (ss.equals("pop_front")) {

				if (test.isEmpty())
					System.out.println("-1");
				else {
					int t = test.removeFirst();
					System.out.println(t);
				}
			} else if (ss.equals("pop_back")) {
				if (test.isEmpty())
					System.out.println("-1");
				else {
					int t = test.removeLast();
					System.out.println(t);
				}
			}
		}
		// }
	}

}
