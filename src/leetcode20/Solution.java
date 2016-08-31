package leetcode20;

import java.util.ArrayDeque;

public class Solution {
    public boolean isValid(String s) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
        	String temp = s.substring(i, i + 1);
        	if(temp.equals("]")){
        		if(queue.isEmpty())
        			return false;
        		if(!queue.pollLast().equals("[")){
        			return false;
        		}
        	}
        	else if(temp.equals(")")){
        		if(queue.isEmpty())
        			return false;
        		if(!queue.pollLast().equals("(")){
        			return false;
        		}
        	}
        	else if(temp.equals("}")){
        		if(queue.isEmpty())
        			return false;
        		if(!queue.pollLast().equals("{")){
        			return false;
        		}
        	}
        	else if(temp.equals("(") || temp.equals("[") || temp.equals("{")){
        		queue.addLast(temp);
        	}
        	else{
        		return false;
        	}
        		
        }
        if(queue.isEmpty())
        	return true;
        return false;
    }
}
