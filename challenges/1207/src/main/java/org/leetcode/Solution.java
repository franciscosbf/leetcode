package org.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int n : arr)
            occurrences.compute(n, (k, v) -> v == null ? 1 : v + 1);

        Set<Integer> matches = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet())
            if (!matches.add(entry.getValue())) return false;

        return true;
    }
}
