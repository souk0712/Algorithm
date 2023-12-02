import java.util.ArrayList;
import java.util.Comparator;

class Solution {

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> list = new ArrayList<>();
        // 코드 번호(code), 제조일(date), 최대 수량(maximum), 현재 수량(remain)
        for (int i = 0; i < data.length; i++) {
            int index = 0;
            switch (ext) {
                case "code":
                    break;
                case "date":
                    index = 1;
                    break;
                case "maximum":
                    index = 2;
                    break;
                case "remain":
                    index = 3;
                    break;
            }

            if (data[i][index] < val_ext) {
                list.add(data[i]);
            }
        }

        int index = 0;
        switch (sort_by) {
            case "code":
                break;
            case "date":
                index = 1;
                break;
            case "maximum":
                index = 2;
                break;
            case "remain":
                index = 3;
                break;
        }

        int finalIndex = index;
        list.sort(Comparator.comparingInt(o -> o[finalIndex]));

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}