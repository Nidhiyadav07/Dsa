/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> dq=new LinkedList<>();
        if(root==null)return root;
        dq.add(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){
                Node rt=dq.pollFirst();
                if(i<size-1){
                    rt.next=dq.peekFirst();
                }
                if(rt.left!=null){
                    dq.addLast(rt.left);
                }
                if(rt.right!=null){
                    dq.addLast(rt.right);
                }

            }
        }return root;
        
    }
}