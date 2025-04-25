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
    public List<TreeNode> solve(int s,int e){
         List<TreeNode> result = new ArrayList<>();
         if(s>e){
            result.add(null);
            return result;
         }
         if(s==e){
            TreeNode root =new TreeNode(s);
            result.add(root);
            return result;
         }
         for(int i=s;i<=e;i++){
            List<TreeNode> leftList = solve(s, i - 1);
            List<TreeNode> rightList = solve(i + 1, e);
            
            for (TreeNode leftRoot : leftList) {
                for (TreeNode rightRoot : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    result.add(root);
                }
            }
         
         }
         return result;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
       return solve(1,n);
        
    }
}