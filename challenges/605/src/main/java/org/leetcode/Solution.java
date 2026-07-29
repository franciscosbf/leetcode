package org.leetcode;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;

        if (flowerbed.length == 1)
            return n == 1 && flowerbed[0] == 0;

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        for (int i = 1; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0)
                if (i + 1 < flowerbed.length) {
                    if (flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                else n--;
        }

        return n == 0;
    }
}
