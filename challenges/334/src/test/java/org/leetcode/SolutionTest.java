package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {
    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, false),
                Arguments.of(new int[]{2, 1, 5, 0, 4, 6}, true),
                Arguments.of(new int[]{20, 100, 10, 12, 5, 13}, true),
                Arguments.of(new int[]{2, 1, 5, 0, 4}, false),
                Arguments.of(new int[]{1, 2, 1, 3}, true),
                Arguments.of(new int[]{3, 3, 3, 2, 0, 1, 1}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] nums, boolean result) {
        Solution s = new Solution();

        assertEquals(result, s.increasingTriplet(nums));
    }
}
