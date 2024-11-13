import java.io.*;
import java.util.*;

class Solution {
    
    static int n, x;
    static Map<Integer, Pos> spots;
    static Queue<Pos>[] robotPosByTime;
    
    public int solution(int[][] points, int[][] routes) {
        n = points.length;
        x = routes.length;
        spots = new HashMap<>();
        robotPosByTime = new Queue[x + 1];
        for(int i = 1; i <= x; i++){
            robotPosByTime[i] = new LinkedList<>();
        }
        for(int i = 1; i <= n; i++){
            spots.put(i, new Pos(points[i - 1][0], points[i - 1][1]));
        }
        for(int i = 1; i <= x; i++){
            Pos position = spots.get(routes[i - 1][0]);
            robotPosByTime[i].offer(position);
            for(int j = 1; j < routes[i - 1].length; j++){
                Pos next = spots.get(routes[i - 1][j]);
                moveRobot(i, position.x, position.y, next.x, next.y);
                position = next;
            }
        }
        int answer = 0;
        boolean[] finish = new boolean[x + 1];
        while(!isFinished(finish)){
            Map<Pos, List<Integer>> robotByPosition = new HashMap<>();
            for(int i = 1; i <= x; i++){
                Queue<Pos> q = robotPosByTime[i];
                if(!q.isEmpty()){
                    Pos cur = q.poll();
                    List<Integer> l;
                    if(robotByPosition.containsKey(cur)){
                        l = robotByPosition.get(cur);
                    }else{
                        l = new ArrayList<>();
                    }
                    l.add(i);
                    robotByPosition.put(cur, l);
                }else{
                    finish[i] = true;
                }
            }
            for(Pos p : robotByPosition.keySet()){
                if(robotByPosition.get(p).size() > 1){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    static boolean isFinished(boolean[] finish){
        for(int i = 1; i < finish.length; i++){
            if(!finish[i]){
                return false;
            }
        }
        return true;
    }
    
    static void moveRobot(int robotIndex, int curX, int curY, int nextX, int nextY){
        Pos current = new Pos(curX, curY);
        Pos arrive = new Pos(nextX, nextY);
        while(current.x != arrive.x || current.y != arrive.y){
            if(arrive.x < current.x){
                while(arrive.x < current.x){
                    current.x--;
                    robotPosByTime[robotIndex].offer(new Pos(current.x, current.y));
                }
            }else if(arrive.x > current.x){
                while(arrive.x > current.x){
                    current.x++;
                    robotPosByTime[robotIndex].offer(new Pos(current.x, current.y));
                }
            }
            if(arrive.y < current.y){
                while(arrive.y < current.y){
                    current.y--;
                    robotPosByTime[robotIndex].offer(new Pos(current.x, current.y));
                }
            }else if(arrive.y > current.y){
                while(arrive.y > current.y){
                    current.y++;
                    robotPosByTime[robotIndex].offer(new Pos(current.x, current.y));
                }
            }
        }
    }
    
    static class Pos {
        int x, y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true; 
            if(obj == null || this.getClass() != obj.getClass()) return false;
            Pos opponent = (Pos) obj;
            return (this.x == opponent.x && this.y == opponent.y);
        }
        
        @Override
        public String toString(){
            return "x: " + x + ", y: " + y;
        }
    }
}