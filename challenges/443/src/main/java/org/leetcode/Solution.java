package org.leetcode;

public class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        char character = chars[0];
        int repetitions = 0;
        int compressed = 0;
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character)
                repetitions++;
            if (i + 1 == chars.length || chars[i + 1] != character) {
                chars[j++] = character;
                if (repetitions == 1)
                    compressed++;
                else {
                    char[] cRepetitions = String.valueOf(repetitions).toCharArray();
                    System.arraycopy(cRepetitions, 0, chars, j, cRepetitions.length);
                    j += cRepetitions.length;
                    compressed += 1 + cRepetitions.length;
                }
                if (i + 1 < chars.length)
                    character = chars[i + 1];
                repetitions = 0;
            }
        }
        return compressed;
    }
}
