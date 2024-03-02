package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java1260 {
    static LinkedList<Integer>[] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nodeNum = Integer.parseInt(input[0]);     //정점 개수
        int nodeLine = Integer.parseInt(input[1]);     //간선 개수
        int startNode = Integer.parseInt(input[2]);    //정점 번호


        nodeList = new LinkedList[nodeNum + 1];
        for (int i = 0; i <= nodeNum; i++) {
            nodeList[i] = new LinkedList<>();
        }

        for (int i = 0; i < nodeLine; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodeList[node1].add(node2);
            nodeList[node2].add(node1);

            Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
        }
        StringBuffer dfsResult = new StringBuffer();
        StringBuffer bfsResult = new StringBuffer();

        boolean[] dfsCheck = new boolean[nodeNum + 1];
        boolean[] bfsCheck = new boolean[nodeNum + 1];

        dfs(startNode, dfsCheck, dfsResult);
        bfs(startNode, bfsCheck, bfsResult);

        System.out.println(dfsResult);
        System.out.println(bfsResult);

    }

    private static void dfs(int node, boolean[] bfsCheck, StringBuffer bfsResult) {
        if (bfsCheck[node]) return;
        bfsCheck[node] = true;
        bfsResult.append(node + " ");
        for (int nextNode : nodeList[node]) {
            dfs(nextNode, bfsCheck, bfsResult);
        }
    }

    private static void bfs(int node, boolean[] dfsCheck, StringBuffer dfsResult) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);

        while(!que.isEmpty()){
            node = que.poll();

            if(dfsCheck[node]) continue;

            dfsCheck[node] = true;
            dfsResult.append(node + " ");
            for (int nextNode : nodeList[node]) {
                que.add(nextNode);
            }
        }

    }
}
