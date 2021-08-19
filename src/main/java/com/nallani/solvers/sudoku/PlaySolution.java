package com.nallani.solvers.sudoku;

import com.nallani.players.PlayException;
import com.nallani.players.sudoku.SudokuPlayer;
import com.nallani.players.sudoku.SudokuWindow;
import org.sikuli.script.Region;

import java.util.List;

import static com.nallani.solvers.sudoku.SudokuInputConverter.board;

public class PlaySolution {

    public static int[][] SOLVED_GAME = new int[9][9];

    public void playSolutions(int[][] solution, SudokuWindow window) throws PlayException, InterruptedException {

        SOLVED_GAME = solution;
        SudokuPlayer sudokuPlayer = new SudokuPlayer();
        List<List<Region>> topRegionList = sudokuPlayer.scanEmptyCellsOnScreen(window);
        List<List<Region>> bottomRegionList = sudokuPlayer.scanBottoNumbersOnScreen(window);

        //top: click first cell
        System.out.println("clicking main board");
        for (List<Region> regions : topRegionList) {
            if (regions != null) {
                window.clickAtRegion(regions.get(0));
                // get index values for numbers to click
                int indexToClick = getIndexAndRetrieveValue();
                // click bottom
                clickBottom(bottomRegionList, indexToClick, window);
                //click other place
            }
        }
        System.out.println("successfully clicked upper cells");
    }

    private int getIndexAndRetrieveValue() {
        //get index from given board game
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return getIndexValue(i, j);
                }
            }
        }
        return 999;
    }

    private void clickBottom(List<List<Region>> bottomRegionList, int bottomValueIs, SudokuWindow window) {
        int indexToClick = bottomValueIs - 1;
        List<Region> regions = bottomRegionList.get(indexToClick);
        window.clickAtRegion(regions.get(0));
    }

    private int getIndexValue(int var1, int var2) {
        //update the zero value with random number for given board
        board[var1][var2] = 99;
        return SOLVED_GAME[var1][var2];
    }
}
