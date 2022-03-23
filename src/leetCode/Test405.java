package leetCode;

/**
 * 405. 数字转换为十六进制数
 * @author 曾奕
 */
public class Test405 {
    public String toHex(int num) {
        // 错误：负数要以补码形式出现
        //return Integer.toString(num, 16);
        return Integer.toHexString(16);
    }

    public String toHexE(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    public String toHexO(int num) {
        String m = "0123456789abcdef";
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        long temp = num;
        if (num < 0) {
            temp = (long)(Math.pow(2, 32) - Math.abs(num));
        }
        while (temp != 0) {
            sb.append(m.charAt((int) (temp % 16)));
            temp /= 16;
        }
        return sb.reverse().toString();
    }
}
