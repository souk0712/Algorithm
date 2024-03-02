import java.util.*;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 3, 3};

        int[] res = solution(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solution(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int temp = 10;
        for (int i = 0; i < arr.length; i++) {
            if (temp != arr[i]) {
                res.add(arr[i]);
            }
            temp = arr[i];
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}