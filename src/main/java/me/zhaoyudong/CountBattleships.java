package me.zhaoyudong;

public class CountBattleships {

    /**
     * https://leetcode-cn.com/problems/battleships-in-a-board/
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            char[] rowArr = board[row];
            for (int col = 0; col < rowArr.length; col++) {
                char item = board[row][col];
                if (item == '.') {
                    continue;
                }

                if (col + 1 < rowArr.length && rowArr[col + 1] == 'X') {
                    board[row][col] = '.';
                } else if (row + 1 < board.length && board[row + 1][col] == 'X') {
                    board[row][col] = '.';
                } else {
                    count++;
                }
            }
        }

        return count;

    }
}
