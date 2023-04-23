class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;  // 반복되는 수
        for (int i = 1; i <= s.length() / 2; i++) { // 압축하는 단어 개수
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);    // 처음 단어
            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());   // s의 길이를 넘어 가지 않도록 함
                String target = s.substring(j, endIdx);     // 비교 대상
                if (base.equals(target)) {
                    count++;
                } else {
                    if (count >= 2) {   // base와 같지 않고, 이전에 중복 단어가 있을 때
                        sb.append(count);
                    }
                    sb.append(base);
                    base = target;      // 다음에 중복되는지 알아 볼 단어 설정
                    count = 1;  // 반복 수 초기화
                }
            }
            sb.append(base);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}