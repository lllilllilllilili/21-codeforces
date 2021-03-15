import java.util.*;
public class pair로그래밍_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번 인풋
		//int[] ball = {1,2,3,4,5,6};
		//int[] order = {6,2,5,1,4,3};

		//2번 인풋

		int[] ball = {11, 2, 9, 13, 24};
		int[] order = {9, 2, 13, 24, 11};

		Deque<Integer> de = new ArrayDeque<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0; i<order.length; i++) {
			hm.put(order[i], i);
		}//eofl
		for(int i=0; i<ball.length; i++) {
			de.add(ball[i]);
		}//eofl

		ArrayList<Integer> al = new ArrayList<>();

		int cnt = 0;
		for(; ; ) {
			boolean find = true;

			if(hm.get(de.peekFirst())==cnt) {
				al.add(de.pollFirst());
				cnt = 0;프
				find = false;
			}
			if(de.isEmpty()) break;
			if(hm.get(de.peekLast())==cnt) {
				al.add(de.pollLast());
				cnt = 0;
				find = false;
			}
			if(de.isEmpty()) break;
			if(find == true) {
				cnt+=1;
			}
		}
		int[] answer = new int[al.size()];
		for(int i=0; i<al.size(); i++)
			answer[i] = al.get(i);
		System.out.println(Arrays.toString(answer));


	}
}
