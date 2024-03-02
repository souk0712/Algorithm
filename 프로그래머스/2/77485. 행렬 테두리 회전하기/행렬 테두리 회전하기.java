import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] map;
    static PriorityQueue<Integer> pq;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        pq = new PriorityQueue<>();
        initMap(map);
        
        for(int i = 0; i < queries.length; i++){
            pq = new PriorityQueue<>();
            int sx = queries[i][0] - 1;
            int sy = queries[i][1] - 1;
            int ex = queries[i][2] - 1;
            int ey = queries[i][3] - 1;
            int res = map[sx][sy];
            pq.offer(res);
            
            res = rotateArray(res, sx, sy, ex, ey, 1);
            res = rotateArray(res, sx, sy, ex, ey, 2);
            res = rotateArray(res, sx, sy, ex, ey, 3);
            res = rotateArray(res, sx, sy, ex, ey, 4);
            
            answer[i] = pq.poll();
        }

        return answer;
    }
    
    public static void initMap(int[][] map){
        int index = 1;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = index++;
            }
        }
    }
    
    public static int rotateArray(int res, int sx, int sy, int ex, int ey, int d){
        int temp = res;
        switch(d){
                // 오른쪽 가로
                case 1:
                
                    for(int j = sy + 1; j <= ey; j++){
                        int t = map[sx][j];
                        pq.offer(t);
                        map[sx][j] = temp;
                        temp = t;
                    }
                break;
                
                // 오른쪽 세로
                case 2:
                    for(int j = sx + 1; j <= ex; j++){   
                        int t = map[j][ey];
                        pq.offer(t);
                        map[j][ey] = temp;
                        temp = t;
                    }
                break;
                
                // 왼쪽 가로
                case 3:
                    for(int j = ey - 1; j >= sy; j--){
                        int t = map[ex][j];
                        pq.offer(t);
                        map[ex][j] = temp;
                        temp = t;
                    }
                break;
                
                // 왼쪽 세로
                default:
                    for(int j = ex - 1; j >= sx; j--){   
                        int t = map[j][sy];
                        pq.offer(t);
                        map[j][sy] = temp;
                        temp = t;
                    }
                break;
        }
        return temp;
    }
}