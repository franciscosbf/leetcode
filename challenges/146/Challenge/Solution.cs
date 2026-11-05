using System.Diagnostics.CodeAnalysis;

namespace Challenge;

public class LRUCache(int capacity)
{
    private readonly int capacity = capacity;
    private readonly LinkedList<(int, int)> priorities = new();
    private readonly Dictionary<int, LinkedListNode<(int, int)>> entries = [];

    private bool FindNode(int key, [NotNullWhen(true)] out LinkedListNode<(int, int)>? node)
    {
        return entries.TryGetValue(key, out node);
    }

    private void PrioritizeNode(int key, LinkedListNode<(int, int)> node)
    {
        priorities.Remove(node);
        priorities.AddFirst(node.Value);
        entries[key] = priorities.First!;
    }
    
    public int Get(int key)
    {
        if (!FindNode(key, out var node)) return -1;

        PrioritizeNode(key, node);

        return node.Value.Item2;
    }
    
    public void Put(int key, int value)
    {
        if (FindNode(key, out var node))
        {
            node.Value = (key, value);
            PrioritizeNode(key, node);
        }
        else
        {
            if (priorities.Count == capacity)
            {
                var last = priorities.Last!;
                entries.Remove(last.Value.Item1);
                priorities.Remove(last);
            }
            
            node = new LinkedListNode<(int, int)>((key, value));
            entries.Add(key, node);
            priorities.AddFirst(node);
        }
    }
}
