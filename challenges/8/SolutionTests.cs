using Xunit;

namespace _8.Solution;

public class SolutionTests {
    [Theory]
    // LeetCode examples
    [InlineData("42", 42)]
    [InlineData(" -042", -42)]
    [InlineData("1337c0d3", 1337)]
    [InlineData("0-1", 0)]
    [InlineData("words and 987", 0)]
    // No digits to read
    [InlineData("", 0)]
    [InlineData("   ", 0)]
    [InlineData("+", 0)]
    [InlineData("-", 0)]
    [InlineData("+-12", 0)]
    [InlineData(" +0 123", 0)]
    // Leading zeros
    [InlineData("00000000000012345678", 12345678)]
    [InlineData("-0000001", -1)]
    // 32-bit limits and clamping
    [InlineData("2147483647", int.MaxValue)]
    [InlineData("2147483648", int.MaxValue)]
    [InlineData("-2147483648", int.MinValue)]
    [InlineData("-2147483649", int.MinValue)]
    [InlineData("91283472332", int.MaxValue)]
    [InlineData("-91283472332", int.MinValue)]
    public void TestSolution(string s, int expected) {
        Solution solution = new();

        Assert.Equal(expected, solution.MyAtoi(s));
    }
}
