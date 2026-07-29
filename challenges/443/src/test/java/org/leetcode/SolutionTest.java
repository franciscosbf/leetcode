package org.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.Arrays;

public class SolutionTest {
    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(
                        new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'},
                        6,
                        new char[]{'a', '2', 'b', '2', 'c', '3'}
                ),
                Arguments.of(
                        new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
                        4,
                        new char[]{'a', 'b', '1', '2'}
                ),
                Arguments.of(
                        new char[]{'a', 'b', 'c'},
                        3,
                        new char[]{'a', 'b', 'c'}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(char[] chars, int result, char[] rChars) {
        Solution s = new Solution();

        assertEquals(result, s.compress(chars));
        chars = Arrays.copyOfRange(chars, 0, rChars.length);
        assertArrayEquals(rChars, chars);
    }
}
