import java.util.*;

class Solution {
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    int[][] D ={{-1,0}, {1,0}, {0,-1}, {0,1}};
    //상, 하, 좌, 우
    int[][][] Drot = {{{1,1}, {1,-1}, {-1,-1}, {-1,1}},//시계
            {{1,-1}, {-1,-1}, {-1,1}, {1,1}}};//반시계
    int[][][] Dcor = {{{-1,1}, {1,1}, {1,-1}, {-1,-1}},
            {{-1,-1}, {-1,1}, {1,1}, {1,-1}}};
    class Point{
        int row, col, dir, time;
        Point(int row, int col, int dir, int time){
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.time = time;
        }
    }
    int[][] Board;
    int N;
    Queue<Point[]> Q = new LinkedList<>();
    boolean[][][] Visited = new boolean[100][100][4];
    int rotate(Point[] curr, int ccw, int idx){
        //idx = 회전축 값
        Point[] newPt = new Point[2];
        int a = idx;
        int b = (idx + 1)%2; //이동하는건 1만
        int dir = curr[a].dir;
        newPt[0] = new Point(curr[a].row, curr[a].col, (curr[a].dir+(ccw == 0 ? 1:3))%4, curr[a].time+1);
        //나머지연산, 시간은 1 증가
        newPt[1] = new Point(curr[b].row+Drot[ccw][dir][0], curr[b].col+Drot[ccw][dir][1],
                (curr[b].dir +(ccw == 0 ? 1:3)) %4,  curr[b].time+1);

        if(isValid(newPt) == false) return 0;
        //U,R,D,L 회전 시 확인해야할 구간이 있다.
        if(Board[curr[a].row + Dcor[ccw][dir][0]][curr[a].col+Dcor[ccw][dir][1]] == 1)
            return 0; //유효한 회전
        for(int i=0; i<2; i++){
            if(newPt[i].row == N-1 && newPt[i].col == N-1) return newPt[i].time;
            Visited[newPt[i].row][newPt[i].col][newPt[i].dir] = true;
        }
        Q.add(new Point[]{newPt[0], newPt[1]});
        return 0;

    }
    boolean isValid(Point[] pt){
        for(int i=0; i<2; i++){
            //범위를 벗어난 경우 false
            if(pt[i].row<0 || pt[i].row>N-1 || pt[i].col<0 || pt[i].col>N-1) return false;

            if(Board[pt[i].row][pt[i].col] == 1) return false; //이미 갔던적인 있는 칸
            if(Visited[pt[i].row][pt[i].col][pt[i].dir] == true) return false;
            //같은 방향으로 오게되면 더 이상 진행하면 안됨
            //다른 방향으로 왔을 때 진행할 수 있음
        }
        return true;
    }
    public int solution(int[][] board) {
        int answer = 0;

        Board = board;
        N = board.length;
        Q.add(new Point[]{new Point(0,0,RIGHT,0), new Point(0,1,LEFT,0)});
        Visited[0][0][RIGHT] = true;
        Visited[0][1][LEFT] = true;
        Point[] curr = new Point[2];  //탐색 진행하면서 사용할 curr 정의
        Point[] newPt = new Point[2]; //그다음에 방문할곳
        while((curr = Q.poll())!=null){
            //BFS탐색, 상, 하, 좌, 우 이동
            for(int j=0; j<4; j++){
                for(int i=0; i<2; i++){
                    newPt[i] = new Point(curr[i].row+D[j][0], curr[i].col+D[j][1],curr[i].dir, curr[i].time+1);

                }
                if(isValid(newPt) == false) continue; //유효하지 않은 이동

                //유효하다!
                for(int i=0; i<2; i++){
                    if(newPt[i].row == N-1 && newPt[i].col == N-1) return newPt[i].time;
                    //목적지 도착한 것
                    Visited[newPt[i].row][newPt[i].col][newPt[i].dir]=true; //마킹
                }
                Q.add(new Point[]{newPt[0], newPt[1]});
            }
            //상하좌우 끝

            //회전 : 시계, 반시계
            for(int ccw =0; ccw<2; ccw++){
                //0 : 시계, 1 : 반시계
                for(int i=0; i<2; i++){
                    //기준이 되는 친구 2개
                    int ret = rotate(curr, ccw, i); //i축으로 회전, curr 현재위치
                    if(ret != 0 )
                        return ret;
                }
            }
        }

        return 99999;
    }
}