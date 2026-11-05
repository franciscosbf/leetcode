namespace Challenge.Tests;

public class SolutionTest
{
    [Fact]
    public void ShouldPass()
    {
        var cache = new LRUCache(2);

        cache.Put(1, 0);
        cache.Put(2, 2);

        Assert.Equal(0, cache.Get(1));
        
        cache.Put(3, 3);

        Assert.Equal(-1, cache.Get(2));

        cache.Put(4, 4);

        Assert.Equal(-1, cache.Get(1));
        Assert.Equal(3, cache.Get(3));
        Assert.Equal(4, cache.Get(4));
    }
}
