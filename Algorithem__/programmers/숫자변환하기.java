import java.util.HashSet;

public class 숫자변환하기 {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int n = 13;
        int res = solution(x, y, n);
        System.out.println(res);
    }

    public static int solution(int x, int y, int n) {
        int cnt = 0;
        HashSet<Integer> cur = new HashSet<>(), next = null;
        cur.add(x);
        while (!cur.isEmpty()) {
            if (cur.contains(y)) {
                return cnt;
            }
            next = new HashSet<>();
            for (int val : cur) {
                int pVal = val + n;
                int dVal = val * 2;
                int tVal = val * 3;
                if (pVal <= y) next.add(pVal);
                if (dVal <= y) next.add(dVal);
                if (tVal <= y) next.add(tVal);
            }
            cur = next;
            cnt++;
        }
        return -1;
    }
}
