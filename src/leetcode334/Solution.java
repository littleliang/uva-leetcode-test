package leetcode334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
    	if(nums.length <= 2){
    		return false;
    	}
        int l = nums[0];
        int m = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] <= l){
        		l = nums[i];
        	}
        	else if(nums[i] < m){
        		m = nums[i];
        	}else if(nums[i] > m){
        		return true;
        	}
        }
        return false;
    }
}
