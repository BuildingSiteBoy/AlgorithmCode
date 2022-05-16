package job;

import java.util.List;

/**
 * 385. 迷你语法分析器
 * @author 曾奕
 */
public class Test385 {
    int index = 0;

    //public NestedInteger deserialize(String s) {
    //    if (s.charAt(index) == '[') {
    //        index++;
    //        NestedInteger nestedInteger = new NestedInteger();
    //        while (s.charAt(index) != ']') {
    //            nestedInteger.add(deserialize(s));
    //            if (s.charAt(index) == ',') {
    //                index++;
    //            }
    //        }
    //        index++;
    //        return nestedInteger;
    //    } else {
    //        boolean negative = false;
    //        if (s.charAt(index) == '-') {
    //            negative = true;
    //            index++;
    //        }
    //        int num = 0;
    //        while (index < s.length() && Character.isDigit(s.charAt(index))) {
    //            num = num * 10 + s.charAt(index) - '0';
    //            index++;
    //        }
    //        if (negative) {
    //            num *= -1;
    //        }
    //        return new NestedInteger(num);
    //    }
    //}
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list.
    //public NestedInteger();

    // Constructor initializes a single integer.
    //public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
