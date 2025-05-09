import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] wheels;
    static Wheel[] infos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new int[4][8];
        infos = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = input.charAt(j) - '0';
            }
            infos[i] = new Wheel(2);
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[4];
            rotateWheel(index, dir, visit);
        }
        int answer = 0;
        int[] score = {1, 2, 4, 8};
        for (int i = 0; i < 4; i++) {
            answer += (wheels[i][infos[i].top] * score[i]);
        }
        System.out.println(answer);
    }

    private static void rotateWheel(int index, int dir, boolean[] visit) {
        if (visit[index]) return;
        visit[index] = true;
        Wheel info = infos[index];
        int leftIndex = index - 1;
        int rightIndex = index + 1;
        if (leftIndex >= 0) {
            int leftInfo = wheels[leftIndex][infos[leftIndex].right];
            if (wheels[index][info.left] != leftInfo) {
                rotateWheel(leftIndex, dir * -1, visit);
            }
        }
        if (rightIndex < 4) {
            int rightInfo = wheels[rightIndex][infos[rightIndex].left];
            if (wheels[index][info.right] != rightInfo) {
                rotateWheel(rightIndex, dir * -1, visit);
            }
        }
        if (dir == -1) {
            infos[index] = new Wheel((info.right + 1) % 8);
        } else {
            infos[index] = new Wheel((info.right + 7) % 8);
        }
    }

    static class Wheel {
        int left, right, top;

        Wheel(int right) {
            this.left = (right + 4) % 8;
            this.right = right;
            this.top = (right + 6) % 8;
        }
    }
}