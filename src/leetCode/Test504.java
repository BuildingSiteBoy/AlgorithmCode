package leetCode;

/**
 * 504. 七进制数
 * @author 曾奕
 */
public class Test504 {
    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public String convertToBase7E(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }
        boolean flag = num < 0;

        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (flag) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Test504 test = new Test504();

        System.out.println(test.convertToBase7(-7));
        System.out.println(test.convertToBase7E(-7));
    }
}
