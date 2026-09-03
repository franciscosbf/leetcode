package org.leetcode;

public class Solution {
    public int pivotIndex(int[] nums) {
        int[][] sums = new int[nums.length + 2][2];

        for (int i = 1; i < sums.length - 1; i++) {
            sums[i][0] = sums[i - 1][0] + nums[i - 1];
            sums[sums.length - 1 - i][1] = sums[sums.length - i][1] + nums[sums.length - 1 - i - 1];
        }

        for (int i = 1; i < sums.length - 1; i++)
            if (sums[i][0] == sums[i][1]) return i - 1;

        return -1;
    }
}
