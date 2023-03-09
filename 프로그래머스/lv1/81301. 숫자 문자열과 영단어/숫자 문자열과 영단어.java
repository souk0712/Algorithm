class Solution {
     static String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
       int answer = 0;
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int index = 0;
        while (index < c.length) {
            for (int i = 0; i < number.length; i++) {
                if(index >= c.length) break;
                char[] cc = number[i].toCharArray();
                if (c[index] == cc[0]) {
                    if (index + 1 < c.length && c[index + 1] == cc[1]) {
                        index += cc.length;
                        sb.append(i);
                    }

                } else if (c[index] - '0' >= 0 && c[index] - '0' < 10) {
                    sb.append(c[index] - '0');
                    index++;
                }
            }
        }
        answer = Integer.parseInt(sb.toString());

        return answer;
    }
}