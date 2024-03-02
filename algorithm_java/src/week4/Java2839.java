package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int five = n / 5;
        int three = n % 5 / 3;
        int sum = five + three;
        if (n % 5 == 0) {
            System.out.println(sum);
        } else {
            if (n % 5 % 3 != 0) {
                int a = 0;
                sum = count(n, five, three, a);
            }
            System.out.println(sum);
        }
    }

    private static int count(int n, int five, int three, int a) {
        int sum;
        a++;
        if (five != 0) {
            five--;
            if ((n % 5 + 5 * a) % 3 == 0) {
                three = (n % 5 + 5*a) / 3;

                sum = five + three;
            } else {
                sum = count(n, five, three, a);
            }
        } else {
            sum = -1;
        }
        return sum;
    }
}