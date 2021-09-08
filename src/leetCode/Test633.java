package leetCode;

public class Test633 {
    public static void main(String[] args) {
        Solution633 s = new Solution633();
        System.out.println(s.judgeSquareSum(117));
    }
}

class Solution633{
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int)Math.sqrt(c);

        while(i <= j) {
            int powSum = i * i + j * j;

            if (powSum == c) {
                //System.out.println("i = " + i + ", j = " + j);
                return true;
            } else if (powSum < c) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
