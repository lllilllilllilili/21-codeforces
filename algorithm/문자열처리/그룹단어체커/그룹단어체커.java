
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 그룹단어체커 {
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String test = br.readLine();
			char[] s = test.toCharArray();
			HashMap<Character,Integer> hm = new HashMap<>();
				boolean find = false;
				int tempj = 0;
				hm.put(s[tempj], hm.getOrDefault(s[tempj], 0)+1);
				while(tempj+1<s.length) {
					if(s[tempj]==s[tempj+1]) {
						tempj = tempj+1;
					}
					else {
						if(hm.getOrDefault(s[tempj+1], 0)!=0) {
							find =true;
							break;
							//값이 있을때 
						}
						else {
							hm.put(s[tempj+1], hm.getOrDefault(s[tempj+1], 0)+1);
							tempj = tempj+1;
						}
					}
				}//end of while loop
				if(find == false) {
					ans +=1;
				}
				//hm.put(s[j], hm.getOrDefault(s[j], 0)+1);
			
		}
		System.out.println(ans);
	}

}
