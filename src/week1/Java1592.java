package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Java1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int l = Integer.parseInt(input[2]);
        int ball = 0;
        int count = 0;
        ArrayList<Integer> kids = new ArrayList();
        for (int i = 0; i < n; i++) {
            kids.add(0);
        }
        kids.set(0, 1);
        int next;
        while (true) {
            if (kids.get(ball) >= m)
                break;

            if (kids.get(ball) % 2 == 0) {       //짝수
                next = (ball - l + n) % n;
            } else {                      //홀수
                next = (ball + l) % n;
            }
            kids.set(next, kids.get(next) + 1);
            count++;
            ball = next;
        }
        System.out.println(count);
    }
}
/**
 * 짝수
 * next = (ball - l + n) % n;
 * 홀수
 * next = (ball + l) % n;
 */
