package job;

/**
 * 六方云笔试测试
 * @author 曾奕
 */
public class Test0406LiuFangYun {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(a);
        System.out.println(a++);
        System.out.println(a);

        a = 5;

        char c = 'B';
        switch (c) {
            case 'B':
                a++;
            case 'A':
                a++;
            case 'Y':
                a++;
            break;
            default:
                a--;
        }

        System.out.println(a);
    }
}
