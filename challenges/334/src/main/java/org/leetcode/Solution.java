package org.leetcode;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        long first = Long.MAX_VALUE;
        long second = Long.MAX_VALUE;
        for (int third: nums) {
            if (second < third)
                return true;
            else if (third <= first)
                first = third;
            else
                second = third;
        }
        return false;
    }
}
