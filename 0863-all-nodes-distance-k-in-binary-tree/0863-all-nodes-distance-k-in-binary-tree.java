/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parent(TreeNode root,Map<TreeNode,TreeNode> parent){
        Deque<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.pollFirst();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                q.addLast(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                q.addLast(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new LinkedList<>();
        if(root==null)return res;

        Map<TreeNode,TreeNode> parent=new HashMap<>();
        Map<TreeNode,Boolean> vis=new HashMap<>();

        parent(root,parent);

        Deque<TreeNode> dq=new LinkedList<>();
        dq.add(target);
        vis.put(target,true);
        int curr=0;
        
        while(!dq.isEmpty()){
            int size=dq.size();
            if(curr==k){
                break;
            }curr++;
            for(int i=0;i<size;i++){
                TreeNode rt=dq.pollFirst();
                
                if(rt.left!=null&&!vis.containsKey(rt.left)){
                    dq.addLast(rt.left);
                    vis.put(rt.left,true);
                }
                if(rt.right!=null&& !vis.containsKey(rt.right)){
                    dq.addLast(rt.right);
                    vis.put(rt.right,true);

                }
                if(parent.containsKey(rt)&& !vis.containsKey(parent.get(rt))){
                    dq.addLast(parent.get(rt));
                    vis.put(parent.get(rt),true);
                }
            }
        }
       while(!dq.isEmpty()){
        res.add(dq.pollFirst().val);
       }
       return res;

    }
}