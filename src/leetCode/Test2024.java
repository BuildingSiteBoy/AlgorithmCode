package leetCode;

/**
 * @author 曾奕
 */
public class Test2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxChar(answerKey, k, 'T'), maxChar(answerKey, k, 'F'));
    }

    private int maxChar(String answerKey, int k, char c) {
        int n = answerKey.length();
        int ans = 0;
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            sum += answerKey.charAt(r) != c ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(l++) != c ? 1 : 0;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
