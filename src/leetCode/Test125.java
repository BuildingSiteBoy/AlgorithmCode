package leetCode;

/*
* 验证回文串
* */

public class Test125 {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car00000";

        System.out.println(new Solution125().isPalindrome(s1));
        System.out.println(new Solution125().isPalindrome(s2));
        System.out.println(new Solution125_02().isPalindrome(s1));
        System.out.println(new Solution125_02().isPalindrome(s2));
    }
}

//使用StringBuild的reverse方法来判断是否为回文串
class Solution125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
                sb.append(c);
        }

//        String re = sb.reverse().toString();
//        sb.reverse();
//
//        return re.equals(sb.toString());
        return sb.toString().equals(sb.reverse().toString());
    }
}

//双指针算法
class Solution125_02 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if ((c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1 <= '9')) {
                if ((c2 >= 'a' && c2 <= 'z') || (c2 >= '0' && c2 <= '9')) {
                    if (c1 == c2) {
                        i++;
                        j--;
                    } else {
                        return false;
                    }
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }

        return true;
    }
}