package org.leetcode;

public class Solution {
    private boolean repeated(char[] str, char[] pattern, int pLen) {
        for (int i = 0; i < str.length;)
            for (int j = 0; j < pLen; j++)
                if (i == str.length || str[i++] != pattern[j])
                    return false;

        return true;
    }

    public String gcdOfStrings(String str1, String str2) {
        char[] _str1 = str1.toCharArray();
        char[] _str2 = str2.toCharArray();
        char[] pattern = _str1.length < _str2.length ? _str1 : _str2;
        int pLen = pattern.length;

        while (pLen > 0) {
            if (repeated(_str1, pattern, pLen) && repeated(_str2, pattern, pLen))
                return new String(pattern, 0, pLen);

            pLen--;
        }

        return "";
    }
}

//class Solution {
//    public String gcdOfStrings(String str1, String str2) {
//
//        // If the strings cannot be formed by repeating the same pattern
//        if (!(str1 + str2).equals(str2 + str1)) {
//            return "";
//        }
//        // Find the GCD of the lengths
//        int gcdLength = gcd(str1.length(), str2.length());
//
//        // Return the prefix of the GCD length
//        return str1.substring(0, gcdLength);
//    }
//
//    private int gcd(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
//}
