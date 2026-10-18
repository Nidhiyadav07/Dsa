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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       idx=postorder.length-1;
        return build(inorder,postorder,0,inorder.length-1);
    }
    public TreeNode build(int[] inorder,int[] postorder,int start,int end){
        if(start>end)return null;

        TreeNode root=new TreeNode(postorder[idx--]);

        int pos=start;
        while(inorder[pos]!=root.val)pos++;

        root.right=build(inorder,postorder,pos+1,end);
        root.left=build(inorder,postorder,start,pos-1);
        return root;
    }
}