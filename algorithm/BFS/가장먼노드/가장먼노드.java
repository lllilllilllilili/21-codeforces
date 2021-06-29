import java.util.*;
class Solution {
    
    static boolean[][] map;
    static int cnt = 0;
    static int[] dist;
    static void BFS(int n, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=2; i<=n; i++){ 
                if(map[x][i] == true && dist[i] == 0 ){
                    dist[i] = dist[x] + 1;
                    q.add(i);
                    max = Math.max(dist[i], max);
                }
            }
        }
        for(int i : dist){
            if(i == max){
                cnt += 1;
            }
        }//end of for loop
        
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        map = new boolean[n+1][n+1];
        dist = new int[n+1];
       
        
        for(int i=0; i<edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            map[x][y] = map[y][x] = true;
        }
        //System.out.println(Arrays.deepToString(map));
        BFS(n,1);
        return cnt;
        //노드별 가장 짧은 거리를 저장한다. 
        
    }
}