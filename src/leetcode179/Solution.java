package leetcode179;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public String largestNumber(int[] arr) {
    Integer[] array = new Integer[arr.length];
    int i = 0;
    for (int value : arr) {
      array[i++] = Integer.valueOf(value);
    }
    Arrays.sort(array, new Comparator<Integer>() {
      @Override
      public int compare(Integer a1, Integer a2) {
        int l1 = a1 == 0 ? 1 : (int) Math.log10(Math.abs(a1)) + 1;
        int l2 = a2 == 0 ? 1 : (int) Math.log10(Math.abs(a2)) + 1;
        long aa1 = (long) (a1 * Math.pow(10, l2) + a2);
        long aa2 = (long) (a2 * Math.pow(10, l1) + a1);
        return aa1 > aa2 ? -1 : (aa1 == aa2 ? 0 : 1);
      }
    });
    StringBuilder sb = new StringBuilder();
    for (Integer e : array) {
      sb.append(e);
    }
    return sb.toString().replaceFirst("^0+(?!$)", "");
  }
}
