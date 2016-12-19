package leetcode289;

public class Solution {
  public void gameOfLife(int[][] board) {
    if (board.length <= 0)
      return;
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int x = getLiveNum(board, i, j);
        if (board[i][j] == 0) {
          if (x == 3)
            board[i][j] += 10;
        } else {
          if (x == 2 || x == 3)
            board[i][j] += 10;
        }
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] / 10 == 1)
          board[i][j] = 1;
        else
          board[i][j] = 0;
      }
    }
  }

  public int getLiveNum(int[][] board, int x, int y) {
    int count = 0;
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || (i == x && j == y))
          continue;
        if (board[i][j] % 10 == 1)
          count++;
      }
    }
    return count;
  }
}
