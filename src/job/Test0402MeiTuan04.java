package job;

import java.util.Scanner;

/**
 * 负载均衡
 * 小团从某海鲜市场买到了一块3核CPU来应对他需要进行的高性能计算任务。小团一共有n个计算任务，编号分别为1到n。编号为i的任务需要运行ai秒。为了避免进程切换带来的开销，小团只能同时运行三个任务。也就是说，他需要将这n个任务分成三组，并分别分配到CPU的三个核心上。现在他想知道完所有任务至少需要多少秒。
 *
 * 第一行有一个正整数n(1<=n<=100)，代表计算任务的数量。
 *
 * 第二行有n个大小不超过1000的正整数，空格隔开，分别代表编号为1到n的计算任务所需的运行时长。
 *
 * 输入数据保证答案不超过1000。
 *
 * 输出一个正整数，代表完成所有任务所需要的时间。
 * @author 曾奕
 */
public class Test0402MeiTuan04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入数据
        int n = in.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }
        System.out.println(sum / 3 + sum % 3);
    }
}
