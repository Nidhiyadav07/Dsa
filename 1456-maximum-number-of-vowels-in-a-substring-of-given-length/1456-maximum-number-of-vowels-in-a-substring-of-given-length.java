class Solution {
    public int maxVowels(String s, int k) {
       int max=0;
       int count=0;
        for(int j=0;j<k;j++){
                char ch=s.charAt(j);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    count++;
                }
        }
        max=count;
        int j=0;
        int i=k;
        while(i<s.length()){
            char ch2=s.charAt(i);
            char ch=s.charAt(j);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    count--;
            }
            if(ch2=='a'|| ch2=='e'||ch2=='i'||ch2=='o'||ch2=='u'){
                count++;
            }i++;j++;
            max=Math.max(count,max);
        }return max;
    }
}