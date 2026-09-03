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
                        new int[]{1, 7, 3, 6, 5, 6},
                        3
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        -1
                ),
                Arguments.of(
                        new int[]{2, 1, -1},
                        0
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] gain, int result) {
        Solution s = new Solution();

        assertEquals(result, s.pivotIndex(gain));
    }
}
