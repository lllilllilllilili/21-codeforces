package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2138 {
	static int n;
	static int[] a;
	static int[] b;
	
	static void change(int bulb) {
		for(int i=bulb-1; i<=bulb+1; i++) { //연속된 3파트의 상태를 토글 합니다. 범위내(0<=i<n)
			if(0<=i && i<n) {
				a[i] = 1-a[i]; 
			}
		}
	}
	static int go() {

		int ans = Integer.MAX_VALUE;
		int t = 0;
		for(int i=0; i<n-1; i++) {
			if(a[i]!=b[i]) { //현재 전구 상태가 다르면 
				change(i+1); //다음 전구 스위치를 누릅니다. 
				t +=1; 
			}
		}//end of for loop
		
		boolean find = false;
		
		for(int i=0; i<n; i++) {
			if(a[i]!=b[i])
				find = true;
		}//둘다 같은지 조회
		
		if(find == false) {
			if(ans>t) ans = t; //갱신 
		}
		return ans;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			a = new int[n];
			b = new int[n];
			String[] s1 = br.readLine().split("");
			String[] s2 = br.readLine().split("");
			for(int i=0; i<n; i++) 
				a[i] = Integer.parseInt(s1[i]);
			for(int j=0; j<n; j++) 
				b[j] = Integer.parseInt(s2[j]);
			//자바에서 int 배열에 바로 넣을 방법이 없어서 위와 같이 처리 
			
			
			int p1 = go(); //0번째 스위치를 누르지 않고 조회 
			
			for(int i=0; i<n; i++) 
				a[i] = Integer.parseInt(s1[i]);
			for(int j=0; j<n; j++) 
				b[j] = Integer.parseInt(s2[j]);
			//전구의 상태를 처음으로 돌리고 
			
			change(0); //0번째 스위치를 누르고 
			
			int p2 = go(); //0번째 스위치를 누른 상태에서 조회 
			if(p2!=Integer.MAX_VALUE) p2+=1; //a와 b가 같다는것을 의미하므로 처음 0번째 스위치 누른 것을 포함시켜줘야함
			int t = 0;
			if(p1!=Integer.MAX_VALUE && p2!=Integer.MAX_VALUE) { //0번째 스위치를 누른것과 누르지 않은 것에 대해서 각각 a=b 를 성립할 수 있다면 그중에서 최솟값
				t = p1 > p2 ? p2 : p1;
			}else if(p1==Integer.MAX_VALUE && p2!=Integer.MAX_VALUE) { //0번째 스위치를 누르지 않은것에 대해서 a=b 인 경우 
				t = p2;
			}else if(p1!=Integer.MAX_VALUE && p2 == Integer.MAX_VALUE) { //0번째 스위치를 누른것에 대해서 a=b 인 경우 
				t = p1;
			}else {
				t = -1;
			}
			System.out.println(t);		//출력
	}
}
