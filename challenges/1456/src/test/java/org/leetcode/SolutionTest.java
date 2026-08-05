package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {
    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(
                        "abciiidef",
                        3,
                        3
                ),
                Arguments.of(
                        "aeiou",
                        3,
                        3
                ),
                Arguments.of(
                        "leetcode",
                        3,
                        2
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(String s, int k, int result) {
        Solution solution = new Solution();

        assertEquals(result, solution.maxVowels(s, k));
    }
}
