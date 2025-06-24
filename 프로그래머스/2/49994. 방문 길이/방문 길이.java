import java.io.*;
import java.util.*;

class Solution {
    static Set<Line> set;
    static int[] dx = {-1, 1, 0, 0};    // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int x, y;
    
    public int solution(String dirs) {
        int answer = 0;
        set = new HashSet<>();
        x = 0;
        y = 0;
        for(int i = 0; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            int dir = -1;
            if(c == 'U'){
                dir = 0;
            }else if(c == 'D'){
                dir = 1;
            }else if(c == 'R'){
                dir = 3;
            }else if(c == 'L'){
                dir = 2;
            }
            
            if(move(dir)){
                answer++;
            }
        }
        return answer;
    }
    
    static boolean move(int dir){
        int mx = x + dx[dir];
        int my = y + dy[dir];
        if(mx < -5 || my < -5 || mx > 5 || my > 5) return false;
        Line l = new Line(new Point(x, y), new Point(mx, my));
        Line r = new Line(new Point(mx, my), new Point(x, y));
        x = mx;
        y = my;
        if(set.contains(l) || set.contains(r)) return false;
        set.add(l);
        
        return true;
    }
    
    static class Line {
        Point from, to;
        
        Line(Point from, Point to){
            this.from = from;
            this.to = to;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o instanceof Line){
                Line l = (Line) o;
                return (from.equals(l.from) && to.equals(l.to)) || 
                    (from.equals(l.to) && to.equals(l.from));
            }
            return false;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(from.toString() + to.toString());
        }
        
        @Override
        public String toString(){
            return "from: " + from + ", to: " + to;
        }
    }
    
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o instanceof Point){
                Point p = (Point) o;
                return x == p.x && y == p.y;
            }
            return false;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x + y + "");
        }
        
        @Override
        public String toString(){
            return "x: " + x + ", y: " + y;
        }
    }
}