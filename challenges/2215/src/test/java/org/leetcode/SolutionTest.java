package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {
    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{2, 4, 6},
                        List.of(List.of(1, 3), List.of(4, 6))
                ),
                Arguments.of(
                        new int[]{1, 2, 3, 3},
                        new int[]{1, 1, 2, 2},
                        List.of(List.of(3), List.of())
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(int[] nums1, int[] nums2, List<List<Integer>> result) {
        Solution s = new Solution();

        assertEquals(result, s.findDifference(nums1, nums2));
    }
}
