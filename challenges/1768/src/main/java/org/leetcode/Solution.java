package org.leetcode;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(word1.length() + word2.length());

        int i = 0;
        int minLen = Math.min(word1.length(), word2.length());
        for (; i < minLen; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        String word = word1.length() == minLen ? word2 : word1;
        for (; i < word.length(); i++)
            sb.append(word.charAt(i));

        return sb.toString();
    }
}
