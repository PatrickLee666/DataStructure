package struct.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 李俊锋
 * @date 2019/5/16 18:41
 * leetcode 211
 */
public class WordDictionary {

    private class Node{
        public boolean isWord;//是否为一个单词结尾
        public Map<Character,Node> map;

        public Node(){
            this(false);
        }

        public Node(boolean isWord){
            this.isWord = isWord;
            this.map = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if (cur.map.get(c) == null)
                cur.map.put(c,new Node());
            cur = cur.map.get(c);
        }

        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root,word,0);
    }

    private boolean search(Node root, String word, int index){

        if (index == word.length())
            return root.isWord;

        char c = word.charAt(index);
        if ('.' != c){//不是通配符
            if (root.map.get(c) == null)
                return false;
            return search(root.map.get(c),word,index+1);
        } else {//是.通配符
            for (Character character : root.map.keySet())
                if (search(root.map.get(character),word,index+1))
                    return true;
        }

        return false;
    }


}
