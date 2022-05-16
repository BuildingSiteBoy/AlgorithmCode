package job;

import java.util.Scanner;

/**
 * 老板一共需要给某个员工发奖金n元，可以选择一次发1元，也可以选择一次发2元，也可以选择一次发3元。
 * 请问老板给这位员工发放完n元奖金共有多少种不同的方法？
 * @author 曾奕
 */
public class Test0411Qi01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print ("输入要发的奖金:");
        int number = scanner.nextInt ();
        System.out.println ("您有" + f (number) + "种方法发完" + number + "元奖金!!");
    }

    /**
     * 获取 发奖金可用的总方法 的方法
     *
     * @param number 要发的钱数
     * @return 总方法数
     */
    public static int f(Integer number) {
        // 设置递归结束条件
        if (number == 1) {
            return 1;
        }
        // 实现 f(n) = f(n-1) + f(n-2) + ... + f(1) + 1
        int count = 0;
        for (int i = number - 1; i >= 1; i--) {
            count = f (i) + count;
        }
        return count + 1;
    }
}
