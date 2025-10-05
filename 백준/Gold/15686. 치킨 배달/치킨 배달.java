import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m, p, h;
    static int[][] map, distance;
    static int[] pick;
    static int ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        pick = new int[m];
        ans = Integer.MAX_VALUE;

        Map<Integer, int[]> person = new HashMap<>();
        Map<Integer, int[]> hospital = new HashMap<>();
        p = 0;
        h = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    hospital.put(h++, new int[]{i, j});
                }else if(map[i][j] == 1){
                    person.put(p++, new int[]{i, j});
                }
            }
        }
        distance = new int[p][h];
        for(int i : person.keySet()){
            for(int j : hospital.keySet()){
                int[] pPoint = person.get(i);
                int[] hPoint = hospital.get(j);
                int d = getDistance(pPoint[0], pPoint[1], hPoint[0], hPoint[1]);
                distance[i][j] = d;
            }
        }
        comb(0, 0, new boolean[h]);
        System.out.println(ans);
    }

    static void comb(int start, int cnt, boolean[] visit){
        if(cnt == m){
            int sum = 0;
            for(int l = 0; l < p; l++){
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < pick.length; k++){
                    min = Math.min(distance[l][pick[k]], min);
                }
                sum += min;
            }
            ans = Math.min(sum, ans);
            return;
        }
        for(int i = start; i < h; i++){
            if(visit[i])continue;
            pick[cnt] = i;
            visit[i] = true;
            comb(i + 1, cnt + 1, visit);
            visit[i] = false;
        }
    }
    
    static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}