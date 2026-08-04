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
                        new int[]{1, 12, -5, -6, 50, 3},
                        4,
                        12.75000
                ),
                Arguments.of(
                        new int[]{5},
                        1,
                        5.00000
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] nums, int k, double result) {
        Solution s = new Solution();

        assertEquals(result, s.findMaxAverage(nums, k));
    }
}
