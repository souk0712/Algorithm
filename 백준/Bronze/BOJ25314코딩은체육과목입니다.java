import java.util.*;
import java.io.*; 

public class Main { 

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); 

        int X = sc.nextInt();
        sb.append("long int");
        int sum = 4;
        while(sum != X){
             sum += 4;
             sb.insert(0, "long ");
         }
         System.out.println(sb);
    }
}
