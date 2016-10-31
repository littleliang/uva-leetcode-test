package leetcode174;

public class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int M = dungeon.length;
    int N = dungeon[0].length;
    int[] hp = new int[N];

    hp[N - 1] = (dungeon[M - 1][N - 1] <= 0) ? 1 - dungeon[M - 1][N - 1] : 1;
    for (int j = N - 2; j >= 0; --j) {
      hp[j] = (hp[j + 1] - dungeon[M - 1][j] <= 0) ? 1 : hp[j + 1] - dungeon[M - 1][j];
    }

    for (int i = M - 2; i >= 0; --i) {
      hp[N - 1] = (hp[N - 1] - dungeon[i][N - 1] <= 0) ? 1 : hp[N - 1] - dungeon[i][N - 1];
      for (int j = N - 2; j >= 0; --j) {
        int hpfromr = (hp[j + 1] - dungeon[i][j] <= 0) ? 1 : hp[j + 1] - dungeon[i][j];
        int hpfromd = (hp[j] - dungeon[i][j] <= 0) ? 1 : hp[j] - dungeon[i][j];
        hp[j] = (hpfromr > hpfromd) ? hpfromd : hpfromr;
      }
    }

    return hp[0];
  }
}
