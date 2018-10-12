package demo1;

import java.security.spec.PSSParameterSpec;
import java.util.*;

/**
 * @author wu
 * @Description:
 * @Title: HashMapDemo
 * @date 2018-9-20 11:18
 */
public class HashMapDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("111");
            add("222");
            add("333");
        }};
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String x = it.next();
            if(x.equals("111")){
                it.remove();
            }
        }
        list.forEach(s -> System.out.println(s));
        new Thread(() -> System.out.println("新线程")).start();
        ArrayList<String> list1 = new ArrayList();
    }
}
