package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Java2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);
        int max = 0;
        for (int j = 0; j < n - 1; j++) {
            if (max < x[j] * (n - j))
                max = x[j] * (n - j);
        }

        if (max < x[n - 1])
            max = x[n - 1];

        System.out.println(max);
    }
}
/**
 * 배열의 오름차순 정렬
 * int, String과 같은 기본 타입 배열
 * Arrays.sort(배열);

 * 배열의 내림차순 정렬
 * Integer
 * Arrays.sort(배열, Collections.reverseOrder()

 * 배열 일부분만 정렬
 * Arrays.sort(배열, from, to)    // from ~ (to-1) 요소만 정렬.

 * int : primitive 자료형, 산술 연산이 가능하다. null 로 초기화 불가.
 * Integer : Wrapper 클래스(객체), Unboxing 하지 않으면 산술 연산이 불가능하지만, null 값 처리가능

 * Boxing : Primitive->Wrapper
 * Unboxing : Wrapper->Primitive
 ->  // to int i from Integer ii
 int i = ii.intValue();
 // to Integer ii from int i
 Integer ii = new Integer( i );

 * Integer.valueOf(String) : Integer 클래스를 리턴하기 때문에 산술 연산을 할 수 없다.
 * Integer.parseInt(String) : int 형을 리턴하기 때문에 산술 연산을 할 수 있다.
 */