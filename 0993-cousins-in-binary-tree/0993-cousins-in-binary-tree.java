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
    TreeNode parent;
    TreeNode child;
    public Pair(TreeNode child,TreeNode parent){
        this.child=child;
        this.parent=parent;
        
    }
}
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        Deque<Pair> dq=new LinkedList<>();
        dq.addLast(new Pair(root,null));
        while(!dq.isEmpty()){
           int size=dq.size();
           TreeNode px = null, py = null;

           for(int i=0;i<size;i++){
                Pair p=dq.pollFirst();
                TreeNode rt=p.child;

                if (rt.val == x) px = p.parent;
                if (rt.val == y) py = p.parent;

                if(rt.left!=null){
                    dq.addLast(new Pair(rt.left,rt));
                    
                }if(rt.right!=null){
                    dq.addLast(new Pair(rt.right,rt));
                }
            }
                if (px != null || py != null)
                return px != null && py != null && px != py;
            
        }return false;

    }
    
}