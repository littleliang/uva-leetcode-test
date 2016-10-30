package leetcode278;

class VersionControl {
  public boolean isBadVersion(int version) {
    return true;
  }
}


public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    if (n < 1) {
      return -1;
    }
    int start = 1;
    int end = n;
    int mid;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (isBadVersion(mid)) {
        end = mid;
      } else {
        start = mid;
      }
    }
    if (isBadVersion(start)) {
      return start;
    } else if (isBadVersion(end)) {
      return end;
    }
    return -1;
  }
}
