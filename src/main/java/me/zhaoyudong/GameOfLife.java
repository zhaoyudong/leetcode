package me.zhaoyudong;

public class GameOfLife {

    private static final int dead2Alive = 3;
    private static final int alive2Dead = 4;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                int sum = sumAround(board, r, c);
                if (board[r][c] == 1) {
                    if (sum < 2 || sum > 3) {
                        board[r][c] = alive2Dead;
                    }
                } else {
                    if (sum == 3) {
                        board[r][c] = dead2Alive;
                    }
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == dead2Alive) {
                    board[r][c] = 1;
                } else if (board[r][c] == alive2Dead) {
                    board[r][c] = 0;
                }
            }
        }
    }

    private int sumAround(int[][] board, int r, int c) {
        int sum = 0;
        if (r > 0) {
            sum += originVal(board[r - 1][c]);
            sum += rowNeighbour(board, r - 1, c);
        }

        sum += rowNeighbour(board, r, c);

        if (r + 1 < board.length) {
            sum += originVal(board[r + 1][c]);
            sum += rowNeighbour(board, r + 1, c);
        }

        return sum;
    }

    private int rowNeighbour(int[][] board, int r, int c) {
        int sum = 0;
        if (c > 0) {
            sum += originVal(board[r][c - 1]);
        }

        if (c + 1 < board[r].length) {
            sum += originVal(board[r][c + 1]);
        }

        return sum;
    }

    private int originVal(int val) {
        if (val == dead2Alive) {
            return 0;
        } else if (val == alive2Dead) {
            return 1;
        }

        return val;
    }
}
