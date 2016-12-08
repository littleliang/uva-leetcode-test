package leetcode165;

public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] versionArray1 = version1.split("\\.");
    String[] versionArray2 = version2.split("\\.");
    int i;
    for (i = 0; i < versionArray1.length; i++) {
      if (i >= versionArray2.length) {
        if (Long.parseLong(versionArray1[i]) > 0) {
          return 1;
        }
        continue;
      }
      long res = Long.parseLong(versionArray1[i]) - Long.parseLong(versionArray2[i]);
      if (res < 0) {
        return -1;
      } else if (res > 0) {
        return 1;
      }
    }
    for (; i < versionArray2.length; i++) {
      if (Long.parseLong(versionArray2[i]) > 0) {
        return -1;
      }
    }
    return 0;
  }
}
