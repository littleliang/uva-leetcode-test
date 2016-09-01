package leetcode201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
    	if(m == 0){
    		return 0;
    	}
        int[] range = new int[32];
        int mrange = 0;
        int nrange = 0;
        int res = 0;
        range[0] = 1;
        for(int i = 1; i < 32; i++){
        	range[i] = range[i - 1] << 1;
        	if(n >= range[i - 1]){
        		nrange = i - 1;
        	}
        	if(m >= range[i - 1]){
        		mrange = i - 1;
        	}
        }
    	if(nrange != mrange){
    		return 0;
    	}
    	
    	while(mrange == nrange){
    		res += range[mrange];
    		m -= range[mrange];
    		n -= range[nrange];
    		if(m == 0){
        		break;
        	}
    		mrange = 0;
    		nrange = 0;
    		for(int i = 0; i < 31; i++){
            	if(n >= range[i]){
            		nrange = i;
            	}
            	if(m >= range[i]){
            		mrange = i;
            	}
            }
    	}
    	return res;
        
    }
}
