import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Number> min = new PriorityQueue<>((o1, o2)->{return Integer.compare(o1.num, o2.num);});
        PriorityQueue<Number> max = new PriorityQueue<>((o1, o2)->{return Integer.compare(o2.num, o1.num);});
        ArrayList<Boolean> index = new ArrayList<>();
        
        for(int i = 0, j = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String code = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            switch(code){
                case "I":
                    min.offer(new Number(j, n));
                    max.offer(new Number(j, n));
                    index.add(false);
                    j++;
                    break;
                    
                case "D":
                    if(n == -1) {
                        while(!min.isEmpty()){
                            Number p = min.poll();
                            if(!index.get(p.index)){
                                index.set(p.index, true);
                                break;
                            }
                        }
                    }else if(n == 1) {
                        while(!max.isEmpty()){
                            Number p = max.poll();
                            if(!index.get(p.index)){
                                index.set(p.index, true);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        
        while(!max.isEmpty()){
            Number p = max.poll();
            if(!index.get(p.index)){
                answer[0] = p.num;
                break;
            }
        }
        while(!min.isEmpty()){
            Number p = min.poll();
            if(!index.get(p.index)){
                answer[1] = p.num;
                break;
            }
        }
        return answer;
    }
    
    static class Number{
        int index, num;
        
        Number(int index, int num){
            this.index = index;
            this.num = num;
        }
    }
}