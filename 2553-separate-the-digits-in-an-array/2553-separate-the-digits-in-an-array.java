class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
       for (int num : nums) {
            ArrayList<Integer> temp = new ArrayList<>();

            while (num > 0) {
                temp.add(num % 10);
                num = num / 10;
            }

            for (int i = temp.size() - 1; i >= 0; i--) {
                arr.add(temp.get(i));
            }
        }
        int[] ans=new int[arr.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}