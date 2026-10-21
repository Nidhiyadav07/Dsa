/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       
        if(root==null)return "";
        StringBuilder ans=new StringBuilder();
        Deque<TreeNode> dq=new LinkedList<>();
        dq.add(root);
        while(!dq.isEmpty()){
            TreeNode rt=dq.pollFirst();
            if(rt==null){
                ans.append("null,");
                continue;
            }
            ans.append(rt.val).append(",");
           dq.addLast(rt.left);
           dq.addLast(rt.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.isEmpty())return null;

        String[] str=data.split(",");
        if(str[0].equals("null"))return null;

        TreeNode root=new  TreeNode(Integer.parseInt(str[0]));
        Deque<TreeNode> dq=new LinkedList<>();
        dq.add(root);

        int i=1;
        while(!dq.isEmpty()){
            TreeNode rt=dq.pollFirst();
            if(!str[i].equals("null")) {
                rt.left = new TreeNode(Integer.parseInt(str[i]));
                dq.addLast(rt.left);
            }
            i++;

            // Build right child
            if(i < str.length && !str[i].equals("null")) {
                rt.right = new TreeNode(Integer.parseInt(str[i]));
                dq.addLast(rt.right);
            }
            i++;
        }return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));