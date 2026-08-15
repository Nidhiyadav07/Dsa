class Solution {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(stack.isEmpty() ||stack.peek()!=ch){
                stack.push(ch);
            }else{
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
}