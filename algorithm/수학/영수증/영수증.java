import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 영수증 {

	static int total = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(br.readLine());
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		System.out.println(total - sum);
		
	}

}
