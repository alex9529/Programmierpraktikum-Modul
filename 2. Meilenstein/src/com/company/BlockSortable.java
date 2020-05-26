package com.company;

import data.Grid;

public interface BlockSortable {
    Grid getBlockConflictFree(Grid grid);
    boolean hasBlockConflictFree(Grid grid);
    Grid getBlockSortColRow(Grid grid);
    boolean hasBlockSortColRow(Grid grid);
    Grid getBlockSudoku(Grid grid);
    boolean hasBlockSudoku(Grid grid);
    int putNumberColRow(Grid grid, int number);

}
