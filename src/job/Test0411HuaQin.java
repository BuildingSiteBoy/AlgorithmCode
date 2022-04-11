package job;

import java.util.ArrayList;
import java.util.List;

/**
 * 华勤集团笔试
 * @author zZeng
 */
public class Test0411HuaQin {
    public int doSomething() {
        //private String s = "  ";
        //int l = s.length();
        return 1 % 9;
    }

    public static void main(String[] args) {
        //System.out.println(doSomething());
        Integer l = new Integer(42);
        Long L = new Long(42);
        Double d = new Double(42.0);
        //System.out.println(l == L);
        //System.out.println(l == d);
        //System.out.println(L == d);
        System.out.println(l.equals(d));

        //List<int> list = new ArrayList<>();

        int a = 10, n = 10;
        System.out.println(~a);

        if (n++ > 10) {
            System.out.println("ddd" + n);
        } else {
            System.out.println("ccc" + n);
        }
    }
}
