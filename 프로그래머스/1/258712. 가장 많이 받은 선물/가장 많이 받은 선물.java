import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 1. A와 B가 선물을 주고받은 적이 있으면 이번 달 까지 더 많이 준 B가 A에게 다음 달에 선물을 하나 받음
        // 2. A와 B가 주고받은 기록이 하나도 없거나 주고 받은 수가 같으면, 선물 지수가 더 큰 B가 A에게 다음 달에 선물을 하나 받음
        // 2-1. 선물 지수 = 이번 달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
        // 2-2. 선물 지수가 같다면 다음 달에 선물을 주고받지 않음
        // => 선물을 가장 많이 받을 친구가 받을 선물의 수
        
        Map<String, Integer> friend = new HashMap<>();
        int[] point = new int[friends.length];
        int[] nextMonth = new int[friends.length];
        int[][] map = new int[friends.length][friends.length];
        // 이름별 index
        for(int i = 0; i < friends.length; i++){
            friend.put(friends[i], i);
        }
        // 준 횟수, 받은 횟수, 주고 받은 횟수
        for(int i = 0; i < gifts.length; i++){
            String[] str = gifts[i].split(" ");
            int A = friend.get(str[0]);
            int B = friend.get(str[1]);
            // 선물 지수
            point[A]++;
            point[B]--;
            // 주고 받은 관계
            map[A][B]++;
        }
        // 다음 달 선물 증정
        for(int i = 0; i < map.length; i++){
            for(int j = i + 1; j < map[0].length; j++){
                if(map[i][j] > map[j][i]){
                    nextMonth[i]++;
                }else if(map[i][j] < map[j][i]){
                    nextMonth[j]++;
                }else{
                    if(point[i] > point[j]){
                        nextMonth[i]++;
                    }else if(point[i] < point[j]){
                        nextMonth[j]++;
                    }
                }
            }
        }
        for(int i = 0; i < nextMonth.length; i++){
            answer = Math.max(nextMonth[i], answer);
        }
        return answer;
    }
}