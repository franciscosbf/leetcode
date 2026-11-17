namespace Challenge.Tests;

public class SolutionTest
{
    public static IEnumerable<object[]> Data =>
        [
            [new int[][]{[1], [2], [3], []}, true],
            [new int[][]{[1, 3], [3, 0, 1], [2], [0]}, false],
        ];

    [Theory]
    [MemberData(nameof(Data))]
    public void ShouldPass(IList<IList<int>> rooms, bool expected)
    {
        Assert.Equal(expected, new Solution().CanVisitAllRooms(rooms));
    }
}
