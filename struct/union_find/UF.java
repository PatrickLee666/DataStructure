package struct.union_find;

/**
 * @author 李俊锋
 * @date 2019/5/16 20:20
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
