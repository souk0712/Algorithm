import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : input) {
                arr.add(Integer.parseInt(s));
                set.add(Integer.parseInt(s));
            }

            if (set.size() == 1) {
                Iterator<Integer> iter = set.iterator();
                int a = iter.next();
                if (a == 0) {
                    return;
                }
            }

            arr.sort(Integer::compare);

            if (arr.get(0) + arr.get(1) <= arr.get(2)) {
                System.out.println("Invalid");
                continue;
            }

            int size = set.size();

            switch (size) {
                case 1:
                    System.out.println("Equilateral");
                    break;
                case 2:
                    System.out.println("Isosceles");
                    break;
                case 3:
                    System.out.println("Scalene");
                    break;
            }
        }
    }
}