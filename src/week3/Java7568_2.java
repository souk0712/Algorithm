package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Java7568_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grade = new int[n];
        Human[] hm = new Human[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            hm[i] = new Human(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            grade[i] = 1;
        }
        Comparator<Human> comp = (o1, o2) -> {
            int res;
            if (o1.height < o2.height && o1.weight < o2.weight)
                res = 1;
            else {
                res = 0;
            }
            return res;
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int res = comp.compare(hm[i], hm[j]);
                if (res > 0) {
                    grade[i] += 1;
                }
            }
            System.out.print(grade[i] + " ");
        }
    }

    static class Human {
        int index;
        int weight;
        int height;

        Human(int index, int weight, int height) {
            this.index = index;
            this.weight = weight;
            this.height = height;
        }
    }
}
/**
 * https://st-lab.tistory.com/243
 * Comparable
 * 자기 자신과 파라미터로 들어오는 객체를 비교.
 * 기본적으로 적용되는 정렬 기준으로 정렬 수행.
 * 정렬할 객체에 Comparable interface를 implements 후, compareTo() 메서드를 오버라이드하여 구현한다.
 * <p>
 * Comparator
 * 자기 자신의 상태가 어떻던 상관없이 파라미터로 들어오는 두 객체를 비교
 * 기본 정렬 기준과 다르게 정렬 수행.
 * Comparator interface를 implements 후 compare() 메서드를 오버라이드한 myComparator class를 작성한다.
 */