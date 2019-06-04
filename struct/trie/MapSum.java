package struct.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 李俊锋
 * @date 2019/5/16 19:09
 * leetcode 677
 */
public class MapSum {

    private class Node{
        public int value;//这个单词的权重
        public Map<Character,Node> map;

        public Node(){
            this(0);
        }

        public Node(int value){
            this.value = value;
            this.map = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;

        for (int i = 0; i < key.length(); i ++){
            char c = key.charAt(i);
            if (cur.map.get(c) == null)
                cur.map.put(c,new Node());
            cur = cur.map.get(c);
        }

        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;

        for (int i = 0; i < prefix.length(); i ++){
            char c = prefix.charAt(i);
            if (cur.map.get(c) == null)
                return 0;
            cur = cur.map.get(c);
        }

        return sum(cur);
    }

    private int sum(Node root){

        int sum = root.value;
        for (Character character : root.map.keySet()){
            sum += sum(root.map.get(character));
        }

        return sum;
    }

}
