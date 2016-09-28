package leetcode376;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length < 2){
        	return length;
        }
        int[] flag = new int[length];
        int res = 1;
        int[] count = new int[length];
        flag[0] = 0;
        count[0] = 1;
        for(int i = 1; i < length; i++){
        	count[i] = 1;
        	flag[i] = 0;
        	for(int j = 0; j < i; j++){
        		if(flag[j] == 0){
        			if(flag[i] == 0){
        				if(nums[i] > nums[j]){
        					flag[i] = 1;
        					count[i] = 2;
        				}
        				if(nums[j] > nums[i]){
        					flag[i] = 2;
        					count[i] = 2;
        				}
        			}	
        		}else if(flag[j] == 1){
        			if(nums[i] < nums[j] && count[j] + 1 > count[i]){
        				count[i] = count[j] + 1;
        				flag[i] = 2;
        			}
        		}else{
        			if(nums[i] > nums[j] && count[j] + 1 > count[i]){
        				count[i] = count[j] + 1;
        				flag[i] = 1;
        			}
        		}
        	}
        	if(count[i] > res){
        		res = count[i];
        	}
        }
        return res;
    }
}
