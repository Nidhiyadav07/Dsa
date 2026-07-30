class Solution {
    public int minimumPushes(String word) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int result=0;
        int assign_Key=2;
        for(char ch:word.toCharArray()){
            if(assign_Key>9){
                assign_Key=2;
            }
            map.put(assign_Key, map.getOrDefault(assign_Key, 0) + 1);
            result += map.get(assign_Key);


            assign_Key++;
        }

        return result;
    }
}