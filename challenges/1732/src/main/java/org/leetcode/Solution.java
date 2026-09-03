package org.leetcode;

public class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int s = 0;

        for (int g: gain)
            if ((s += g) > max)
                max = s;

        return max;
    }
}
