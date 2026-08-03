package org.leetcode;

import java.util.*;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> kns = new HashMap<>();
        for (int num : nums) {
            kns.compute(num, (key, value) -> (value == null) ? 1 : value + 1);
        }
        int operations = 0;
        for (int num : nums) {
            int c1 = kns.get(num);
            if (c1 == 0) continue;
            kns.put(num, c1 - 1);
            int t = k - num;
            Integer c2 = kns.get(t);
            if (c2 == null || c2 == 0) continue;
            kns.put(t, c2 - 1);
            operations++;
        }
        return operations;
    }
}
