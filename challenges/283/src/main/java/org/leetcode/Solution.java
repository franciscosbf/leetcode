package org.leetcode;

public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 1; i < nums.length && j < nums.length; j++) {
            if (nums[i] == 0 && nums[j] != 0) {
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
                i++;
            } else if (nums[i] != 0) i++;
        }
    }
}
