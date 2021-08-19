package com.nallani.players.sudoku;

import com.nallani.players.MSCWindow;
import com.nallani.players.PlayException;
import org.sikuli.script.Region;

import java.util.List;

public class SudokuWindow extends MSCWindow {

    SudokuWindow() throws InterruptedException, PlayException {
        super("sudoku");
    }

    /**
     * Returns the number at the given index The code
     * might guess the wrong number or return "0" for unknown card.
     *
     * @param boardIndex a card deck index from 0 to 81
     * @return the card at the given index or "0" if unknown
     */
    String numberAt(int boardIndex) {
        return numAt(regionsModel.getTableau()[boardIndex]);
    }

    List<Region> cellAt(int deckIndex) {
        return cellAt(regionsModel.getTableau()[deckIndex]);
    }

    public void clickAtRegion(Region region) {

        try {
            clickRegion(region);
        } catch (InterruptedException | PlayException e) {
            e.printStackTrace();
            System.exit(3);
        }
    }

    List<Region> bottomNumAt(int boardIndex) {
        return cellAt(regionStock.getStock()[boardIndex]);
    }
}
