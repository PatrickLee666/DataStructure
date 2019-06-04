package struct.segmenttree;

/**
 * @author 李俊锋
 * @date 2019/5/13 22:13
 */
public class Test {
    public static void main(String agrs[]){
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums,(a, b) -> a+b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0,3));

    }
}
