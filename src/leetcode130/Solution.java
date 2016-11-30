package leetcode130;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  class Node {
    int row;
    int col;

    Node(int x, int y) {
      row = x;
      col = y;
    }
  }

  public void solve(char[][] board) {
    int rowLen = board.length;
    if (rowLen <= 0)
      return;
    int colLen = board[0].length;
    if (colLen <= 0)
      return;
    int[][] visited = new int[rowLen][colLen];
    Queue<Node> queue = new LinkedList<>();
    for (int row = 0; row < rowLen; row++)
      for (int col = 0; col < colLen; col++)
        visited[row][col] = 0;
    for (int row = 0; row < rowLen; row++) {
      if (board[row][0] == 'O')
        queue.offer(new Node(row, 0));
      if (board[row][colLen - 1] == 'O')
        queue.offer(new Node(row, colLen - 1));
    }
    for (int col = 0; col < colLen; col++) {
      if (board[0][col] == 'O')
        queue.offer(new Node(0, col));
      if (board[rowLen - 1][col] == 'O')
        queue.offer(new Node(rowLen - 1, col));
    }
    while (!queue.isEmpty()) {
      Node top = queue.poll();
      int rowrow = top.row;
      int colcol = top.col;
      if (visited[rowrow][colcol] == 1)
        continue;
      visited[rowrow][colcol] = 1;
      if (rowrow + 1 < rowLen && board[rowrow + 1][colcol] == 'O'
          && visited[rowrow + 1][colcol] == 0)
        queue.offer(new Node(rowrow + 1, colcol));
      if (rowrow - 1 >= 0 && board[rowrow - 1][colcol] == 'O' && visited[rowrow - 1][colcol] == 0)
        queue.offer(new Node(rowrow - 1, colcol));
      if (colcol + 1 < colLen && board[rowrow][colcol + 1] == 'O'
          && visited[rowrow][colcol + 1] == 0)
        queue.offer(new Node(rowrow, colcol + 1));
      if (colcol - 1 >= 0 && board[rowrow][colcol - 1] == 'O' && visited[rowrow][colcol - 1] == 0)
        queue.offer(new Node(rowrow, colcol - 1));
    }
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (board[row][col] == 'O' && visited[row][col] == 0)
          board[row][col] = 'X';
      }
    }
  }
}
