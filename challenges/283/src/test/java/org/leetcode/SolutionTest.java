package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class SolutionTest {
    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{0, 1, 0, 3, 12},
                        new int[]{1, 3, 12, 0, 0}
                ),
                Arguments.of(
                        new int[]{0},
                        new int[]{0}
                ),
                Arguments.of(
                        new int[]{2, 1},
                        new int[]{2, 1}
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{1, 2, 3, 4, 5}
                ),
                Arguments.of(
                        new int[]{1, 2, 0, 0, 3, 4, 5},
                        new int[]{1, 2, 3, 4, 5, 0, 0}
                ),
                Arguments.of(
                        new int[]{1, 2, 0, 0, 3, 4, 0, 5},
                        new int[]{1, 2, 3, 4, 5, 0, 0, 0}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] nums, int[] result) {
        Solution s = new Solution();

        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums) + " " + Arrays.toString(result));
        assertArrayEquals(nums, result);
    }
}
