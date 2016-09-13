package leetcode198;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        if(nums.length == 1){
        	return nums[0];
        }
        if(nums.length == 2){
        	return Math.max(nums[0], nums[1]);
        }
        int[] robSum = new int[nums.length];
        robSum[0] = nums[0];
        robSum[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
        	robSum[i] = Math.max(robSum[i - 1], robSum[i - 2] + nums[i]);
        }
        return robSum[robSum.length - 1];
    }
}
