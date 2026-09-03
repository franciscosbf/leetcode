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
                        new int[]{1, 1, 0, 1},
                        3
                ),
                Arguments.of(
                        new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1},
                        5
                ),
                Arguments.of(
                        new int[]{1, 1, 1},
                        2
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] nums, int result) {
        Solution s = new Solution();

        assertEquals(result, s.longestSubarray(nums));
    }
}
