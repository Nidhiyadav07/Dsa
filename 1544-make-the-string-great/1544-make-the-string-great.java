class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
      
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
                if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32){
                    stack.pop();
                }
            else{
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }return ans.reverse().toString();
    }
}