package job;

/**
 * @author zZeng
 */
public class Test0331Cvte {
    public static void main(String[] args) {
        String str = "zZeng12";
        String[] temp = str.split("e");
        System.out.println(temp);
        System.out.println(str.substring(0, 1));
        System.out.println(Integer.valueOf(str.substring(5, 7)));
        str.charAt(1);


        //System.out.println(new Test0331Cvte());   java.lang.StackOverflowError

        Integer a = new Integer(128);
        int b = 128;
        Integer c = Integer.valueOf(128);
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(b == d);


        System.out.println("52" + 0);
        String s = null;
        System.out.println("s = " + s);

        System.out.println("================分割线==================");

        String s1 = "hello";
        String s2 = "he" + new String("llo");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("================分割线==================");

        new Test0331Cvte().Test0331Cute(20);

        System.out.println("================分割线==================");

        StringBuilder sb = new StringBuilder("abc");

        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("a");
            }
        };
        t.run();
        System.out.println("b");
    }

    public int Test0331Cute(int i) {
        System.out.println("成员函数名与类名可以相同！！！" + i);
        return i;
    }

    @Override
    public String toString() {
        return "hello" + this.toString();
    }
}
