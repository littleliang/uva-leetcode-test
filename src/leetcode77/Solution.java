package leetcode77;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private void solve(List<List<Integer>> res,List<Integer> tmpList,int n,int k,int index){
       if(tmpList.size()==k){
           res.add(new LinkedList<>(tmpList));
           return;
       }
       int size = tmpList.size();
       for(int i = index;i<=n-k+size+1;i++){
           tmpList.add(i);
           solve(res,tmpList,n,k,i+1);
           tmpList.remove(size);
       }
   }
   public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> res = new LinkedList<>();
       List<Integer> tmpList = new LinkedList<>();
       solve(res,tmpList,n,k,1);
       return res;
   }
}
