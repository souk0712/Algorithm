class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i = 0 ; i < quiz.length; i++) {
            String[] input = quiz[i].split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[2]);
            int c = Integer.parseInt(input[4]);
            if(input[1].equals("-")) {
                answer[i] = a - b == c ? "O":"X";
            } else if(input[1].equals("+")){
                answer[i] = a + b == c ? "O":"X";
            }
        }
        
        return answer;
    }
}