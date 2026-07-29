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
                        new int[]{1, 0, 0, 0, 1},
                        1,
                        true
                ),
                Arguments.of(
                        new int[]{1, 0, 0, 0, 1},
                        2,
                        false
                ),
                Arguments.of(
                        new int[]{1, 0, 0, 0, 0, 1},
                        2,
                        false
                ),
                Arguments.of(
                        new int[]{0, 0, 1, 0, 1},
                        1,
                        true
                ),
                Arguments.of(
                        new int[]{1, 0, 0, 0, 1, 0, 0},
                        2,
                        true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] flowerbed, int n, boolean result) {
        Solution s = new Solution();

        assertEquals(result, s.canPlaceFlowers(flowerbed, n));
    }
}
