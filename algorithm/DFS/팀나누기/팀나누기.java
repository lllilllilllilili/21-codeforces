import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 팀나누기 {

	static int[] arr;
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> al2 = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;
	static void dfs(int nn) {
		if(nn==4) {
			if(al.size()==2 && al2.size()==2) {
				
				
				int team1 = 0;
				for(int i=0; i<al.size(); i++) {
					team1 += al.get(i);
				}
				int team2 = 0;
				for(int j=0; j<al2.size(); j++) {
					team2 += al2.get(j);
				}
				
				if(ans>Math.abs(team1-team2))
					ans = Math.abs(team1-team2);
			}
		}else {
			al.add(arr[nn]);
			dfs(nn+1);
			al.remove(al.size()-1);
			
			al2.add(arr[nn]);
			dfs(nn+1);
			al2.remove(al2.size()-1);
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[4];
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(ans);
	}

}
