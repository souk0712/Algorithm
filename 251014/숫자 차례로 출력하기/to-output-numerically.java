import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(i).append(" ");
        }
        sb.append("\n");
        for(int i = N; i >= 1; i--){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}