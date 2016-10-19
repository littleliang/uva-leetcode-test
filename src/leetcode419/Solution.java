package leetcode419;

public class Solution {
  public int countBattleships(char[][] board) {
    if (board.length == 0)
      return 0;
    int sum = 0;
    int rows = board.length;
    int cols = board[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (board[r][c] != 'X')
          continue;
        if (r == rows - 1 || board[r + 1][c] != 'X') {
          sum++;
          if (r < rows - 1 || !(rows > 1 && board[r - 1][c] == 'X')) {
            while (c < cols && board[r][c] == 'X') {
              c++;
            }
          }
        }
      }
    }
    return sum;
  }
}
