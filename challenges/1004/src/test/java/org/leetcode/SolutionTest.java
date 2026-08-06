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
                        new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                        2,
                        6
                ),
                Arguments.of(
                        new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                        3,
                        10
                ),
                Arguments.of(
                        new int[]{0, 0, 1, 1, 1, 0, 0},
                        0,
                        3
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] nums, int k, int result) {
        Solution s = new Solution();

        assertEquals(result, s.longestOnes(nums, k));
    }
}
