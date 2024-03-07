import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Deque<Integer>q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;
                case "front":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q.peekFirst()).append("\n");
                    }
                    break;
                case "pop":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q.poll()).append("\n");
                    }
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "back":
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}