package org.leetcode;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) return 0;
        int ps = 0;
        for (int i = 0; i < k; i++) ps += nums[i];
        int maxs = ps;
        for (int i = 1; i + k - 1 < nums.length; i++) {
            ps = nums[i + k - 1] + ps - nums[i - 1];
            if (ps > maxs) maxs = ps;
        }
        return maxs / (double) k;
    }
}
