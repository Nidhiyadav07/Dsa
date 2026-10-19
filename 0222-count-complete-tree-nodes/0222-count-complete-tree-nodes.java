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
    public int countNodes(TreeNode root) {
         if (root == null) return 0;
        int left=0;int right=0;
        TreeNode l=root,r=root;
        while(l!=null){
            left++;
            l=l.left;
        }
        while(r!=null){
            right++;
            r=r.right;
        }
        if(left==right){
            return (int)Math.pow(2,left)-1;
        }return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
}