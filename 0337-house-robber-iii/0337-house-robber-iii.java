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
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        rob(root.left);
        rob(root.right);
        int rtn=root.val;
        int drtn=0;
        if(root.left!=null){
            drtn+=root.left.val;
            if(root.left.left!=null){
                rtn+=root.left.left.val;
            }
            if(root.left.right!=null){
                rtn+=root.left.right.val;
            }
        }
        if(root.right!=null){
            drtn+=root.right.val;
            if(root.right.left!=null){
                rtn+=root.right.left.val;
            }
            if(root.right.right!=null){
                rtn+=root.right.right.val;
            }
        }
        root.val=Math.max(rtn,drtn);
        return root.val;
    }
}