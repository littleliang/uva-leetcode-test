package leetcode363;

import java.util.TreeSet;

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        if (n <= m) {
            for(int left = 0; left < n; left++) {
                int[] rsums = new int[m];
                for(int right = left; right < n; right++) {
                    TreeSet<Integer> ts = new TreeSet<>();
                    int rsum = 0;
                    for(int row = 0; row < m; row++) {
                        rsum += matrix[row][right];
                        rsums[row] += rsum;
                        if (rsums[row] == k) return k;
                        if (rsums[row] < k) max = Math.max(max, rsums[row]);
                        Integer ceiling = ts.ceiling(rsums[row] - k);
                        if (ceiling != null) {
                            max = Math.max(max, rsums[row] - ceiling);
                            if (max == k) return k;
                        }
                        ts.add(rsums[row]);
                    }
                }
            }
        } else {
            for(int top = 0; top < m; top++) {
                int[] csums = new int[n];
                for(int bottom = top; bottom < m; bottom++) {
                    TreeSet<Integer> ts = new TreeSet<>();
                    int csum = 0;
                    for(int col = 0; col < n; col++) {
                        csum += matrix[bottom][col];
                        csums[col] += csum;
                        if (csums[col] == k) return k;
                        if (csums[col] < k) max = Math.max(max, csums[col]);
                        Integer ceiling = ts.ceiling(csums[col] - k);
                        if (ceiling != null) {
                            max = Math.max(max, csums[col] - ceiling);
                            if (max == k) return k;
                        }
                        ts.add(csums[col]);
                    }
                }
            }
        }
        return max;
    }
}
