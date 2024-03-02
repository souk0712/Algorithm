import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int num;

            switch (input[0]) {
                case "add":
                    num = Integer.parseInt(input[1]);

                    arrayList.add(num);
                    break;

                case "remove":
                    num = Integer.parseInt(input[1]);

                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j) == num) {
                            arrayList.remove(j);
                            break;
                        }
                    }
                    break;

                case "check":
                    num = Integer.parseInt(input[1]);

                    if (arrayList.contains(num)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "toggle":
                    num = Integer.parseInt(input[1]);

                    if (arrayList.contains(num)) {
                        for (int j = 0; j < arrayList.size(); j++) {
                            if (arrayList.get(j) == num) {
                                arrayList.remove(j);
                                break;
                            }
                        }
                    } else {
                        arrayList.add(num);
                    }
                    break;

                case "all":
                    ArrayList<Integer> newList = new ArrayList<>();

                    for (int j = 1; j <= 20; j++) {
                        newList.add(j);
                    }

                    arrayList = newList;

                    break;

                case "empty":
                    arrayList = new ArrayList<>();
                    break;
            }
        }

        System.out.println(sb);
    }
}