import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(L==0 && P==0 && V==0) break;
            sb.append("Case ").append(T).append(": ");
            int a = V / P;
            int m = Math.min(V % P, L);
            sb.append(a * L + m).append("\n");
            T++;
        }
        
        System.out.println(sb);
    }
}