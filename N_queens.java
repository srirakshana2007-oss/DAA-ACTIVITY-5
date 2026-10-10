//https://leetcode.com/problems/n-queens/submissions/2168510069/

import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        solve(0, board, result, n);
        return result;
    }

    void solve(int row, char[][] board,
               List<List<String>> result, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] r : board)
                list.add(new String(r));
            result.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(row + 1, board, result, n);
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(int row, int col, char[][] board, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;

            int left = col - (row - i);
            int right = col + (row - i);

            if (left >= 0 && board[i][left] == 'Q')
                return false;

            if (right < n && board[i][right] == 'Q')
                return false;
        }
        return true;
    }
}
