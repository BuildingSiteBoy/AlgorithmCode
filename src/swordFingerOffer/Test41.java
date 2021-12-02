package swordFingerOffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 排序
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * */

public class Test41 {
    public static void main(String[] args) {

    }
}

class MedianFinder41 {
    Queue<Integer> A, B;

    /** initialize your data structure here. */
    public MedianFinder41() {
        //PriorityQueue: 具有小顶堆性质的优先队列
        A = new PriorityQueue<>();          //小顶堆，保存数较大的部分
        B = new PriorityQueue<>(new Comparator<Integer>() {
            @Override                       //从写比较方法
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });                                 //大顶堆，保存数较小的部分
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? (A.peek() + B.peek())/2.0 : A.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */