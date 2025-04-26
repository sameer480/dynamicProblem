class Solution {
    int maxtree = Integer.MIN_VALUE;

    int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, solve(root.left));  // Consider only positive left subtree sum
        int rightSum = Math.max(0, solve(root.right)); // Consider only positive right subtree sum

        // Calculate the maximum path sum passing through the current root
        int currentMax = root.val + leftSum + rightSum;

        // Update the overall maximum path sum if the current path is greater
        maxtree = Math.max(maxtree, currentMax);

        // Return the maximum path sum that can be extended upwards (including the current node)
        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxtree;
    }
}