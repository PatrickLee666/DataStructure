package struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author 李俊锋
 * @date 2019/5/26 12:45
 */
public class ArrayAndLinklistTest {

    public static void main(String ar[]){
        long size = 1000000L;
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        long start = System.nanoTime();

        for (int i = 0; i < size;i++){
            arrayList.add(i,i);
        }

        long end = System.nanoTime();

        System.out.println((end-start)/1000000000.0);

        start = System.nanoTime();

        for (int i = 0; i < size;i++){
            linkedList.add(i,i);
        }

        end = System.nanoTime();

        System.out.println((end-start)/1000000000.0);
    }
}
