import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Character> st = new Stack<>();
    static int n;
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) {
            String tt = br.readLine();
            char[] s = tt.toCharArray();
            for(int j=0; j<s.length; j++) 	{


                if(!st.isEmpty() && s[j] == ' ') {
                    while(!st.isEmpty()) System.out.print(st.pop());
                    System.out.print(" ");
                    st.clear();
                }else
                    st.push(s[j]);
            }
            while(!st.isEmpty()) System.out.print(st.pop());
            System.out.print(" ");
            st.clear();
            System.out.println();
        }

    }

}