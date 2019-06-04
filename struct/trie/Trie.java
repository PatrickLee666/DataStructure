package struct.trie;

import java.util.TreeMap;

/**
 * @author 李俊锋
 * @date 2019/5/15 21:09
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(){
            this(false);
        }

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(String word){

        Node cur = root;

        for (int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord){//不是一个新单词
            cur.isWord = true;
            size ++;
        }
    }

    public boolean contains(String word){
        Node cur = root;

        for (int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix){
        Node cur = root;

        for (int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

}
