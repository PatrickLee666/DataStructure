package struct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李俊锋
 * @date 2019/5/27 8:36
 */
public class Test {
    public static void main(String ahrs[]){
        Map map = new HashMap();
        A a = new A();
        A a1 = new A();
        map.put(null,null);
        map.put(null,1);
        map.put(a,null);
        System.out.println();
        map.put(a1,a1);
        System.out.println(map);
    }
}
class A{
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}