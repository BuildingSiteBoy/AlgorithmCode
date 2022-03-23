package leetCode;

/**
 * 168. Excel表列名称
 * @author 曾奕
 */
public class Test168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        columnNumber--;
        return convertToTitle(columnNumber / 26) + (char) (columnNumber % 26 + 'A');
    }

    public String convertToTitleE(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
