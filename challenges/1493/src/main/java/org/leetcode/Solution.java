package org.leetcode;

public class Solution {
    public int longestSubarray(int[] nums) {
        int c = 0;
        int _k = 1;
        for (int num : nums) {
            if (num == 0) {
                if (_k == 0) break;
                _k--;
            }
            else c++;
        }
        if (c == nums.length) return c - 1;
        int mc = c;
        for (int i = 1; i + c < nums.length; i++) {
            _k = nums[i - 1] == 0 ? 1 : _k;
            c = Math.max(c - 1, 0);
            for (int j = i + c; j < nums.length; j++) {
                if (nums[j] == 0) {
                    if (_k == 0) break;
                    _k--;
                }
                else c++;
            }
            if (c > mc) mc = c;
        }
        return mc;
    }
}
