package leetcode367;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;
        
        while(start <= end){
            long mid = start + (end - start) / 2;
            long t = mid * mid;
            if(t < num){
                start = (int) (mid + 1);
            }
            else if(t > num){
                end = (int) (mid - 1);
            }
            else{
                return true;
            }
        }
        return false;
    }
}
