import java.io.*;
import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int[] scores = {3, 2, 1, 0, 1, 2, 3};
        char[][] type = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        Map<Character, int[]> indexs = new HashMap<>();
        for(int i = 0; i < type.length; i++){
            indexs.put(type[i][0], new int[]{i, 0});
            indexs.put(type[i][1], new int[]{i, 1});
        }
        
        int[][] gets = new int[4][2];
        for(int i = 0; i < choices.length; i++){
            char front = survey[i].charAt(0);
            char back = survey[i].charAt(1);
            int[] frontIdx = indexs.get(front);
            int[] backIdx = indexs.get(back);
            int score = scores[choices[i] - 1];
            if(choices[i] < 4){
                gets[frontIdx[0]][frontIdx[1]] += score;
            }else if(choices[i] > 4){
                gets[backIdx[0]][backIdx[1]] += score;
            }
        }
        
        for(int i = 0; i < gets.length; i++){
            char c;
            if(gets[i][0] < gets[i][1]){
                c = type[i][1];
            }else if(gets[i][0] == gets[i][1]){
                if(type[i][0] < type[i][1]){
                    c = type[i][0];
                }else{
                    c = type[i][1];
                }
            }else{
                c = type[i][0];
            }
            answer.append(c);
        }
        return answer.toString();
    }
}