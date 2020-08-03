
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution{
 
    static int min,max;
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i=1; i<=total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int temp = a+b;
            if(temp>n)
                min = temp-n;
            else
                min = 0;
            max = a>b ? b: a;
            System.out.println("#"+i+" "+max+" "+min);
        }
    }
 
}
 
