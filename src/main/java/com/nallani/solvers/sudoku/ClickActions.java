package com.nallani.solvers.sudoku;

import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.List;

public class ClickActions {

    public List<Region> getRegionForEmptyCell(Region region) {
        List<Region> lr = new ArrayList<>();
        lr.add(region);
        return lr;
    }

}
