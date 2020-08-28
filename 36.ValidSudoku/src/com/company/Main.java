package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static int boxIndex(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer>[] row = new HashMap[9];
        HashMap<Character, Integer>[] col = new HashMap[9];
        HashMap<Character, Integer>[] box = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }

        // Scan the board once,
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    if (row[i].containsKey(board[i][j])) {
                        return false;
                    }
                    if (col[j].containsKey(board[i][j])) {
                        return false;
                    }
                    int boxIdx = boxIndex(i, j);
                    if (box[boxIdx].containsKey(board[i][j])) {
                        return false;
                    }
                    row[i].put(board[i][j], j);
                    col[j].put(board[i][j], i);
                    box[boxIdx].put(board[i][j], boxIdx);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        };

        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
