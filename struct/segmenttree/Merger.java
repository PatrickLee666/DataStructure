package struct.segmenttree;

/**
 * @author lee
 * @date 2019/5/13 17:53
 */
public interface Merger<E> {
    E merge(E a, E b);
}
