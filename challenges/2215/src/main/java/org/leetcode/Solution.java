package org.leetcode;

import java.util.*;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> presences1 = new HashSet<>();
        Set<Integer> presences2 = new HashSet<>();

        for (int n : nums1) presences1.add(n);
        for (int n : nums2) presences2.add(n);

        List<Integer> diff1 = presences1.stream().filter(n -> !presences2.contains(n)).toList();
        List<Integer> diff2 = presences2.stream().filter(n -> !presences1.contains(n)).toList();

        return List.of(diff1, diff2);
    }
}
