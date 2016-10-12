package leetcode60;

public class Solution {
  public String getPermutation(int n, int k) {
    int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    boolean[] flags = new boolean[n];
    StringBuilder st = new StringBuilder();
    for(int j = 0; j < n; j++){
      int level = (k - 1) / fac[n - 1 - j];
      k = k - level * fac[n - 1 - j];
      for (int i = 0; i < fac.length; i++) {
        if (flags[i] == false) {
          if (level == 0) {
            st.append(i + 1);
            flags[i] = true;
            break;
          }
          level--;
        }
      }
    }
    return st.toString();
  }
}
