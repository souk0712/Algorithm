import java.io.*;
import java.util.*;

class Solution {
    
    static int N, count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<ArrayList<Pos>> puzzles, emptyBlock;
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        puzzles = new ArrayList<>();
        emptyBlock = new ArrayList<>();
        
        boolean[][] visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j] && table[i][j] == 1){
                    find(table, puzzles, visit, 1, i, j);
                }
            } 
        }
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j] && game_board[i][j] == 0){
                    find(game_board, emptyBlock, visit, 0, i, j);
                }
            }
        }
        int answer = 0;
        for(ArrayList empty: emptyBlock){
            int[][] emptyTable = makeTable(empty);
            
            p:
            for(int j = puzzles.size() - 1; j >= 0; j--){
                int[][] puzzle = makeTable(puzzles.get(j));
                
                for(int k = 0; k < 4; k++){
                    puzzle = rotate(puzzle);
                    
                    if(isEqualPuzzle(puzzle, emptyTable)){
                        answer += count;
                        puzzles.remove(j);
                        break p;
                    }
                }
            }
        }
        
        return answer;
    }
    
    static boolean isEqualPuzzle(int[][] A, int[][] B){
        int Ah = A.length;
        int Bh = B.length;
        int Aw = A[0].length;
        int Bw = B[0].length;
        
        if(Ah != Bh || Aw != Bw)return false;
        
        for(int i = 0; i < Bh; i++){
            for(int j = 0; j < Bw; j++){
                if(A[i][j] != B[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static int[][] rotate(int[][] map){
        int h = map.length;
        int w = map[0].length;
        int[][] res = new int[w][h];
        count = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(map[i][j] == 1){
                    count++;
                }
                res[j][h - i - 1] = map[i][j];
            }
        }
       
        return res;
    }
    
    static int[][] makeTable(ArrayList<Pos> list){
        int minX = 2501;
        int minY = 2501;
        int maxX = 0;
        int maxY = 0;
        
        for(int i = 0; i < list.size(); i++){
            Pos p = list.get(i);
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }
        int[][] res = new int[maxX - minX + 1][maxY - minY + 1];
        for(int i = 0; i < list.size(); i++){
            Pos p = list.get(i);
            int mx = p.x - minX;
            int my = p.y - minY;
            res[mx][my] = 1;
        }
        return res;
    }
    
    static void find(int[][] map, ArrayList<ArrayList<Pos>> space, boolean[][] visit, int value, int x, int y){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));
        visit[x][y] = true;
        ArrayList<Pos> temp = new ArrayList<>();
        while(!q.isEmpty()){
            Pos cur = q.poll();
            temp.add(cur);
            
            for(int k = 0; k < dx.length; k++){
                int mx = cur.x + dx[k];
                int my = cur.y + dy[k];
                if(mx < 0 || my < 0 || mx >= N || my >= N) continue;
                if(visit[mx][my] || map[mx][my] != value) continue;
                q.offer(new Pos(mx, my));
                visit[mx][my] = true;
            }
        }
        space.add(temp);
    }
    
    static class Pos{
        int x, y;
        
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}