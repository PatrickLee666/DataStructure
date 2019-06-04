package struct.segmenttree;

/**
 * @author 李俊锋
 * @date 2019/5/13 17:53
 */
public interface Merger<E> {
    E merge(E a, E b);
}
