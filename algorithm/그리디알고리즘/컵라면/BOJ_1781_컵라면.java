import java.util.*;
import java.io.*;
public class Main {
	static class pos{
		int x;
		int y;
		pos(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<pos> q = new PriorityQueue<>(1, new Comparator<pos>() {
			@Override
			public int compare(pos o1, pos o2) {
				// TODO Auto-generated method stub
				return o1.y-o2.y;
			}
		});
		//PriorityQueue<Integer> q = new PriorityQueue<>();

		ArrayList<int[]> al = new ArrayList<>();

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int noodle = Integer.parseInt(st.nextToken());
			al.add(new int[] {deadline, noodle});
			//q.add(new int[] {deadline, noodle});
		}

		Collections.sort(al, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==o2[0]) {
					return o2[1]-o1[1];
				}else
					return o1[0]-o2[0];
			}

		});



		int temp = al.get(0)[0];
		int ans = 0;

		for(int i=0; i<al.size(); i++) {
			//q.add(new pos(al.get(i)[0],al.get(i)[1]));
			int a =al.get(i)[0];
			int b =al.get(i)[1];
			q.add(new pos(al.get(i)[0], al.get(i)[1])) ;
			if(a<q.size()) {
				q.poll();
			}
		}
		while(!q.isEmpty()) {
			ans+=q.poll().y;
		}
		//System.out.println(ans);

//		int ans = 0;
//		for(int[] i : q) {
//		System.out.println(i[0]+" "+i[1]);
//	}

		System.out.println(ans);
	}
}
