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
     * @param gameType
     * @throws InterruptedException if the thread is interrupted
     * @throws PlayException        if there's a problem while playing the game
     */

    public void autoplay(String[] gameType) throws InterruptedException, PlayException {
        SudokuWindow window = new SudokuWindow();
        String game = null;
        if (gameType.length != 0) {
            game = gameType[0];
        }
        boolean isIrregular = false;

        //window.undoBoard();
        window.moveMouse(1, 1);
        window.clickTimeButton();
        List<String> numbers = scanNumbersOnScreen(window);
        System.out.println("the numbers are  " + numbers);
        SudokuInputConverter converter = new SudokuInputConverter();
        if (game != null) {
            if (game.equalsIgnoreCase("irregular")) {
                isIrregular = true;
            }
            int[][] sudokuSolution = converter.converterToMatrixBoard(numbers, isIrregular);
            if (!game.equalsIgnoreCase("ice")) {
                PlaySolution playSolution = new PlaySolution();
                playSolution.playSolutions(sudokuSolution, window);
                window.moveMouse(1, 1);
            }
        } else {
            throw new PlayException("Argument cannot be null, please pass classic, irregular or ice");
        }
    }

    /**
     * Looks through all the boxes in the game and returns a list of the numbers seen.
     * The numbers may be wrong
     *
     * @param window the PyramidWindow to help read cards on the screen
     * @return a list of all the cards found on the screen
     */
    private List<String> scanNumbersOnScreen(SudokuWindow window) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            numbers.add(window.numberAt(i));
        }
        return numbers;
    }

    public List<List<Region>> scanEmptyCellsOnScreen(SudokuWindow window) {
        List<List<Region>> cells = new ArrayList<>();
        for (int i = 0; i < 81; i++) {
            cells.add(window.cellAt(i));
        }
        return cells;
    }

    public List<List<Region>> scanBottomNumbersOnScreen(SudokuWindow window) {
        List<List<Region>> cards = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cards.add(window.bottomNumAt(i));
        }
        return cards;
    }
}
