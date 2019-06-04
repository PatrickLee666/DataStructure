package struct.segmenttree;

import java.util.Arrays;

/**
 * @author lee
 * @date 2019/5/13 17:40
 */
//线段树
public class SegmentTree<E> {

    private E[] tree;//所有的节点
    private E[] data;//
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){

        this.merger = merger;

        data = (E[])new Object[arr.length];
        for (int i = 0;i < arr.length;i++){
            data[i] = arr[i];
        }

        tree = (E[])new Object[arr.length * 4];
        buildSegmentTree(0,0,data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            tree[treeIndex] = data[l];
            return ;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l ,mid);
        buildSegmentTree(rightTreeIndex, mid+ 1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }

    public E query(int left, int right){

        if (left < 0 || right > data.length)
            throw new IllegalArgumentException("OutOfIndexBound");

        return query(0, 0, data.length-1, left, right);

    }

    private E query(int treeIndex, int left, int right, int queryL, int queryR){
        if (left == queryL && right == queryR)
            return tree[treeIndex];

        int mid = left + (right - left) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        if (queryL >= mid + 1)//当搜索的范围在右节点的时候
            return query(rightChild,mid + 1, right, queryL, queryR);
        if (queryR <= mid)//当搜索的范围在左节点的时候
            return query(leftChild, left, mid,queryL,queryR);

        E leftResult = query(leftChild, left, mid, queryL, mid);
        E rightResult = query(rightChild, mid + 1, right, mid + 1,queryR);

        return merger.merge(leftResult,rightResult);

    }

    //线段树更新
    public void set(int index, E e){
        if (index < 0 || index > data.length - 1)
            throw new IllegalArgumentException("OutOfIndexBound");

        set(0,0,data.length-1,index,e);
    }

    private void set(int treeIndex, int left, int right, int index, E e){
        if (left == right) {
            tree[treeIndex] = e;
            return;
        }

        int mid = left + (right - left) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        if (index >= mid + 1)
            set(rightChild, mid + 1, right, index, e);
        if (index <= mid)
            set(leftChild, left, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftChild],tree[rightChild]);

    }

    //左孩子
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //右孩子
    private int rightChild(int index){
        return (index + 1) * 2;
    }

    @Override
    public String toString() {
        return "tree=" + Arrays.toString(tree);
    }
}
