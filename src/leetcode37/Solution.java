package leetcode37;

public class Solution {
  private boolean[][] horizontal = new boolean[9][9];
  private boolean[][] vertical = new boolean[9][9];
  private boolean[][] square = new boolean[9][9];

  public void solveSudoku(char[][] board) {
    isValid(board);
    dfs(board, 0, 0);
  }

  private boolean dfs(char[][] board, int i, int j) {
    if (i > 8) {
      return true;
    }
    if (j > 8) {
      return dfs(board, i + 1, 0);
    }
    if (board[i][j] == '.') {
      boolean[] current = new boolean[9];
      int idx = i / 3 * 3 + j / 3;
      for (int k = 0; k < 9; k++) {
        current[k] = horizontal[i][k] || vertical[j][k] || square[idx][k];
        if (!current[k]) {
          horizontal[i][k] = vertical[j][k] = square[idx][k] = true;
          board[i][j] = (char) ('1' + k);
          if (dfs(board, i, j + 1)) {
            return true;
          }
          board[i][j] = '.';
          horizontal[i][k] = vertical[j][k] = square[idx][k] = false;
        }
      }
      return false;
    } else {
      return dfs(board, i, j + 1);
    }
  }

  private boolean isValid(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        int num = board[i][j] - '1';
        int idx = i / 3 * 3 + j / 3;
        if (horizontal[i][num] || vertical[j][num] || square[idx][num]) {
          return false;
        }
        horizontal[i][num] = true;
        vertical[j][num] = true;
        square[idx][num] = true;
      }
    }
    return true;
  }
}
