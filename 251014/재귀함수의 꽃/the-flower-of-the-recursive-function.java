import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        loop(5);
    }

    static void loop(int num){
        if(num < 1) return;
        System.out.print(num + " ");
        loop(num - 1);
        System.out.print(num + " ");
    }
}