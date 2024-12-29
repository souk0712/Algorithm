import java.io.*;
import java.util.*;

class Solution {
    
    static int[][] answer;
    static ArrayList<Node> yOrder;
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        sortNodeForY(nodeinfo);
        Tree tree = createTree();
        
        answer[0] = tree.preOrder();
        answer[1] = tree.postOrder();
        
        return answer;
    }
    
    static Tree createTree(){
        Tree tree = new Tree(yOrder.get(0));
        
        for(int i = 1; i < yOrder.size(); i++){
            tree.addNode(yOrder.get(i));
        }
        return tree;
    }
    
    static void sortNodeForY(int[][] nodeinfo){
        yOrder = new ArrayList<>();
        
        for(int i = 0; i < nodeinfo.length; i++){
            int num = i + 1;
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            yOrder.add(new Node(num, x, y));
        }
        
        Collections.sort(yOrder);
    }
    
    static class Tree {
        Node root;
        int size;
        
        Tree(Node root){
            this.root = root;
            size = 1;
        }
        
        public void addNode(Node node){
            addNode(root, node);
            size++;
        }
        
        private void addNode(Node parent, Node child){
            if(parent.x > child.x){
                if(parent.left == null){
                    parent.left = child;
                }else if(child.y < parent.left.y){
                    addNode(parent.left, child);
                }else{
                    addNode(child, parent.left);
                    parent.left = child;
                }
            }else{
                if(parent.right == null){
                    parent.right = child;
                }else if(child.y < parent.right.y){
                    addNode(parent.right, child);
                }else{
                    addNode(child, parent.right);
                    parent.right = child;
                }
            }
        }
        
        public int[] preOrder(){
            Queue<Integer> q = new LinkedList<>();
            preOrder(root, q);
            
            int i = 0;
            int[] result = new int[size];
            while(!q.isEmpty()){
                result[i++] = q.poll();
            }
            return result;
        }
        
        private void preOrder(Node root, Queue<Integer> q){
            if(root == null) return;

            // 노드 방문
            q.offer(root.index);
            
            // 왼쪽
            preOrder(root.left, q);

            // 오른쪽
            preOrder(root.right, q);
        }
        
        public int[] postOrder(){
            Queue<Integer> q = new LinkedList<>();
            postOrder(root, q);
            
            int i = 0;
            int[] result = new int[size];
            while(!q.isEmpty()){
                result[i++] = q.poll();
            }
            return result;
        }
        
        private void postOrder(Node root, Queue<Integer> q){
            if(root == null) return;

            // 왼쪽
            postOrder(root.left, q);

            // 오른쪽
            postOrder(root.right, q);

            // 노드 방문
            q.offer(root.index);
        }
    }
    
    static class Node implements Comparable<Node> {
        int index, x, y;
        Node left, right;
        
        Node(int index, int x, int y){
            this.index = index;
            this.x = x;
            this.y = y;
            left = null;
            right = null;
        }
        
        @Override
        public int compareTo(Node o){
            int c = Integer.compare(o.y, y);
            if(c == 0){
                return Integer.compare(x, o.x);
            }else{
                return c;
            }
        }
    }
}