package leetcode1;


public class Solution {
    public int[] twoSum(int[] nums, int target) {
 
        int[] res = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
        	int temp = nums[start] + nums[end];
        	if(temp < target){
        		start++;
        	}
        	else if(temp > target){
        		end--;
        	}
        	else{
        		res[0] = start + 1;
        		res[1] = end + 1;
        		break;
        	}
        }
		return res;
    }
}
