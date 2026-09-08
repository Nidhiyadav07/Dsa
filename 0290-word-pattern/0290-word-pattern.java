class Solution {
    public boolean wordPattern(String pattern, String s) {
         String[] st = s.trim().split("\\s+"); 
         HashMap<Character,String> map=new HashMap<>();
         HashSet<String> used = new HashSet<>();
         if(st.length!=pattern.length())return false;
         for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=st[i];
            if (!map.containsKey(ch)) {
            if (used.contains(word)) { return false; }

                map.put(ch,word);
                used.add(word);
            }else{
                if (!map.get(ch).equals(word)){
                    return false;
                }
            }
         }return true;
    }
}