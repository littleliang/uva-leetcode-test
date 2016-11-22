package leetcode67;

public class Solution {
  public String addBinary(String a, String b) {
    if (a.equals(""))
      return b;
    if (b.equals(""))
      return a;
    int al = a.length() - 1;
    int bl = b.length() - 1;
    int t = Math.max(al, bl) + 1;
    char[] arr = new char[t + 1];
    int c = 0;
    for (; al >= 0 && bl >= 0; al--, bl--, t--) {
      int s = a.charAt(al) + b.charAt(bl) + c - '0' - '0';
      if (s == 2) {
        c = 1;
        s = 0;
      } else if (s == 3) {
        c = 1;
        s = 1;
      } else {
        c = 0;
      }
      arr[t] = (char) (s + '0');
    }
    while (al >= 0) {
      if (a.charAt(al) - '0' + c > 1) {
        arr[t] = 0 + '0';
        c = 1;
      } else {
        arr[t] = (char) (a.charAt(al) + c);
        c = 0;
      }
      t--;
      al--;
    }
    while (bl >= 0) {
      if (b.charAt(bl) - '0' + c > 1) {
        arr[t] = 0 + '0';
        c = 1;
      } else {
        arr[t] = (char) (b.charAt(bl) + c);
        c = 0;
      }
      t--;
      bl--;
    }
    if (c == 1)
      arr[0] = 1 + '0';
    return new String(arr).trim();
  }
}
