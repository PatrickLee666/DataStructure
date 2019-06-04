package struct.union_find;

/**
 * @author 李俊锋
 * @date 2019/5/21 20:30
 */
//size优化
public class UnionFind3 implements UF {
    private int[] parent;
    private int[] sz;//sz[i]表示以i为根的集合元素的个数


    public UnionFind3(int size){
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < parent.length; i ++) {
            parent[i] = i;
            sz[i] = 1;
        }
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

    /**
     * 根据两个元素所在树的元素个数b不同判断合并方向
     * 将元素个数少的集合合并到元素个数多的集合上
     */
    @Override
    public void unionElements(int p, int q) {
        p = find(p);
        q = find(q);

        if (p == q)
            return ;

        if (sz[p] < sz[q]) {
            parent[p] = q;
            sz[q] += sz[p];
        } else {
            parent[q] = p;
            sz[p] += sz[q];
        }
    }

}
