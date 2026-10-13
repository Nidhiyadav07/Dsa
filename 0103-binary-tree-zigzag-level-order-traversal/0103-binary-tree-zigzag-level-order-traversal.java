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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res=new ArrayList<>();
          if (root == null) return res;

        Deque<TreeNode> dq=new LinkedList<>();
        dq.add(root);
        boolean flag=true;
       
        while(!dq.isEmpty()){
            int size=dq.size();
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<size;i++){
              
                if(flag){
                    TreeNode rt=dq.pollFirst();
                    if(rt.left!=null){
                        dq.addLast(rt.left);
                    }if(rt.right!=null){
                        dq.addLast(rt.right);
                    }
                    ans.add(rt.val);
                }else{
                    TreeNode rt=dq.pollLast();
                    if(rt.right!=null){
                        dq.addFirst(rt.right);
                    }if(rt.left!=null){
                        dq.addFirst(rt.left);
                    }
                    ans.add(rt.val);
                }
            }
                flag=!flag;
                 res.add(ans);
            }
            return res;
        }
    }
