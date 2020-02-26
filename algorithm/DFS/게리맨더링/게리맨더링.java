import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게리맨더링 {

	static int n;
	static int[] people;
	static int[][] map;
	static ArrayList<Integer> team1 = new ArrayList<>();
	static ArrayList<Integer> team2 = new ArrayList<>();
	static int[] team1_arr;
	static int[] team2_arr;
	
	
	static int ans =Integer.MAX_VALUE;
	static void T1DFS(int nn) {
		for(int i=1; i<=n; i++) {
			
			if(map[nn][i]==1 && team1_arr[i]==1) {
				team1_arr[i]=0;
				T1DFS(i);
			}
		}
	}
	static void T2DFS(int nn) {
		for(int i=1; i<=n; i++) {
			if(i==nn)continue;
			if(map[nn][i]==1 && team2_arr[i]==1) {
				team2_arr[i]=0;
				T2DFS(i);
			}
		}
	}
	static void DFS(int nn) {
		if(nn==n+1) {
			if(team1.size()==n || team2.size()==n) return ;
			
			team1_arr = new int[n+1];
			team1_arr[team1.get(0)] = 0; //처음 들어가는 노드는 0
			for(int i=1; i<team1.size(); i++) {
				team1_arr[team1.get(i)] = 1;	//나눈 팀 정보 배열에 저장 
			}
			
			
			boolean team1_flag = true;
			
			
			T1DFS(team1.get(0)); //연결되었는지 확인 
			
			for(int i=1; i<=n; i++)
				if(team1_arr[i]==1) //1이 있다면 연결된것이 아님 
					team1_flag = false;
			
			
			team2_arr = new int[n+1];
			team2_arr[team2.get(0)] = 0; 
			for(int i=1; i<team2.size(); i++)
				team2_arr[team2.get(i)] = 1;
			
			boolean team2_flag = true;
			
			T2DFS(team2.get(0));
			for(int i=1; i<=n; i++)
				if(team2_arr[i]==1)
					team2_flag = false;
			
			if(team1_flag == true && team2_flag ==true) {
				int sum1 = 0;
				for(int i=0; i<team1.size(); i++) {
					sum1+=people[team1.get(i)];
				}
				int sum2 = 0;
				for(int i=0; i<team2.size(); i++) {
					sum2+=people[team2.get(i)];
				}
				if(ans>Math.abs(sum1-sum2)) ans = Math.abs(sum1-sum2);
			}			
		}else {
			team1.add(nn);
			DFS(nn+1);
			team1.remove(team1.size()-1);
			team2.add(nn);
			DFS(nn+1);
			team2.remove(team2.size()-1);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		people = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=1; j<=cnt; j++) {
				int near = Integer.parseInt(st.nextToken());
				map[i][near] = 1;
				map[near][i] = 1;
			}
		}//end of for loop
		DFS(1);
		if(ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
