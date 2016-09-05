package leetcode190;

public class Solution {
    public int reverseBits(int n) {
        int result = 0;  
        for(int i=0; i < 32; i++){  
            int tmp = n & 0x01;  
            n = n >> 1;  
            result = (result << 1) | tmp;  
        }  
        return result;
    }
}
