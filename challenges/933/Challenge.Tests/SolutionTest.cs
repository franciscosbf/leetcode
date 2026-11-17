namespace Challenge.Tests;

public class SolutionTest
{
    [Fact]
    public void ShouldPass()
    {
        var rcounter = new RecentCounter();

        Assert.Equal(1, rcounter.Ping(1));
        Assert.Equal(2, rcounter.Ping(100));
        Assert.Equal(3, rcounter.Ping(3001));
        Assert.Equal(3, rcounter.Ping(3002));
    }
}
