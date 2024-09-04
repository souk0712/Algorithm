import java.io.*;
import java.util.*;

class Solution {
    
    static int[] redStart, blueStart;
    static int N, M, answer;
    static boolean[][][] visit;
    static boolean isRedFinish, isBlueFinish;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maze) {
        answer = Integer.MAX_VALUE;
        N = maze.length;
        M = maze[0].length;
        visit = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 1) {
                    redStart = new int[]{i, j};
                } else if (maze[i][j] == 2) {
                    blueStart = new int[]{i, j};
                }
            }
        }

        visit[0][redStart[0]][redStart[1]] = true;
        visit[1][blueStart[0]][blueStart[1]] = true;
        dfs(maze, redStart[0], redStart[1], blueStart[0], blueStart[1], 0);

        return answer==Integer.MAX_VALUE?0:answer;
    }

    static void dfs(int[][] maze, int rx, int ry, int bx, int by, int cnt) {
        if (maze[rx][ry] == 3 && maze[bx][by] == 4) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (maze[rx][ry] == 3) {
            isRedFinish = true;
        }
        if (maze[bx][by] == 4) {
            isBlueFinish = true;
        }

        for (int k = 0; k < dx.length; k++) {
            for (int l = 0; l < dx.length; l++) {
                int nrx = rx + dx[k];
                int nry = ry + dy[k];
                int nbx = bx + dx[l];
                int nby = by + dy[l];

                // 자신의 도착 칸에 위치한 수레는 움직이지 않습니다. 계속 해당 칸에 고정해 놓아야 합니다.
                if (isRedFinish) {
                    nrx = rx;
                    nry = ry;
                }
                if (isBlueFinish) {
                    nbx = bx;
                    nby = by;
                }

                // 수레는 벽이나 격자 판 밖으로 움직일 수 없습니다.
                if (checkRangeOut(nrx, nry) || checkRangeOut(nbx, nby) || maze[nrx][nry] == 5 || maze[nbx][nby] == 5)
                    continue;
                // 수레는 자신이 방문했던 칸으로 움직일 수 없습니다.
                if (!isRedFinish && visit[0][nrx][nry] || !isBlueFinish && visit[1][nbx][nby]) continue;
                // 동시에 두 수레를 같은 칸으로 움직일 수 없습니다.
                if (nrx == nbx && nry == nby) continue;
                // 수레끼리 자리를 바꾸며 움직일 수 없습니다.
                if (rx == nbx && ry == nby && bx == nrx && by == nry) continue;
                
                visit[0][nrx][nry] = true;
                visit[1][nbx][nby] = true;

                dfs(maze, nrx, nry, nbx, nby, cnt + 1);

                visit[0][nrx][nry] = false;
                visit[1][nbx][nby] = false;
                isRedFinish = false;
                isBlueFinish = false;
            }
        }
    }

    static boolean checkRangeOut(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }
}