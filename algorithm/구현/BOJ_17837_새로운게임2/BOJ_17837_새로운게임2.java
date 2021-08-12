package backjun;

import java.util.*;
import java.io.*;

public class BOJ_17837_새로운게임2 {

    static int N, K;
    static int[][] map;
    static Info[] chess;
    static ArrayList<Integer>[][] al;

    static class Info {
        int x;
        int y;
        int dir;

        Info(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }

    // 오른쪽, 왼쪽, 위, 아래
    static int[] dx = { 0, 0, 0, -1, 1 };
    static int[] dy = { 0, 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        al = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                al[i][j] = new ArrayList<>();
            }
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                al[i][j] = new ArrayList<>();
            }
        } // end of for loop

        chess = new Info[K + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            chess[i] = new Info(x, y, dir);
            al[x][y].add(i);
        }

        int cnt = 1;
        int answer = 0;
        k: while (true) {

            for (int i = 1; i <= K; i++) {

                int x = chess[i].x;
                int y = chess[i].y;
                int dir = chess[i].dir;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 1 || nx >= N + 1 || ny < 1 || ny >= N + 1) {
                    // 범위를 넘어선 경우
                    move_f(i, x, y, nx, ny, dir, 2);
                } else {
                    // 범위를 넘어서지 않은 경우
                    move_f(i, x, y, nx, ny, dir, map[nx][ny]);
                }

                if (al[chess[i].x][chess[i].y].size() >= 4) {
                    answer = cnt;
                    break k;
                }
            } // end of for loop

            if (cnt++ > 1000) {
                answer = -1;
                break k;
            }
        } //
        System.out.println(answer);
    }

    /*
     * 
     * 4 4 0 0 2 0 0 0 1 0 0 0 1 2 0 2 0 0 2 1 1 3 2 3 2 2 1 4 1 2 디버깅해서 예제대로 잘 나오는지
     * 특히,
     */
    static void move_f(int chessIdx, int x, int y, int nx, int ny, int dir, int block) {
        int size = al[x][y].size();
        if (block == 0) {
            // 흰색

            int moveOnIdx = 0;
            // 현재 체스가 몇번째 인덱스 인지 확인
            for (int i = 0; i < size; i++) {
                if (al[x][y].get(i) == chessIdx) {
                    moveOnIdx = i;
                    break;
                }
            }

            for (int i = moveOnIdx; i < size; i++) {
                al[nx][ny].add(al[x][y].get(i));
                chess[al[x][y].get(i)].x = nx;
                chess[al[x][y].get(i)].y = ny;
            }

            for (int i = moveOnIdx; i < size; i++) {
                al[x][y].remove(al[x][y].size() - 1);
            }
        } else if (block == 1) {
            // 빨간색

            int moveOnIdx = 0;
            // 현재 체스가 몇번째 인덱스 인지 확인
            for (int i = 0; i < size; i++) {
                if (al[x][y].get(i) == chessIdx) {
                    moveOnIdx = i;
                    break;
                }
            }

            for (int i = size - 1; i >= moveOnIdx; i--) {
                al[nx][ny].add(al[x][y].get(i));
                chess[al[x][y].get(i)].x = nx;
                chess[al[x][y].get(i)].y = ny;

            }

            for (int i = size - 1; i >= moveOnIdx; i--) {
                al[x][y].remove(al[x][y].size() - 1);
            }

        } else if (block == 2) {
            // 파란색
            int reverse_d = reverseDir(dir);
            chess[chessIdx].dir = reverse_d;
            int rnx = x + dx[reverse_d];
            int rny = y + dy[reverse_d];
            if ((rnx >= 1 && rnx < N + 1 && rny >= 1 && rny < N + 1) && (map[rnx][rny] != 2)) {
                move_f(chessIdx, x, y, rnx, rny, reverse_d, map[rnx][rny]);
            }
        }
    }

    static int reverseDir(int dir) {
        if (dir == 1)
            return 2;
        if (dir == 2)
            return 1;
        if (dir == 3)
            return 4;

        return 3;

    }

}
