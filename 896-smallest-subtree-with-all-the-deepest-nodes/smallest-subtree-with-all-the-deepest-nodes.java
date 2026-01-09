/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDepth;
    private TreeNode answer;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDepth = getDepth(root);
        dfs(root, 1);
        return answer;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) return 0;

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);

        if (depth + Math.max(left, right) == maxDepth &&
            depth + left == maxDepth &&
            depth + right == maxDepth) {
            answer = node;
        }

        return Math.max(left, right) + 1;
    }
}
