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
    int idx=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder,postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] preorder,int[] postorder,int start,int end){
        if(idx>=preorder.length||start>end)return null;

        TreeNode root = new TreeNode(preorder[idx++]);
        if(start==end)return root;
        
        int pos=start;
        while(postorder[pos]!=preorder[idx])pos++;

        root.left=build(preorder,postorder,start,pos);
        root.right=build(preorder,postorder,pos+1,end-1);

        return root;
    }
}