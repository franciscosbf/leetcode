package org.leetcode;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length + 1]; left[0] = 1;
        int[] right = new int[nums.length + 1]; right[nums.length] = 1;
        for (int i = 1, j = nums.length - 1; j >= 0; i++, j--) {
            left[i] = nums[i - 1] * left[i - 1];
            right[j] = nums[j] * right[j + 1];
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = left[i] * right[i + 1];
        return nums;
    }
}
