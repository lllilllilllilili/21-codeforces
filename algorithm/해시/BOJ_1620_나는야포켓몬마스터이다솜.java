package backjun;

import java.util.*;
import java.io.*;
public class BOJ_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hm = new HashMap<>();
		//1. 입력 
		for(int i=0; i<first; i++) {
			String pocketmon = br.readLine();
			hm.put(pocketmon, Integer.toString(i+1));
			hm.put(Integer.toString(i+1), pocketmon);
		}
		for(int j=0; j<second; j++) {
			//2. findname을 입력받아서 각각 hm, hm2 에 넣어보고 null 여부에 따라 정답을 출력합니다. 
			String findname = br.readLine();
			System.out.println(hm.get(findname));
		}
	}
}
