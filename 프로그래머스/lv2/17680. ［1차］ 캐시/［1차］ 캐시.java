import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        if (cacheSize == 0) return cities.length * 5;

        int index = 0;
        for (int i = 0; i < cities.length; i++) {
            boolean check = false;
            for (int j = 0; j < cache.size(); j++) {
                if (cities[i].toUpperCase().equals(cache.get(j))) {
                    cache.remove(j);
                    cache.add(cities[i].toUpperCase());
                    check = true;
                    break;
                }
            }
            if (check) {
                answer++;
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(cities[i].toUpperCase());
            }
        }

        return answer;
    }
}