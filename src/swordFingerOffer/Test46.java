package swordFingerOffer;

/**
 * 动态规划
 * 剑指Offer 46.把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法。
 * */

public class Test46 {
    public static void main(String[] args) {

    }
}

class Solution46 {
    public int translateNum(int num) {
        if (num < 10)
            return 1;

        int temp = num % 100;

        if (temp < 10 || temp > 25)
            return translateNum(num / 10);
        else
            return translateNum(num / 10) + translateNum(num / 100);
    }
}