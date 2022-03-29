package job;

/**
 * @author zZeng
 */
public class Test0327KaiHong {
    public static int exceptionTest(){
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(Test0327KaiHong.exceptionTest());
    }
}
