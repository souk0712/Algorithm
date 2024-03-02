import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String> in = new LinkedList<>();
        Queue<String> out = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            String number = br.readLine();
            in.offer(number);
        }

        for (int i = 1; i <= N; i++) {
            String number = br.readLine();
            out.offer(number);
        }

        while (!in.isEmpty()) {
            String outCar = out.poll();
            if (!in.peek().equals(outCar)) {
                answer++;
                in.remove(outCar);
            } else {
                in.poll();
            }
        }

        System.out.println(answer);
    }
}