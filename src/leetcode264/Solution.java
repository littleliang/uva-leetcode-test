package leetcode264;

public class Solution {
    public int nthUglyNumber(int n) {
    	int[] res = new int[n];
    	res[0] = 1;
    	int[] index = new int[3];
    	int[] factor = {2, 3, 5};
    	for(int i = 1; i < n; i++){
    		int temp = Integer.MAX_VALUE;
    		for(int j = 0; j < 3; j++){
    			if(res[index[j]] * factor[j] < temp){
    				temp = res[index[j]] * factor[j];
    			}
    		}
    		res[i] = temp;
    		for(int j = 0; j < 3; j++){
				if(temp == res[index[j]] * factor[j]){
					index[j]++;
				}
			}
    	}
        return res[n - 1];
    }
}
