package org.leetcode;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int c = 0;
        int _k = k;
        for (int num : nums) {
            if (num == 0) {
                if (_k == 0) break;
                _k--;
            }
            c++;
        }
        int mc = c;
        for (int i = 1; i + c < nums.length; i++) {
            _k = nums[i - 1] == 0 ? Math.min(_k + 1, k) : _k;
            c = Math.max(c - 1, 0);
            for (int j = i + c; j < nums.length; j++) {
                if (nums[j] == 0) {
                    if (_k == 0) break;
                    _k--;
                }
                c++;
            }
            if (c > mc) mc = c;
        }
        return mc;
    }
}
