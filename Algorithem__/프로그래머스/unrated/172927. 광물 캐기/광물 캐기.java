import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] score = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        List<Minerals> list = new ArrayList<>();
        int totalPicks = 0;
        
        for (int num : picks) {
            totalPicks += num;
        }
        
        for (int i = 0; i < minerals.length; i += 5) {
            int diaSum = 0;
            int iroSum = 0;
            int stoSum = 0;
            if (totalPicks == 0) break;

            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;
                if (minerals[j].equals("diamond")) {
                    diaSum += score[0][0];
                    iroSum += score[1][0];
                    stoSum += score[2][0];
                } else if (minerals[j].equals("iron")) {
                    diaSum += score[0][1];
                    iroSum += score[1][1];
                    stoSum += score[2][1];
                } else {
                    diaSum += score[0][2];
                    iroSum += score[1][2];
                    stoSum += score[2][2];
                }
            }
            list.add(new Minerals(diaSum, iroSum, stoSum));
            totalPicks--;
        }
        list.sort((o1, o2) -> o2.stone - o1.stone);

        for (Minerals mineral : list) {

            int dia = mineral.dia;
            int iro = mineral.iron;
            int sto = mineral.stone;

            if (picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if (picks[1] > 0) {
                answer += iro;
                picks[1]--;
                continue;
            }
            if (picks[2] > 0) {
                answer += sto;
                picks[2]--;
                continue;
            }
        }

        return answer;
    }
    
    static class Minerals {
        private int dia;
        private int iron;
        private int stone;

        public Minerals(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
}