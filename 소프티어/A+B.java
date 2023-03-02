import java.util.*;
import java.io.*;


class A더하기B
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int t = 0;t<T;t++){
                char[] c = br.readLine().toCharArray();
                int answer = c[0] + c[2] - '0'*2;
                sb.append("Case #").append(t+1).append(": ").append(answer).append("\n");
        }
            System.out.println(sb.toString());
    }
}