namespace Challenge;

public class RecentCounter
{
    private readonly Queue<int> times;

    public RecentCounter()
    {
        times = new Queue<int>();
    }

    public int Ping(int t)
    {
        times.Enqueue(t);

        while (times.Count > 0 && (t - 3000) > times.Peek())
        {
            times.Dequeue();
        }

        return times.Count;
    }
}
