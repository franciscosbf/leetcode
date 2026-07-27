package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SolutionTest {
    @ParameterizedTest
    @CsvSource({
            "abc, pqr, apbqcr",
            "ab, pqrs, apbqrs",
            "abcd, pq, apbqcd"
    })
    public void testSolution(String word1, String word2, String result) {
        Solution s = new Solution();

        assertEquals(result, s.mergeAlternately(word1, word2));
    }
}
