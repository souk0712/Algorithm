import java.io.*;
import java.util.*;

class Solution {
    
    public boolean solution(String[] phone_book) {
        Trie trie = new Trie();
        
        Arrays.sort(phone_book, Collections.reverseOrder());
        
        for(int i = 0; i < phone_book.length; i++){
            if(trie.isFrontOfWord(phone_book[i])){
                return false;
            }else{
                trie.insert(phone_book[i]);
            }
        }
        
        return true;
    }
    
    static class Node{
        Map<Character, Node> childNode = new HashMap<>();
        boolean isEndOfWord;
    }
    
    static class Trie{
        Node rootNode = new Node();
        
        void insert(String str){
            Node node = this.rootNode;
            
            for(int i = 0;i<str.length();i++){
                node = node.childNode.computeIfAbsent(str.charAt(i), key -> new Node());
            }
            
            node.isEndOfWord = true;
        }
        
        boolean isFrontOfWord(String str){
            Node node = this.rootNode;
            
            for(int i = 0; i < str.length(); i++){
                node = node.childNode.getOrDefault(str.charAt(i), null);
                if(node == null){
                    return false;
                }
            }
            
            return true;
        }
    }
    
}