package com.nallani.app;

import com.nallani.players.sudoku.SudokuPlayer;

public class CommandLine {

    public static void main(String[] args) {
        boolean run = true;
        while (run) {

            try {
                SudokuPlayer player = new SudokuPlayer();
                player.autoplay(args);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.exit(1);
            }

        }

    }
}
