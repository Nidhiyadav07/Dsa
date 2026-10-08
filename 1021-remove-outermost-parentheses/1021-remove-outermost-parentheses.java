class Solution {
    public String removeOuterParentheses(String s) {
        int opened=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(opened>0){
                    sb.append(ch);
                }opened++;

            }else{opened--;
                if(opened>0){
                    sb.append(ch);

                }
            }
            
        }return sb.toString();
    }
}