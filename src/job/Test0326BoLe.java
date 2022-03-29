package job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test0326BoLe {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算员工每月应缴（退）的税额
     * @param income double浮点型ArrayList 员工的每月应纳税收入
     * @return string字符串ArrayList
     */
    public ArrayList<String> calcTax (ArrayList<Double> income) {
        // write code here
        List<String> res = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < income.size(); i++) {
            double curIncome = income.get(i) - 5000;
            if (curIncome < 0) {
                break;
            }
            sum += curIncome;
            double curRes = 0;

            if (sum <= 36000) {
                curRes = curIncome * 0.03;
            } else if (sum <= 144000) {
                if (sum - curIncome < 36000) {
                    curRes = (36000 + curIncome - sum) * 0.03  + (sum - 36000) * 0.1;
                } else {
                    curRes = curIncome * 0.1;
                }
            } else if (sum <= 300000) {
                if (sum - curIncome < 144000) {
                    curRes = (144000 + curIncome - sum) * 0.1 + (sum - 144000) * 0.2;
                } else {
                    curRes = curIncome * 0.1;
                }
            } else if (sum <= 420000) {
                if (sum - curIncome < 300000) {
                    curRes = (300000 + curIncome - sum) * 0.2 + (sum - 300000) * 0.25;
                } else {
                    curRes = curIncome * 0.1;
                }
            } else if (sum <= 660000) {
                if (sum - curIncome < 420000) {
                    curRes += (420000 + curIncome - sum) * 0.25 + (sum - 420000) * 0.3;
                } else {
                    curRes = curIncome * 0.1;
                }
            } else if (sum <= 960000) {
                if (sum - curIncome < 660000) {
                    curRes += (660000 + curIncome - sum) * 0.3 + (sum - 660000) * 0.35;
                } else {
                    curRes = curIncome * 0.1;
                }
            } else {
                if (sum - curIncome < 960000) {
                    curRes += (960000 + curIncome - sum) * 0.35 + (sum - 960000) * 0.45;
                } else {
                    curRes = curIncome * 0.1;
                }
            }
            res.add(Double.toString(curRes) + "0");
        }
        return new ArrayList<>(res);
    }

    private double calcHelper(double start, double end) {
        return 0.0;
    }



    private double calcTaxHelper(double income) {
        if (income <= 36000) {
            return income * 0.03;
        } else if (income <= 144000) {
            return (income - 36000) * 0.1 + 36000 * 0.03;
        } else if (income <= 300000) {
            return (income - 144000) * 0.2;
        } else if (income <= 420000) {
            return (income - 300000) * 0.25;
        } else if (income <= 660000) {
            return (income - 420000) * 0.30;
        } else if (income <= 960000) {
            return (income - 660000) * 0.35;
        } else {
            return (income - 960000) * 0.45;
        }
    }

    public int maxArea (ArrayList<Integer> height) {
        // write code here
        int max = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int area = Math.min(height.get(i), height.get(j)) * (j - i);
                if (area > max) {
                    max= area;
                }
            }
        }
        return max;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 输入s为一个长度为n的字符串，t是一个长度为m的字符串， 1<= s.length <= 10**9,  1 <= t.length <= 10**9。
     * @param s string字符串
     * @param t string字符串
     * @return int整型
     */
    public int MatchStringO (String s, String t) {
        // write code here
        char[] target = t.toCharArray();

        int res = 0;
        while (s.length() > 0) {
            boolean flag = true;
            for (int i = 0; i < target.length; i++) {
                if (s.indexOf(target[i]) == -1) {
                    flag = false;
                    break;
                } else {
                    s.replace(target[i], ' ');
                }
            }
        }
        return res;
    }

    public int MatchString (String s, String t) {
        // write code here
        int[] str = helper(s.toCharArray());
        int[] tar = helper(t.toCharArray());
        char[] target = t.toCharArray();

        int min = str[target[0] - 'a'];
        for (int i = 0; i < target.length; i++) {
            min = Math.min(min, str[target[i] - 'a']);
            if (tar[target[i] - 'a'] > 1) {
                min = Math.min(min, str[target[i] - 'a'] / tar[target[i] - 'a']);
            }
        }
        return min;
    }

    private int[] helper(char[] s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length; i++) {
            res[s[i] - 'a']++;
        }
        return res;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型ArrayList
     * @param k int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> heap_top_k (ArrayList<Integer> nums, int k) {
        // write code here
        Collections.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = nums.size() - 1; i > nums.size() - k - 1; i--) {
            res.add(nums.get(i));
        }
        return res;
    }
}
