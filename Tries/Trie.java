package Tries;
class Node{
    Node[] chars;
    boolean flag;
    public Node(){
        chars = new Node[26];
        flag = false;
    }
    public boolean containsKey(char ch){
        return chars[ch-'a'] != null;
    }
    public Node nextNode(char ch){
        return chars[ch-'a'];
    }
    public Node createNode(char ch){
        Node newnode = new Node();
        chars[ch-'a'] = newnode;
        return newnode;
    }
}
public class Trie {
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        char ch;
        for(int i=0;i<word.length();i++){
            ch = word.charAt(i);
            if(curr.containsKey(ch)){
                curr = curr.nextNode(ch);
            }
            else{
                curr = curr.createNode(ch);
            }
        }
        curr.flag = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        char ch;
        for(int i=0;i<word.length();i++){
            ch = word.charAt(i);
            if(!curr.containsKey(ch)){
                return false;
            }
            curr = curr.nextNode(ch);
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        char ch;
        for(int i=0;i<prefix.length();i++){
            ch = prefix.charAt(i);
            if(!curr.containsKey(ch)){
                return false;
            }
            curr = curr.nextNode(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */