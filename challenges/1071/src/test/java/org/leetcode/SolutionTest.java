package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SolutionTest {
    @ParameterizedTest
    @CsvSource({
            "ABCABC, ABC, ABC",
            "ABABAB, ABAB, AB",
            "LEET, CODE, ''",
            "AAAAAB, AAA, ''",
            "AA, A, A"
    })
    public void testSolution(String str1, String str2, String result) {
        Solution s = new Solution();

        assertEquals(result, s.gcdOfStrings(str1, str2));
    }
}
