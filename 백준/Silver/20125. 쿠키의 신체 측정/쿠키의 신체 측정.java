import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] heart = new int[2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int rightArm = 0;
        int leftArm = 0;
        int waist = 0;
        int rightLeg = 0;
        int leftLeg = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < N && j + 1 < N
                        && map[i - 1][j] == '*' && map[i][j - 1] == '*'
                        && map[i + 1][j] == '*' && map[i][j + 1] == '*') {
                    heart[0] = i;
                    heart[1] = j;
                }
            }
        }

        // 오른 팔
        for (int i = heart[1] + 1; i < N; i++) {
            if (map[heart[0]][i] == '*')
                rightArm++;
        }

        //왼 팔
        for (int i = heart[1] - 1; i >= 0; i--) {
            if (map[heart[0]][i] == '*')
                leftArm++;
        }

        int[] waistPos = new int[2];
        
        // 허리
        for (int i = heart[0] + 1; i < N; i++) {
            if (map[i][heart[1]] == '*') {
                waist++;
                waistPos[0] = i;
                waistPos[1] = heart[1];
            }
        }
        //오른 다리
        for (int i = waistPos[0] + 1; i < N; i++) {
            if (map[i][heart[1] + 1] == '*')
                rightLeg++;
        }
        //왼 다리
        for (int i = waistPos[0] + 1; i < N; i++) {
            if (map[i][heart[1] - 1] == '*')
                leftLeg++;
        }
        
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n")
                .append(leftArm).append(" ").append(rightArm).append(" ").append(waist).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
    }
}