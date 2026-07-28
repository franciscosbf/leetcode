package org.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int findMax(int[] candies) {
        int max = -1;
        for (int candy : candies) if (candy > max) max = candy;
        return max;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> greatest = new ArrayList<>(candies.length);
        int max = findMax(candies);
        for (int candy : candies) greatest.add(candy + extraCandies >= max);
        return greatest;
    }
}
