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
                        new int[]{-5, 1, 5, 0, -7},
                        1
                ),
                Arguments.of(
                        new int[]{-4, -3, -2, -1, 4, 3, 2},
                        0
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] gain, int result) {
        Solution s = new Solution();

        assertEquals(result, s.largestAltitude(gain));
    }
}
