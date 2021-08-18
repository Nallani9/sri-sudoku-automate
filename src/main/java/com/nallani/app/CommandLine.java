package com.nallani.app;

import com.nallani.players.sudoku.SudokuPlayer;
import org.sikuli.basics.Settings;

public class CommandLine {

    public static void main(String[] args) {
        Settings.InputFontMono = true;
        try {
            SudokuPlayer player = new SudokuPlayer();
            player.autoplay();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
}
