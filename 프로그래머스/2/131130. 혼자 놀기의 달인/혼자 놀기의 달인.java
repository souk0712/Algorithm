import java.io.*;
import java.util.*;

class Solution {
    
    // 1 ~ 100 카드
    // 2 이상 100 이하의 자연수를 하나 정해 그 수보다 작거나 같은 숫자 카드 준비
    // -> 준비한 카드의 수만큼 작은 상자를 준비
    // 상자 나열 후, 순차적 증가 번호 붙임
    // 숫자 확인 -> 숫자에 해당하는 상자 오픈 -> ... (열어야하는 상자가 이미 열려있을 때까지 반복) -> 1번
    // 다시 시도 -> 2번
    // 1번 상자 수 * 2번 상자 수
    // cards: 상자 안에 들어있는 카드 번호가 순서대로 담긴 배열
    
    public int solution(int[] cards) {
        int answer = 0;
        for(int i = 0; i < cards.length; i++){
            int card = cards[i];
            boolean[] visit = new boolean[cards.length];
            int first = chooseBox(card, cards, visit, 0);
            boolean[] secondVisit = copy(visit);
            for(int j = 0; j < cards.length; j++){
                if(secondVisit[cards[j] - 1]) continue;
                int second = chooseBox(cards[j], cards, secondVisit, 0);
                answer = Math.max(first * second, answer);
            }
        }
        return answer;
    }
    
    static int chooseBox(int card, int[] cards, boolean[] visit, int sum){
        if(visit[card - 1]) return sum;
        visit[card - 1] = true;
        int next = cards[card - 1];
        return chooseBox(next, cards, visit, sum + 1);
    }
    
    static boolean[] copy(boolean[] arr){
        boolean[] res = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }
}