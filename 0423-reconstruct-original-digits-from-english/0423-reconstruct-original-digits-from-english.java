import java.util.*;

class Solution { 
    public String originalDigits(String s) { 
        
        HashMap<Character, Integer> used = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            used.put(ch, used.getOrDefault(ch, 0) + 1);
        }

       
        String[] words = {"zero", "two", "four", "six", "eight", "three", "five", "seven", "one", "nine"};
        char[] distinctChars = {'z', 'w', 'u', 'x', 'g', 'h', 'f', 's', 'o', 'i'};
        int[] digitValue = {0, 2, 4, 6, 8, 3, 5, 7, 1, 9};

        ArrayList<Integer> ans = new ArrayList<>(); 

       
        for (int i = 0; i < words.length; i++) {
            char idChar = distinctChars[i];
            
          
            if (used.containsKey(idChar) && used.get(idChar) > 0) {
                int count = used.get(idChar);
                int digit = digitValue[i];
                String word = words[i];

                
                for (int c = 0; c < count; c++) {
                    ans.add(digit);
                }

              
                for (int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    used.put(ch, used.get(ch) - count);
                }
            }
        }

      
        Collections.sort(ans);

       
        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            sb.append(num);
        }
        return sb.toString();
    } 
}
