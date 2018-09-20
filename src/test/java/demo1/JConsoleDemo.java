package demo1;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: JConsoleDemo 
 * @Description: TODO
 * @author: wujb
 * @date: 2018年7月19日 下午1:19:58  
 */
public class JConsoleDemo {

	/**
	 * @Title: main 
	 * @param args void
	 * @author wujb
	 * @date 2018年7月19日下午1:19:58
	 */
	static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc(); 
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        //System.gc();
        Thread.sleep(10000);
    }

}
