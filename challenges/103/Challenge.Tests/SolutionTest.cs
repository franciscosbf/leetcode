namespace Challenge.Tests;

public class SolutionTest
{
    public static IEnumerable<object[]> Cases() =>
    [
        [
            new TreeNode
            {
                val = 3,
                left = new TreeNode
                {
                    val = 9
                },
                right = new TreeNode
                {
                    val = 20,
                    left = new TreeNode
                    {
                        val = 15
                    },
                    right = new TreeNode
                    {
                        val = 7
                    }
                }
            },
            new List<List<int>> { new() { 3 }, new() { 20, 9 }, new() { 15, 7 } },
        ],
                [
            new TreeNode
            {
                val = 3,
                left = new TreeNode
                {
                    val = 9,
                    left = new TreeNode
                    {
                        val = 8
                    },
                    right = new TreeNode
                    {
                        val = 10
                    }
                },
                right = new TreeNode
                {
                    val = 20,
                    left = new TreeNode
                    {
                        val = 15
                    },
                    right = new TreeNode
                    {
                        val = 7
                    }
                }
            },
            new List<List<int>> { new() { 3 }, new() { 20, 9 }, new() { 8, 10, 15, 7 } },
        ]
    ];

    [Theory]
    [MemberData(nameof(Cases))]
    public void ShouldPass(TreeNode root, List<List<int>> expected)
    {
        var actual = new Solution().ZigzagLevelOrder(root);
        Assert.True(actual.Count > 0);
        Assert.Equal(expected, actual);
    }
}
