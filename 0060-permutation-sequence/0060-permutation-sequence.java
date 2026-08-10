class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= n; i++) { str.append(i); }
        List<String> ans = new ArrayList<>();
        solve(str, new StringBuilder(), ans); 
        
        return ans.get(k - 1);
    }
    public void solve(StringBuilder str, StringBuilder current, List<String> ans) { 
       
        if (str.length() == 0) { ans.add(current.toString()); return; } 
            for (int j = 0; j < str.length(); j++) { 
                char ch = str.charAt(j); 
                current.append(ch); 
                str.deleteCharAt(j); 
                    solve(str, current, ans); 
                    str.insert(j, ch); 
                    current.deleteCharAt(current.length() - 1);
            } 
        }
     }