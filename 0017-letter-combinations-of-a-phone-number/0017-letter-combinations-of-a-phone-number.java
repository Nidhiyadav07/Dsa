class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new ArrayList<>();
        StringBuilder ans=new StringBuilder();
        solve(mapping,digits,ans,0,res);
        return res;
    }
    public void solve(String[] mapping,String digits,StringBuilder ans,int i,List<String> res){
        if(i==digits.length()){
            res.add(ans.toString());
            return;
        }
        char c=digits.charAt(i);
        String s=mapping[c-'0'];
        for(int j=0;j<s.length();j++){
             char ch=s.charAt(j);
            solve(mapping,digits,ans.append(ch),i+1,res);
            ans.setLength(ans.length()-1);
        }

    }
}