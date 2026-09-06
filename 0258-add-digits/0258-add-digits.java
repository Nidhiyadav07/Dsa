class Solution {
    public int addDigits(int num) {
        while (num >= 10) { num = number(num); } return num;
        
    }
    public int number(int num){
        int sum = 0;
         while (num > 0) {
             int digit = num % 10; 
             sum += digit; 
             num = num / 10; 
        } return sum;
    }
}