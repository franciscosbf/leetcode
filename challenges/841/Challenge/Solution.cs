namespace Challenge;

public class Solution {
    public bool CanVisitAllRooms(IList<IList<int>> rooms) {
        var keys = new Stack<int>();
        var visited = new HashSet<int>();

        keys.Push(0);
        while (keys.Count > 0)
        {
            var key = keys.Pop();
            if (!visited.Add(key))
            {
                continue;
            }
            foreach (var rkey in rooms[key])
            {
                keys.Push(rkey);
            }
        }

        return rooms.Count == visited.Count;
    }
}
