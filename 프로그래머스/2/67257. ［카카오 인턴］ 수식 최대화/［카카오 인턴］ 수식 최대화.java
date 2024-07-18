import java.io.*;
import java.util.*;

class Solution {
    // 숫자들과 3가지의 연산문자(+, -, *)
    // + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의
    // 수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며, 연산자가 3개라면 3! = 6가지 조합
    //  계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출
    // 제출한 숫자가 가장 큰 참가자를 우승자로 선정 -> 제출한 숫자를 우승상금
    
    static ArrayList<String> operators, distinctOperator;
    static ArrayList<Integer> numbers;
    static long answer;
    
    public long solution(String expression) {
        answer = 0;
        operators = new ArrayList<>();
        numbers = new ArrayList<>();

        splitExpression(expression, "[^0-9]");
        splitExpression(expression, "[0-9]");

        Set<String> temp = new HashSet<>(operators);
        distinctOperator = new ArrayList<>(temp);

        boolean[] visit = new boolean[distinctOperator.size()];
        String[] pick = new String[distinctOperator.size()];
        priorityPerm(0, visit, pick);
        
        return answer;
    }

    static void splitExpression(String expression, String sperator) {
        expression = expression.replaceAll(sperator, " ");
        StringTokenizer st = new StringTokenizer(expression);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            switch (word) {
                case "-":
                case "+":
                case "*":
                    operators.add(word);
                    break;
                default:
                    numbers.add(Integer.parseInt(word));
                    break;
            }
        }
    }

    static void priorityPerm(int cnt, boolean[] visit, String[] pick) {
        if (cnt == visit.length) {
            answer = Math.max(calculateNumbers(pick), answer);
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            pick[cnt] = distinctOperator.get(i);
            priorityPerm(cnt + 1, visit, pick);
            visit[i] = false;
        }
    }

    static long calculateNumbers(String[] operator) {
        ArrayList<Long> numbersDupli = new ArrayList<>();
        ArrayList<String> operatorsDupli = new ArrayList<>(operators);
        for (long n : numbers) {
            numbersDupli.add(n);
        }

        for (String s : operator) {
            for (int i = 0; i < operatorsDupli.size(); i++) {
                String oper = operatorsDupli.get(i);
                if (oper.equals(s)) {
                    long front = numbersDupli.get(i);
                    long back = numbersDupli.get(i + 1);
                    switch (oper) {
                        case "-":
                            numbersDupli.set(i, front - back);
                            numbersDupli.remove(i + 1);
                            operatorsDupli.remove(i);
                            break;
                        case "+":
                            numbersDupli.set(i, front + back);
                            numbersDupli.remove(i + 1);
                            operatorsDupli.remove(i);
                            break;
                        case "*":
                            numbersDupli.set(i, front * back);
                            numbersDupli.remove(i + 1);
                            operatorsDupli.remove(i);
                            break;
                    }
                    i--;
                }
            }
        }
        return Math.abs(numbersDupli.get(0));
    }
}