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
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: compute total sum
        totalSum = getTotalSum(root);

        // Step 2: compute subtree sums and max product
        computeSubtree(root);

        return (int)(maxProduct % MOD);
    }

    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    private long computeSubtree(TreeNode node) {
        if (node == null) return 0;

        long left = computeSubtree(node.left);
        long right = computeSubtree(node.right);

        long subtreeSum = node.val + left + right;

        // consider cutting above this subtree
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
