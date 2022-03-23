package leetCode;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 *
 * 记 n是数组{nums}的长度，数组中的每个元素都可以选取或者不选取，因此数组的非空子集数目一共有 (2^n-1) 个。
 * 可以用一个长度为 n比特的整数来表示不同的子集，在整数的二进制表示中，n个比特的值代表了对数组不同元素的取舍。
 * 第 i位值为 1 则表示该子集选取对应元素，第 i位值为0 则表示该子集不选取对应元素。
 * 求出每个子集的按位或的值，并计算取到最大值时的子集个数
 *
 * @author 曾奕
 */
public class Test2044 {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0, count = 0;
        for (int i = 0; i < 1 << nums.length; i++) {
            int orVal = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    orVal |= nums[j];
                }
            }
            if (orVal > maxOr) {
                maxOr = orVal;
                count = 1;
            } else if (orVal == maxOr) {
                count++;
            }
        }
        return count;
    }
}
