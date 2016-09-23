package leetcode386;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> res = new ArrayList<>();
	
    public List<Integer> lexicalOrder(int n) {
    	for(int i = 1; i < 10; i++){
    		if(i <= n){
    			res.add(i);
    			lexicalOrder(i * 10, n, res);
    		}else{
    			break;
    		}
    	}
        return res;
    }
    
    public void lexicalOrder(int base, int n, List<Integer> res){
    	for(int i = 0; i < 10; i++){
    		if(base + i <= n){
    			res.add(base + i);
    			lexicalOrder((base + i) * 10, n, res);
    		}else{
    			return;
    		}
    	}
    }
}
