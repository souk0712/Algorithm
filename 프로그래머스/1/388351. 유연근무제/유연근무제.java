import java.io.*;
import java.util.*;

class Solution {
    
    // 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현
    // schedules: 출근 희망 시각
    // timelogs: 출근한 시각
    // startday: 1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5는 금요일, 6은 토요일, 7은 일요일
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; i++){
            if(checkTardyForWeekdays(schedules[i], timelogs[i], startday - 1))
                answer += 1;
        }
        
        return answer;
    }
    
    public boolean checkTardyForWeekdays(int schedule, int[] timelog, int startday){
        int untilHour = schedule / 100;
        int untilMin = (schedule % 100) + 10;

        if(untilMin >= 60){
            untilHour += 1;
            untilMin -= 60;
        }
        int untilTime = untilHour * 100 + untilMin;
        
        for(int i = 0; i < timelog.length; i++){
            int dayOfWeek = (startday + i) % 7;
            if(dayOfWeek == 5 || dayOfWeek == 6) continue;
            if(timelog[i] > untilTime) return false;
        }
        return true;
    }
}