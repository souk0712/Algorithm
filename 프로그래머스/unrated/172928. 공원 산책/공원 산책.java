import java.io.*;
import java.util.*;

class Solution {

    static int H, W;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        H = park.length;
        W = park[0].length();
        int startX = 0;
        int startY = 0;
        
        for(int i = 0; i < H; i++){
            String str = park[i];
            for(int j = 0; j < W; j++){
                if('S'== str.charAt(j)){
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        
        StringTokenizer st;
        for(int i = 0;i < routes.length; i++){
            st = new StringTokenizer(routes[i]);
            String dir = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            int x = startX, y = startY;
            boolean check = true;
            switch(dir){
                case "N":
                    for(int j = 1; j <= cnt; j++){
                        x = startX - j;
                        y = startY;
                    
                        if(!checkRange(park, x, y)){
                            check = false;
                            break;
                        }
                    }
                    
                    if(check){
                        startX = x;
                        startY = y;
                    }
                    
                    break;
                case "S":
                    for(int j = 1; j <= cnt; j++){
                        x = startX + j;
                        y = startY;
                    
                        if(!checkRange(park, x, y)){
                            check = false;
                            break;
                        }
                    }
                    
                    if(check){
                        startX = x;
                        startY = y;
                    }
                    
                    break;
                    
                case "W":
                    for(int j = 1; j <= cnt; j++){
                        x = startX;
                        y = startY - j;
                    
                        if(!checkRange(park, x, y)){
                            check = false;
                            break;
                        }
                    }
                    
                    if(check){
                        startX = x;
                        startY = y;
                    }
                    
                    break;
                    
                 case "E":
                    for(int j = 1; j <= cnt; j++){
                        x = startX;
                        y = startY + j;
                    
                        if(!checkRange(park, x, y)){
                            check = false;
                            break;
                        }
                    }
                    
                    if(check){
                        startX = x;
                        startY = y;
                    }
                    
                    break;
            }
        }
        
        int[] answer = new int[]{startX, startY};
        return answer;
    }
    
    static boolean checkRange(String[] park, int x, int y){
        return x >= 0 && y >=0 && x < H && y < W && park[x].charAt(y) != 'X';
    }
}