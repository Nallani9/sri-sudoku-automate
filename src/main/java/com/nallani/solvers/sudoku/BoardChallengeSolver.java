package com.nallani.solvers.sudoku;

import java.util.Arrays;

public class BoardChallengeSolver implements SudokuSolver {
    @Override
    public int[][] solve(int[][] gridToSolve, boolean isIrregular) {

        SudokuImpl sudokuImpl = new SudokuImpl(gridToSolve);

        if (sudokuImpl.solve(isIrregular)) {
            System.out.println("Sudoku Grid solved with simple BT");
            sudokuImpl.display();
            System.out.println("Solved board is: " + Arrays.deepToString(sudokuImpl.returnSolvedBoard()));
            return sudokuImpl.returnSolvedBoard();
        } else {
            System.out.println("Unsolvable board");
            System.exit(2);
        }
        return null;
    }
}
