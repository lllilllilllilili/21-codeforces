package backjun;
import java.util.*;
import java.io.*;
public class BOJ_9012_괄호 {

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            char[] go = br.readLine().toCharArray();

            int cnt = 0;
            boolean find = false;
            for(int j=0; j<go.length; j++) {

                if(go[j]=='(') {
                    cnt+=1;
                }else{
                    cnt-=1;
                }
                if(cnt<0)
                    find= true;
            }
            if(cnt==0 && find == false)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
