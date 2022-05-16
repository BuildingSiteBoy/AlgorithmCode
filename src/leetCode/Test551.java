package leetCode;

/**
 * 551. 学生出勤记录 I
 * @author 曾奕
 */
public class Test551 {
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) {
            return false;
        }

        int countA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                countA++;
            }
            if (countA > 1) {
                return false;
            }
        }

        return true;
    }

    // Java 一行搞定
    public boolean checkRecordA(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
