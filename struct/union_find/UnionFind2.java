package struct.union_find;

/**
 * @author lee
 * @date 2019/5/21 15:29
 */
//quick union实现
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size){
        parent = new int[size];

        for (int i = 0; i < parent.length; i ++)
            parent[i] = i;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //得到所的节点的根节点
    private int find(int p){
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");
        while (parent[p] != p)
            p = parent[p];
        return p;
    }

    //判断两个节点是否属于一个集合 O(h) h为高度
    @Override
    public boolean isConnected(int p, int q) {

        return find(p) == find(q);
    }

    //合并两个节点
    @Override
    public void unionElements(int p, int q) {
        p = find(p);
        q = find(q);

        if (p == q)
            return ;

        parent[p] = q;
    }
}
