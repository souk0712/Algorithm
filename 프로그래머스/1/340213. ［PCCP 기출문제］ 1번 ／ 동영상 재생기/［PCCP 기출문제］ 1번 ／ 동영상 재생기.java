import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSec = getSecond(video_len);
        int posSec = getSecond(pos);
        int opStartSec = getSecond(op_start);
        int opEndSec = getSecond(op_end);
        
        if(isOpening(posSec, opStartSec, opEndSec)){
            posSec = opEndSec;
        }
        for(int i = 0; i < commands.length; i++){
            String command = commands[i];
            
            if("next".equals(command)){
                posSec += 10;
                if(posSec > videoSec){
                    posSec = videoSec;
                }
            }else if("prev".equals(command)){
                posSec -= 10;
                if(posSec < 0){
                    posSec = 0;
                }
            }
            if(isOpening(posSec, opStartSec, opEndSec)){
                posSec = opEndSec;
            }
        }
        
        return getResult(posSec);
    }
    
    static String getResult(int pos){
        int min = pos / 60;
        int sec = pos % 60;
        return String.format("%02d", min) + ":" + String.format("%02d", sec);
    }
    
    static int getSecond(String pos){
        String[] s = pos.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    static boolean isOpening(int pos, int opStart, int opEnd){
        return pos >= opStart && opEnd > pos;
    }
}