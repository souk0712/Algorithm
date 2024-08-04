import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    
    static int N;
    static PageInfo[] pageInfos;
    static ArrayList<Integer>[] list;
    
    public int solution(String word, String[] pages) {
        N = pages.length;
        pageInfos = new PageInfo[N];
        list = new ArrayList[N];
        Pattern pageUrlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"");
        Pattern outLinkPattern = Pattern.compile("<a href=\"(\\S*)\"");
        Pattern wordPattern = Pattern.compile("\\b(?i)(" + word + ")\\b");
        Matcher pageUrlMatcher, outLinkMatcher, wordMatcher;

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            String page = pages[i];
            pageUrlMatcher = pageUrlPattern.matcher(page);

            if (pageUrlMatcher.find()) {
                pageInfos[i] = new PageInfo(i, pageUrlMatcher.group(1));
            }
        }

        String body = "";
        for (int i = 0; i < N; i++) {
            String page = pages[i];
            // body
            body = page.split("<body>")[1];
            body = body.split("</body>")[0].replaceAll("[0-9]", " ");

            // 외부 링크
            outLinkMatcher = outLinkPattern.matcher(page);
            while (outLinkMatcher.find()) {
                String name = outLinkMatcher.group(1).trim();
                pageInfos[i].outLink += 1;
                for (int k = 0; k < N; k++) {
                    if (i == k) continue;
                    if (pageInfos[k].name.equals(name)) {
                        list[k].add(i);
                    }
                }
            }
            // 기본점수를 위한 word
            wordMatcher = wordPattern.matcher(body);
            int count = 0;
            while (wordMatcher.find()) {
                count++;
            }
            pageInfos[i].normalScore = count;
        }

        for (int i = 0; i < N; i++) {
            PageInfo pageInfo = pageInfos[i];
            // 링크 점수
            for (int j = 0; j < list[i].size(); j++) {
                int index = list[i].get(j);
                PageInfo p = pageInfos[index];
                pageInfo.linkScore += (double) p.normalScore / p.outLink;
            }
            // 매칭 점수
            pageInfo.matchingScore = pageInfo.normalScore + pageInfo.linkScore;
        }
        Arrays.sort(pageInfos);

        return pageInfos[0].index;
    }

    static class PageInfo implements Comparable<PageInfo> {
        int index, normalScore, outLink;
        double linkScore, matchingScore;
        String name;

        PageInfo(int index, String name) {
            this.index = index;
            this.name = name;
        }

        @Override
        public int compareTo(PageInfo o) {
            int c = Double.compare(o.matchingScore, matchingScore);
            if (c == 0) {
                return Integer.compare(index, o.index);
            } else {
                return c;
            }
        }
    }
}