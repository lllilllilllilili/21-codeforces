
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class  {

	static int n;
	static int[] arr;
	static int[] oce; 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		oce = new int[n];
		
		String[] temp = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		
		Stack<Integer> sta = new Stack<>();
		sta.push(0);
		
		for(int i=1; i<n; i++) {
			if(sta.isEmpty()) {
				sta.push(i);
			}
			while(!sta.isEmpty() && arr[sta.peek()]<arr[i]) {
				oce[sta.pop()] = arr[i];
			}
			sta.push(i);
		}
		
		while(!sta.isEmpty()) {
			oce[sta.pop()] = -1;
		}
		for(int i=0; i<oce.length; i++)
			System.out.print(oce[i]+" ");
		System.out.println();
	}

}
