package trees;

/**
 * https://www.interviewbit.com/problems/bst-iterator/
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BstIterator {
    private final Deque<TreeNode> stack = new ArrayDeque<>();
    
    public Solution(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            TreeNode cur = top.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }    
        }
        
        return top.val;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
