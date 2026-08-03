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
                        new int[]{1, 2, 3, 4},
                        5,
                        2
                ),
                Arguments.of(
                        new int[]{3, 1, 3, 4, 3},
                        6,
                        1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] nums, int k, int result) {
        Solution s = new Solution();

        assertEquals(result, s.maxOperations(nums, k));
    }
}
