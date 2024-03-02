import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<Character>[] map;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static Set<Block> listSet;
    
   public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = m - 1; i >= 0; i--) {
            String str = board[i];
            for (int j = 0; j < n; j++) {
                map[j].add(str.charAt(j));
            }
        }

        while (true) {
            listSet = new HashSet<>();

            // 파괴할 블록 지정
            for (int j = 0; j < n - 1; j++) {
                for (int i = 0; i < map[j].size() - 1; i++) {
                    removeBlock(map[j].size(), n, map[j + 1].size(), i, j);
                }
            }

            if (listSet.isEmpty()) break;

            ArrayList<Block> list = new ArrayList<>(listSet);
            Collections.sort(list);

            // 파괴
            for (Block b : list) {
                map[b.y].remove(b.x);
                answer++;
            }
        }

        return answer;
    }

    public static void removeBlock(int m, int n, int r, int i, int j) {
        Set<Block> set = new HashSet<>();
        char block = map[j].get(i);
        set.add(new Block(i, j));

        for (int k = 0; k < dx.length; k++) {
            int mx = i + dx[k];
            int my = j + dy[k];

            if (checkRange(m, n, r, mx, my)) {
                char c = map[my].get(mx);
                if (c != ' ' && c == block) {
                    set.add(new Block(mx, my));
                }
            }
        }

        if (set.size() == 4) {
            listSet.addAll(set);
        }
    }

    public static boolean checkRange(int m, int n, int r, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n && x < r;
    }

    static class Block implements Comparable<Block> {
        int x, y;

        Block(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Block o) {
            if (o.y == this.y) {
                return Integer.compare(o.x, this.x);
            } else {
                return Integer.compare(o.y, this.y);
            }
        }

        @Override
        public boolean equals(Object b) {
            Block bb = (Block) b;
            return this.x == bb.x && this.y == bb.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}