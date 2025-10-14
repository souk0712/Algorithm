import java.io.*;
import java.util.*;

public class Main {

    private static final String STR = "HelloWorld";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(STR).append("\n");
        }
        System.out.println(sb);
    }
}