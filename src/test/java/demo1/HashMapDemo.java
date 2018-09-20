package demo1;

import java.security.spec.PSSParameterSpec;
import java.util.HashMap;

/**
 * @author wu
 * @Description:
 * @Title: HashMapDemo
 * @date 2018-9-20 11:18
 */
public class HashMapDemo {
    public static void main(String[] args) {
        int a=1;
        System.out.println(0000001000001000);
    }

    public static final int demo(int cap){
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
