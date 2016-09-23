package leetcode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0){
        	return false;
        }
        int m = matrix[0].length;
        int i;
        for(i = 0; i < n; i++){
        	if(matrix[i][m - 1] >= target){
        		break;
        	}
        }
        if(i == n){
        	return false;
        }

        int start = 0;
        int end = m - 1;
        while(start <= end){
        	int mid = start + (end - start) / 2;
        	if(matrix[i][mid] < target){
        		start = mid + 1;
        	}else if(matrix[i][mid] > target){
        		end = mid - 1;
        	}else{
        		return true;
        	}
        }
        return false;
    }
}
