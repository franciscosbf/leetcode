namespace Challenge;

public class TreeNode(int val = 0, TreeNode? left = null, TreeNode? right = null)
{
    public int val = val;
    public TreeNode? left = left, right = right;
}

public class Solution {
    #pragma warning disable CA1822
    public IList<IList<int>> ZigzagLevelOrder(TreeNode? root) {
        if (root is null) return [];

        IList<IList<int>> zigzag = [];
        var queue = new Queue<(TreeNode, int)>();

        bool right = true;
        int currDepth = 1;
        queue.Enqueue((root, 1));
        while (queue.Count > 0)
        {
            var (node, depth) = queue.Dequeue();
            if (depth != currDepth) right = !right;
            if (zigzag.Count > 0)
            {
                if (depth == currDepth)
                {
                    IList<int> vals = zigzag[zigzag.Count - 1];
                    if (right) vals.Add(node.val);
                    else vals.Insert(0, node.val);
                }
                else zigzag.Add([node.val]);
            }
            else zigzag.Add([node.val]);
            currDepth = depth;
            if (node.left is not null) queue.Enqueue((node.left, depth + 1));
            if (node.right is not null) queue.Enqueue((node.right, depth + 1));
        }

        return zigzag;
    }
}
