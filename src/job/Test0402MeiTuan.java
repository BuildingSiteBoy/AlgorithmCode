package job;

import java.util.Scanner;

/**
 * 双色球
 *  * 小团的桌子上有一列球。每个球要么是红色的要么是蓝色的。小团的口袋里也有一些球，这些球也都涂上了红色或蓝色。小团不喜欢看到相同颜色的球相邻，因此他希望将口袋里的一些球插入桌上的这列球使得相同颜色的球不相邻。现在他想知道，如果他能够达成他的期望，则达成时桌上这列球最短有多长？如果这是不可能的，他想知道他还需要多少个红球以及多少个蓝球才能达成他的期望。
 *
 *  第一行有三个正整数，n，r，b，分别代表桌上球的数量，口袋里红球的数量，和口袋里蓝球的数量。
 *
 * 这三个数的大小均不超过100000。
 *
 * 第二行有一个长度为n的仅由r和b组成的字符串。第i个字符代表桌上这一列球中的第i个的颜色是红色还是蓝色；红色则为r，蓝色则为b。
 *
 * 若可以通过将口袋里的一些球插入桌上的这列球使得相同颜色的球不相邻，则输出达成这一目标后桌上球的最少数量。否则输出两个数，代表还需要至少多少个红球和多少个蓝球才能达成这一目标。
 * @author zZeng
 */
public class Test0402MeiTuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数据
        int n = in.nextInt();
        int b = in.nextInt();
        int r = in.nextInt();
        // 接受回车
        in.nextLine();
        String balls = in.nextLine();

        //System.out.println(b);
        //System.out.println(balls);
        if (n < 2) {
            System.out.println(balls.length());
        }

        /**
         *             int count = 0;
         *             char cur = balls.charAt(i);
         *             while (balls.charAt(i) == balls.charAt(i + 1) && i < balls.length() - 1) {
         *                 i++;
         *                 count++;
         *             }
         *             if (cur == 'r') {
         *                 outR += count;
         *             } else {
         *                 outB += count;
         *             }
         */
        int outR = 0, outB = 0;
        for (int i = 0; i < balls.length() - 1; i++) {
            if (balls.charAt(i) == balls.charAt(i + 1)) {
                if (balls.charAt(i) == 'r') {
                    outR++;
                } else {
                    outB++;
                }
            }
        }

        if (outR <= r && outB <= b) {
            System.out.println(balls.length() + outR + outB);
        } else if (outR > r && outB <= b) {
            System.out.println((outR - r) + " " + 0);
        } else if (outB > b && outR <= r) {
            System.out.println(0 + " " + (outB - b));
        } else {
            System.out.println((outR - r) + " " + (outB - b));
        }
    }
}
