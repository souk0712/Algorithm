import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for(int i = 0; i <= n - 3; i++){
            for(int j = 0; j <= n - 3; j++){
                int sum = 0;
                for(int l = i; l < i + 3; l++){
                    for(int k = j; k < j + 3; k++){
                        sum += grid[l][k];
                    }
                }
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}