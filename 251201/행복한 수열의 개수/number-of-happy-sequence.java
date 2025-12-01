import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int ans = 0;
        for(int i = 0; i < n; i++){
            int before = grid[i][0];
            int cnt = 1;
            int max = 0;
            for(int j = 1; j < n; j++){
                if(before == grid[i][j]){
                    cnt++;
                }else{
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
                before = grid[i][j];
            }
            max = Math.max(max, cnt);
            if(max >= m){
                ans++;
            }
        }
        for(int i = 0; i < n; i++){
            int before = grid[0][i];
            int cnt = 1;
            int max = 0;
            for(int j = 1; j < n; j++){
                if(before == grid[j][i]){
                    cnt++;
                }else{
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
                before = grid[j][i];
            }
            max = Math.max(max, cnt);
            if(max >= m){
                ans++;
            }
        }
        System.out.println(ans);
    }
}