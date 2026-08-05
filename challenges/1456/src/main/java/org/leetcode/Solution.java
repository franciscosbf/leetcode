package org.leetcode;

public class Solution {
    private boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public int maxVowels(String s, int k) {
        if (s.length() < k) return 0;
        char[] chars = s.toCharArray();
        int c = 0;
        for (int i = 0; i < k; i++) if (isVowel(chars[i])) c++;
        int max = c;
        for (int i = 1; i + k - 1 < chars.length; i++)
            if ((c = c - (isVowel(chars[i - 1]) ? 1 : 0) + (isVowel(chars[i + k - 1]) ? 1 : 0)) > max) max = c;
        return max;
    }
}
