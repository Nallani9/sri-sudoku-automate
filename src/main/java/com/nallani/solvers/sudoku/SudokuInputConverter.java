package com.nallani.solvers.sudoku;

import java.util.List;

public class SudokuInputConverter {

    public static int[][] board = new int[9][9];

    public int[][] converterToMatrixBoard(List<String> input) {
        int count = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String stringList = input.get(count);
                    board[i][j] = Integer.parseInt(stringList.replaceAll("\\s", ""));
                    count++;
                }
            }
            BoardChallengeSolver solver = new BoardChallengeSolver();
           return solver.solve(board);
        }
}
