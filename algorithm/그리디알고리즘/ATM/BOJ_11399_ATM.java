package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2138 {
	static int n;
	static int[] a;
	static int[] b;
	
	static void change(int bulb) {
		for(int i=bulb-1; i<=bulb+1; i++) { //���ӵ� 3��Ʈ�� ���¸� ��� �մϴ�. ������(0<=i<n)
			if(0<=i && i<n) {
				a[i] = 1-a[i]; 
			}
		}
	}
	static int go() {

		int ans = Integer.MAX_VALUE;
		int t = 0;
		for(int i=0; i<n-1; i++) {
			if(a[i]!=b[i]) { //���� ���� ���°� �ٸ��� 
				change(i+1); //���� ���� ����ġ�� �����ϴ�. 
				t +=1; 
			}
		}//end of for loop
		
		boolean find = false;
		
		for(int i=0; i<n; i++) {
			if(a[i]!=b[i])
				find = true;
		}//�Ѵ� ������ ��ȸ
		
		if(find == false) {
			if(ans>t) ans = t; //���� 
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
			//�ڹٿ��� int �迭�� �ٷ� ���� ����� ��� ���� ���� ó�� 
			
			
			int p1 = go(); //0��° ����ġ�� ������ �ʰ� ��ȸ 
			
			for(int i=0; i<n; i++) 
				a[i] = Integer.parseInt(s1[i]);
			for(int j=0; j<n; j++) 
				b[j] = Integer.parseInt(s2[j]);
			//������ ���¸� ó������ ������ 
			
			change(0); //0��° ����ġ�� ������ 
			
			int p2 = go(); //0��° ����ġ�� ���� ���¿��� ��ȸ 
			if(p2!=Integer.MAX_VALUE) p2+=1; //a�� b�� ���ٴ°��� �ǹ��ϹǷ� ó�� 0��° ����ġ ���� ���� ���Խ��������
			int t = 0;
			if(p1!=Integer.MAX_VALUE && p2!=Integer.MAX_VALUE) { //0��° ����ġ�� �����Ͱ� ������ ���� �Ϳ� ���ؼ� ���� a=b �� ������ �� �ִٸ� ���߿��� �ּڰ�
				t = p1 > p2 ? p2 : p1;
			}else if(p1==Integer.MAX_VALUE && p2!=Integer.MAX_VALUE) { //0��° ����ġ�� ������ �����Ϳ� ���ؼ� a=b �� ��� 
				t = p2;
			}else if(p1!=Integer.MAX_VALUE && p2 == Integer.MAX_VALUE) { //0��° ����ġ�� �����Ϳ� ���ؼ� a=b �� ��� 
				t = p1;
			}else {
				t = -1;
			}
			System.out.println(t);		//���
	}
}
