package com.company;

        import data.Grid;

public class GridUtils1 implements GridUtil1 {

    /**
     * The method goes through every cell of the grid and puts them into a new grid, tGrid, while setting the cell value by swapping the columns with the rows.
     *
     * @author Alexander Nikolov
     * @param grid The grid to transpose.
     */
    @Override
    public void transponse(Grid grid) {

        Grid tGrid = new Grid(9);       //create a new grid
        for (int i = 1; i<10; i++){
            for (int j = 1; j<10; j++){         //put the value of the cell with coordinates i,j into the cell with coordinates j,i
                tGrid.setValue(i,j, grid.getValue(j,i));

            }
        }
        for (int i = 1; i<10; i++){     //put the transposed cells into grid
            for (int j = 1; j<10; j++){
                grid.setValue(i,j, tGrid.getValue(i,j));

            }
        }

    }

    /**
     *
     * The method takes the original grid (grid1), applies a transposition (the same way the method transponse does) and then compares the result with the second grid (grid2).
     * @author Alexander Nikolov
     * @param grid1 Original grid.
     * @param grid2 The grid to compare to.
     * @return Returns true or false.
     */
    @Override
    public boolean isTransposition(Grid grid1, Grid grid2){

        Grid tGrid = new Grid(9);
        for (int i = 1; i<10; i++){
            for (int j = 1; j<10; j++){         //put the value of the cell with coordinates i,j into the cell with coordinates j,i
                tGrid.setValue(i,j, grid1.getValue(j,i));

            }
        }



        for (int i = 1; i<10; i++){     //compare if the transposed grid1 (saved in tGrid) equals grid2
            for (int j = 1; j<10; j++){
                if (grid2.getValue(i,j)!=tGrid.getValue(i,j)) {
                    return false;
                }

            }
        }

        return true;
    }

}
