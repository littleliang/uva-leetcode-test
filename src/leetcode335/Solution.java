package leetcode335;

public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x.length < 4){
        	return false;
        }
        int i = 2;
        while(i < x.length && x[i] > x[i-2]) {  
            i++;  
        }  
        if(i>=x.length) {  
            return false;  
        }
        if((i==3 && x[i]==x[i-2]) || ( i>=4 && x[i] + x[i-4] >= x[i-2])) {  
            x[i-1] -= x[i-3];  
        }  
        i++;
        while(i<x.length) {  
            if(x[i]>=x[i-2]) return true;  
            i++;  
        }  
        return false;
    }
}
