package backjun모음;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 
 * 
 * 
 */
/*
 * 동작원리
 * 입력받은 맵으로부터 1 이라고 써인 위치의 지점을 큐에 넣습니다.
 * 큐에서 꺼내어 4방향(좌, 우, 위, 아래) 로 탐색을 진행합니다.
 * 이때 주의해야할것은 1이 하나가 아니라 여러개가 있을 수 있기 때문에
 * 탐색의 횟수를 하나의 값으로 설정하는것이 아니라, 큐에 넣는 값으로 둬야 
 * 동시에 1인 위치에서 4방향 탐색을 진행하더라도 방문체크를 해주기 때문에 끝나는 순간에 정답을 도출할 수 있다고 생각했습니다.
 * 또 맵에서 -1인 지점은 갈수 없는 곳입니다. 따라서 이 부분도 역시 방문체크를 했습니다. (탐색에서는 진행될 수 없으므로)
 */
class VVV{
    int x;
    int y;
    int cnt;
    VVV(int x, int y, int cnt){
        this.x=x;
        this.y=y;
        this.cnt = cnt;
    }
}
public class backjun_7576_토마토 {
    static int[][] map;
    static int[][] visit;
    static int a;
    static int b;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static int ans =0;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.setIn(new FileInputStream("res/backjun_7576.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<VVV> q = new LinkedList<>();
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken()); 
        map = new int[b][a]; 
        visit = new int[b][a]; 
        for(int i=0; i<b; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<a; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1) {
                    visit[i][j] = 1;
                    q.add(new VVV(i,j,0));
                }
                else if(map[i][j] == -1)
                    visit[i][j] = 1;
            }
        }
        while(!q.isEmpty()) {
            VVV sxx = q.remove();
            int tempx = sxx.x;
            int tempy = sxx.y;
            int tempcnt = sxx.cnt;
            for(int as=0; as<4; as++) {
                int ddx = tempx + dx[as];
                int ddy = tempy + dy[as];
                if(0<=ddx && ddx<b && 0<=ddy && ddy<a && visit[ddx][ddy]==0 && map[ddx][ddy]!=-1) {
                    visit[ddx][ddy]=1;
                    ans = tempcnt+1;
                    q.add(new VVV(ddx,ddy,tempcnt+1));
                }
            }
        }
        for(int f=0; f<b; f++) {
            for(int c=0; c<a; c++) {
                if(visit[f][c] ==0)
                    ans = -1;
            }
        }
        System.out.println(ans);    
    }
}
