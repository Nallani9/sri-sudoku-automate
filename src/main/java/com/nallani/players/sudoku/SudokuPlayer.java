package com.nallani.players.sudoku;

import com.nallani.players.PlayException;
import com.nallani.solvers.sudoku.PlaySolution;
import com.nallani.solvers.sudoku.SudokuInputConverter;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.List;

public class SudokuPlayer {

    public SudokuPlayer() {
        System.out.println("Starting Sudoku Board Challenge...");
    }

    /**
     * Plays the currently displayed Microsoft Sudoku Game using SikuliX to automate
     * the actions and scan the board on the screen.
     *
     * @throws InterruptedException if the thread is interrupted
     * @throws PlayException        if there's a problem while playing the game
     */

    public void autoplay() throws InterruptedException, PlayException {
        SudokuWindow window = new SudokuWindow();
        window.undoBoard();
        window.moveMouse(1, 1);
        List<String> cards = scanNumbersOnScreen(window);
        System.out.println("the cards are  " + cards);
        SudokuInputConverter converter = new SudokuInputConverter();
        int[][] sudokuSolution = converter.converterToMatrixBoard(cards);
        PlaySolution playSolution = new PlaySolution();
        playSolution.playSolutions(sudokuSolution, window);
        window.moveMouse(1, 1);
    }

    /**
     * Looks through all the boxes in the game and returns a list of the numbers seen.
     * The numbers may be wrong
     *
     * @param window the PyramidWindow to help read cards on the screen
     * @return a list of all the cards found on the screen
     */
    private List<String> scanNumbersOnScreen(SudokuWindow window) {
        List<String> cards = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            cards.add(window.numberAt(i));
        }
        return cards;
    }

    public List<List<Region>> scanEmptyCellsOnScreen(SudokuWindow window) {
        List<List<Region>> cells = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            cells.add(window.cellAt(i));
        }
        return cells;
    }

    public List<List<Region>> scanBottoNumbersOnScreen(SudokuWindow window) {
        List<List<Region>> cards = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cards.add(window.bottomCardAt(i));
        }
        return cards;
    }
}
