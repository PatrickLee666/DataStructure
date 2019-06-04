package struct.trie;

/**
 * @author lee
 * @date 2019/5/15 22:04
 */
public class Test {
    public static void main(String agrs[]){
        Trie trie = new Trie();
        trie.add("Trie");
        System.out.println(trie.contains("Trie"));
    }
}
