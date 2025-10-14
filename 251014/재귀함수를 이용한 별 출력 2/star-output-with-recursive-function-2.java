import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStars(n);
    }

    static void printStars(int n){
        if(n < 1) return;
        for(int i = 0; i < n; i++){
            System.out.print("*" + " ");
        }
        System.out.println();
        printStars(n - 1);
        for(int i = n; i > 0; i--){
            System.out.print("*" + " ");
        }
        System.out.println();
    }
}