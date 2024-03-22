import java.io.*;
import java.util.*;

class Solution {
    
    static int one, zero;
    
    public int[] solution(int[][] arr) {
        one = 0;
        zero = 0;
        int N = arr.length;

        dp(arr, 0, 0, N);

        return new int[]{zero, one};
    }

    static void dp(int[][] arr, int startX, int startY, int size) {
        if (isAllNumber(arr, startX, startY, size)) {
            if (arr[startX][startY] == 1) {
                one += 1;
            } else {
                zero += 1;
            }
            return;
        }
        // 상좌   0 ~ N/2, 0 ~ N/2
        dp(arr, startX, startY, size / 2);

        // 상우   0 ~ N/2, N/2 ~ N
        dp(arr, startX + size / 2, startY, size / 2);

        // 하좌   N/2 ~ N, 0 ~ N/2
        dp(arr, startX, startY + size / 2, size / 2);

        // 하우   N/2 ~ N, N/2 ~ N
        dp(arr, startX + size / 2, startY + size / 2, size / 2);
    }

    static boolean isAllNumber(int[][] arr, int x, int y, int size) {
        int a = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != a) {
                    return false;
                }
            }
        }
        return true;
    }
}