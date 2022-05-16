package leetCode;

/**
 * 171. Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * @author 曾奕
 */
public class Test171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int len = columnTitle.length() - 1;

        for (int i = len; i >= 0; i--) {
            int j = len - i;
            res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, j);
        }

        return res;
    }
}
