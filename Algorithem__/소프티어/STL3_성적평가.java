import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[][] scores = new Person[4][N];
        int[][] rank = new int[4][N];

        for(int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int score = Integer.parseInt(st.nextToken());
                scores[i][j] = new Person(j, score);
            }
        }

        for(int j = 0; j < N; j++){
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += scores[i][j].score;
            }
            scores[3][j] = new Person(j, sum);
        }

        for(int i = 0; i < 4; i++){
            Arrays.sort(scores[i]);
        }

        for(int i = 0; i < 4; i++){
            int r = 1;
            int same = 0;
            Person com = scores[i][0];

            for(int j = 0; j < N; j++){
                Person p = scores[i][j];

                if(com.score == p.score){
                    rank[i][p.index] = r;
                    same++;

                }else{
                    r += same;
                    rank[i][p.index] = r;
                    same = 1;
                }

                com = p;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int[] r:rank){
            for(int rr: r){
                sb.append(rr).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static class Person implements Comparable<Person>{
        int index, score;

        public Person(int index, int score){
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Person o){
            return Integer.compare(o.score, score);
        }

        @Override
        public String toString() {
            return "index : " + this.index + ", score : " + this.score;
        }
    }
}