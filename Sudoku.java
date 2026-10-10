//http://leetcode.com/problems/sudoku-solver/submissions/2168512581/

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, r, c, num)) {
                            board[r][c] = num;

                            if (solve(board))
                                return true;

                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSafe(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num || board[i][c] == num)
                return false;

            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;

            if (board[row][col] == num)
                return false;
        }
        return true;
    }
}
