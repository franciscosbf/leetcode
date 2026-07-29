package org.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] ss = s.split(" +");
        Collections.reverse(Arrays.asList(ss));
        return String.join(" ", ss);
    }
}
