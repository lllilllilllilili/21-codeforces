package 제11회싸피컴패티션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 잃어버린괄호 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] astr = str.split("");
		ArrayList<String> a = new ArrayList<>();
		String number = "";
		for(int i=0; i<astr.length; i++) {
			if(astr[i].equals("-") || astr[i].equals("+")) {
				a.add(number);
				a.add(astr[i]);
				number="";
			}else {
				number+=astr[i];
			}
		}
		a.add(number);
		
		ArrayList<Integer> t = new ArrayList<>();
		int o =0;
		for(int i=0; i<a.size(); i++) {
			if(a.get(i).equals("-")) {
				t.add(o);
				o=0;
				continue;
			}else if(a.get(i).equals("+")) {
				continue;
			}
			o+=Integer.parseInt(a.get(i));
		}//end of for loop
		t.add(o);
		o=0;

		int total = 0;
		for(int i=1; i<t.size(); i++) {
			total += t.get(i);
		}
		System.out.println(t.get(0)-total);
	}

}
