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
 class Pair{
    TreeNode rt;
    int ind;
    public Pair(TreeNode rt,int ind){
        this.rt=rt;
        this.ind=ind;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> dq=new LinkedList<>();
        dq.add(new Pair(root,0));
        int max=Integer.MIN_VALUE;
        while(!dq.isEmpty()){
            int size=dq.size();
            int first=0,last=0;
            for(int j=0;j<size;j++){
                Pair p=dq.pollFirst();
                TreeNode rt=p.rt;
                int i=p.ind;
                if(j==0)first=i;
                if(j==size-1)last=i;
                if(rt.left!=null)dq.addLast(new Pair(rt.left,i*2+1));
                if(rt.right!=null)dq.addLast(new Pair(rt.right,i*2+2));
                
            }max=Math.max(max,last-first+1);
            
        }return max;
    }
}