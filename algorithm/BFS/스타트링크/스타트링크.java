import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class ppair{
    int x;
    int y;
    ppair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static Queue<ppair> q = new LinkedList<ppair>(); //q.add(new Pair(x, y)) 라고 쓰면 된다. 
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        String str = "use the stairs";
        //System.out.println("F :"+F+" S : "+S+" G : "+G+" U : "+U+" D: "+D);
        //F : 범위, S :시작위치, G : 끝위치, U : 올라가는지점, D : 내려가는지점
        int[] map = new int[F+1];
        int[] visit = new int[F+1];
         q.add(new ppair(S, 0));
         visit[S] = 1;
         while(!q.isEmpty()) {
             ppair front = q.remove();
            if(front.x == G) {
                str=String.valueOf(front.y);
                break;
            }
            int du = front.x + U;
            if(du>0 && du<=F && visit[du]!=1) {
                visit[du] = 1;
                q.add(new ppair(du, front.y+1));
            }

            int dp = front.x - D;
            if(dp >0 && dp<=F && visit[dp]!=1) {
                visit[dp] = 1;
                q.add(new ppair(dp, front.y+1));
            }
         }

         System.out.println(str);
    }

}