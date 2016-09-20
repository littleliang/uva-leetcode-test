package leetcode35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || target <= nums[0]){
        	return 0;
        }
        if(target > nums[nums.length - 1]){
        	return nums.length;
        }
    	int start = 0;
    	int end = nums.length;
    	while(start < end - 1){
    		int mid = start + (end - start) / 2;
    		if(nums[mid] < target){
    			start = mid;
    		}
    		else if(nums[mid] > target){
    			end = mid;
    		}
    		else{
    			return mid;
    		}
    	}
    	return end;
    }
}
