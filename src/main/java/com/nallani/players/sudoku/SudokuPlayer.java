package com.nallani.players.sudoku;

import com.nallani.exceptions.PlayException;
import com.nallani.solvers.sudoku.PlaySolution;
import com.nallani.solvers.sudoku.SudokuInputConverter;
import org.sikuli.script.Image;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

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
        window.moveMouse(1, 1);
        String game = null;
        if (gameType.length != 0) {
            game = gameType[0];
        }
        boolean isIrregular = false;
        /*Image playHint = window.loadImage("common/" + "Hint.png");
        if (window.appRegion().exists(playHint, 2.0d) == null) {
            throw new PlayException("Can't detect hint button button.");
        }*/
        window.clickHint();
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
                Thread.sleep(15000);
                Image playAgainImage = window.loadImage("common/" + "PlayAgain.png");
                if (window.appRegion().exists(playAgainImage, 2.0d) == null) {
                    List<String> scanSecondTime = scanNumbersOnScreen(window);
                    SudokuInputConverter secondConverter = new SudokuInputConverter();
                    secondConverter.converterToMatrixBoard(scanSecondTime,false);
                    playSolution.playSolutions(sudokuSolution, window);
                    //throw new PlayException("Can't detect play again button.");
                }
                Thread.sleep(15000);
                if (window.appRegion().exists(playAgainImage, 2.0d) == null) {
                    for (int u = 0; u < 70; u++) {
                        window.clickAtRegion(Region.create(881, 713, 133, 63));
                    }
                }
                window.clickTimeButton();
                window.clickPlayAgain();
            }
            window.moveMouse(1, 1);
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
