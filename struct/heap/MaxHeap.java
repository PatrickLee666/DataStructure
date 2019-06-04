package struct.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李俊锋
 * @date 2019/5/11 17:34
 */
//从0开始
public class MaxHeap<E extends Comparable<E>> {
    private List<E> list;

    public MaxHeap(){
        list = new ArrayList<>();
    }

    public MaxHeap(int capacity){
        list = new ArrayList<>(capacity);
    }

    //返回元素个数
    public int size(){
        return list.size();
    }

    //返回是否为空
    public boolean isEmpty(){
        return list.isEmpty();
    }

    //得到某个索引的父亲节点
    private int parent(int index){
        if (index <= 0)
            throw new IllegalArgumentException(index + " 索引错误");
        return (index+1)/2-1;
    }

    //得到左孩子
    private int leftChild(int index){
        if (index < 0)
            throw new IllegalArgumentException(index + " 索引错误");
        return index * 2 + 1;
    }

    //得到右孩子
    private int rightChild(int index){
        if (index < 0)
            throw new IllegalArgumentException(index + " 索引错误");
        return (index+1) * 2;
    }

    //交换两个索引的元素
    private void swap(int i, int j){
        E temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    //添加元素
    public void add(E e){
        list.add(e);
        int i = list.size()-1;//索引
        while (i > 0 && e.compareTo(list.get(parent(i))) > 0){//sift up
            swap(i,parent(i));
            i = parent(i);
        }
    }


    //移除元素
    public E remove(){
        E e = list.get(0);
        list.set(0,list.get(list.size() - 1));//将最后的元素赋值给头节点
        list.remove(list.size() - 1);//删除尾节点

        int i = 0;

        //下浮
        siftdown(i);

        return e;
    }

    //替换元素
    public E replace(E e){
        E out = list.get(0);
        list.set(0,e);

        siftdown(0);

        return out;
    }

    //heapify，将最后一个非叶子节点到根节点依次sift down
    public MaxHeap(List<E> list1){
        list = list1;
        int last = parent(list1.size() - 1);
        while (last >= 0){
            siftdown(last);
            last --;
        }
    }


    private void siftdown(int i){
        while (i < list.size() && leftChild(i) < list.size()){
            //判断左右最大节点
            int maxIndex = leftChild(i);
            if (maxIndex + 1 < list.size()){
                maxIndex = list.get(maxIndex+1).compareTo(list.get(maxIndex)) > 0 ? maxIndex+1 : maxIndex;
            }
            if (list.get(i).compareTo(list.get(maxIndex)) < 0){
                swap(i,maxIndex);
                i = maxIndex;
            } else {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "list=" + list;
    }

    public static void main(String agrs[]){
        /*MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(4);
        maxHeap.add(2);
        maxHeap.add(8);
        maxHeap.add(6);
        System.out.println(maxHeap);
        maxHeap.remove();
        System.out.println(maxHeap);
        maxHeap.replace(0);
        System.out.println(maxHeap);*/



        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(7);
        System.out.println("heapify之前");
        System.out.println(list);
        MaxHeap<Integer> newMaxHeap = new MaxHeap<>(list);
        System.out.println("heapify之后");
        System.out.println(newMaxHeap);
    }

}
