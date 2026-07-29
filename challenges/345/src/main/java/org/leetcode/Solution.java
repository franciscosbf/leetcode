package org.leetcode;

public class Solution {
    private boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

    public String reverseVowels(String s) {
        char[] _s = s.toCharArray();

        for (int i = 0, j = _s.length - 1; i < j;) {
            boolean iv = isVowel(_s[i]);
            boolean jv = isVowel(_s[j]);
            if (iv && jv) {
                _s[i] ^= _s[j];
                _s[j] = (char) (_s[i] ^ _s[j]);
                _s[i] ^= _s[j];
                i++; j--;
                continue;
            }
            if (!iv) i++;
            if (!jv) j--;
        }

        return new String(_s);
    }
}
