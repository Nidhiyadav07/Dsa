
class Solution {
    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().ch == ch) {

                stack.peek().count++;

                if (stack.peek().count == k) {
                    stack.pop();
                }

            } else {
                stack.push(new Pair(ch, 1));
            }
        }while(!stack.isEmpty()){
            Pair p=stack.pop();
            for (int j = 0; j < p.count; j++) {
                ans.append(p.ch);
            }
        }return ans.reverse().toString();
         
    }
}