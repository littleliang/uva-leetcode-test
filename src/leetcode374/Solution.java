package leetcode374;

class GuessGame {
  int guess(int num) {
    return 0;
  }
}


public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int i = 1, j = n;
    while (i <= j) {
      int m = i + (j - i) / 2;
      int g = guess(m);
      if (g == 0)
        return m;
      if (g == -1)
        j = m - 1;
      else
        i = m + 1;
    }
    return i;
  }
}
