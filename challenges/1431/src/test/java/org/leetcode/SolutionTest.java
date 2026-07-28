package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {
    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 3, 5, 1, 3},
                        3,
                        List.of(true, true, true, false, true)
                ),
                Arguments.of(
                        new int[]{4, 2, 1, 1, 2},
                        1,
                        List.of(true, false, false, false, false)
                ),
                Arguments.of(
                        new int[]{12, 1, 12},
                        10,
                        List.of(true, false, true)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] candies, int extraCandies, List<Boolean> result) {
        Solution s = new Solution();

        assertEquals(result, s.kidsWithCandies(candies, extraCandies));
    }
}
