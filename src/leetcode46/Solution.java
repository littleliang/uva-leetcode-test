package leetcode46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> temp = new ArrayList<>();
	
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        permute(nums, temp, visited);
    	return res;
    }
    
    public void permute(int[] nums, List<Integer> temp, boolean[] visited){
    	if(temp.size() == nums.length){
    		res.add(new ArrayList<>(temp));
    		return;
    	}
    	
    	for(int i = 0; i < nums.length; i++){
    		if(visited[i]){
    			continue;
    		}
    		visited[i] = true;
    		temp.add(nums[i]);
    		permute(nums, temp, visited);
    		visited[i] = false;
    		temp.remove(temp.size() - 1);
    	}
    	
    }
}