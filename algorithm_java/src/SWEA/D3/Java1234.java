package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            int n = Integer.parseInt(st.nextToken());
            ArrayList<String> arrayList = new ArrayList<>();
            String str = st.nextToken();
            for (int i = 0; i < n; i++) {
                arrayList.add(str.split("")[i]);
            }
            loop:
            while (true) {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    if (arrayList.get(i).equals(arrayList.get(i + 1))) {
                        arrayList.remove(i + 1);
                        arrayList.remove(i);
                        break;
                    }
                    if (i == arrayList.size() - 2) break loop;
                }
            }
            System.out.print("#" + t +" ");
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i));
            }
            System.out.println();
        }
    }
}
