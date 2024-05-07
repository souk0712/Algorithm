import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(String msg) {
        ArrayList<Integer> answerList = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        int index = 1;
        for (char c = 'A'; c <= 'Z'; c++, index++) {
            dictionary.put(c + "", index);
        }

        int i = 0;
        while (i < msg.length()) {
            StringBuilder wc = new StringBuilder();
            for (int j = i; j < msg.length(); j++) {
                wc.append(msg.charAt(j));
                if (!dictionary.containsKey(wc.toString())) {
                    dictionary.put(wc.toString(), dictionary.size() + 1);
                    wc.deleteCharAt(wc.length() - 1);
                    i = j - 1;
                    break;
                }

                if(j == msg.length() - 1){
                    i = j;
                }
            }

            int resIndex = dictionary.get(wc.toString());
            answerList.add(resIndex);
            i++;
        }

        int[] answer = new int[answerList.size()];
        for (int a = 0; a < answerList.size(); a++) {
            answer[a] = answerList.get(a);
        }
        return answer;
    }
}