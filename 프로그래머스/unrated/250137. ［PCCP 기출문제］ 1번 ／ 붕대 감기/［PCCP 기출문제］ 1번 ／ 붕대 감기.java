import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = 1;
        int combo = 0;
        int maxHealth = health;
        int index = 0;
        while(true){
            if(index == attacks.length) break;
            int[] attack = attacks[index];
            if(attack[0] == time){
                health -= attack[1];
                combo = 0;
                index++;
            }else{
                health += bandage[1];
                combo++;
                if(bandage[0] == combo){
                    health += bandage[2];
                    combo = 0;
                }
            }
            
            if(health > maxHealth){
                health = maxHealth;
            }else if(health <= 0){
                health = -1;
                break;
            }
            
            time++;
        }
        return health;
    }
}