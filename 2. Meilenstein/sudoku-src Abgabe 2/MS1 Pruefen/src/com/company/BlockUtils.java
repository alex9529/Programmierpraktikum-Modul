package com.company;

import data.Cell;
import data.Grid;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Alexander Nikolov
 */


public class BlockUtils  implements BlockSolvingUtil, BlockIsoUtil {

    List<Integer> numberToPutIntoSingle = new ArrayList<Integer>();
    List<Integer> numbersToPutIntoPair = new ArrayList<Integer>();
    List<Grid> grids = new ArrayList<Grid>();

    List<Integer>[][] globalCandidateList = new ArrayList[9][9];

    /**
     * Note: as of now not in use.
     * The method goes through a candidate list and removes a specific number, in case it exists. It will be used by the solver when it finds a hidden or a naked pair.
     * @author Alexander Nikolov
     *
     * @param list The list to search through.
     * @param number The number to delete.
     */
    public void removeNumberFromCandidateList (List<Integer> list, int number){
        for (int k = 0 ; k<list.size(); k++){
            if (list.get(k)==number){
                list.remove(k);
            }
        }
    }


    /**
     * The method applies a block permutation on the grid using a cell array, called image..
     * First, a new grid (newGrid) is created which will make the assigning of the values easier.
     *
     * Next, check whether there is a horizontal or a vertical permutation to be applied. Do this by checking the column index of
     * the first two elements of the image (which stand for the coordinates of the blocks which get assigned to the the blocks with anchor cells 1,1 and 1,4).
     * If neither of them has changed, we must be dealing with a vertical permutation.
     *
     * If there is a horizontal permutation, apply the image by checking the first three anchor cells in the image and copy all the values row-wise (top to bottom) into the
     * new grid while taking the permutation into consideration. Analogously for the vertical permutation.
     *
     * @author
     * Alexander Nikolov
     * @param grid The grid  to apply the permutation on.
     * This is the grid to apply the Block Permutation on.
     * @param image The image to use.
     * Use this image to apply the Block permutation.
     *
     */

    public void applyBlockPermutation(Grid grid, Cell[] image) {

        int temp1;
        Grid newGrid = new Grid(9);                         //new grid to put the permutated cells into
        boolean horiz = false;


        if (image[0].getcIndex() != 1                     //There has been a horizontal permutation only if the column index of
                ||image[1].getcIndex() != 4                 //the first two blocks has changed. Otherwise it must be vertical.
                ){
            horiz = true;
        }

        if (horiz) {
            int column = 0;
            for (int imageindex = 0; imageindex<3; imageindex++) {
                //transfer all the cells correctly to  newGrid
                for (int c = 0; c < 3; c++) {

                    for (int r = 0; r < 9; r++) {

                        newGrid.setValue(r + 1, c + 1 + column,
                                grid.getValue(image[imageindex].getrIndex() + r,
                                        image[imageindex].getcIndex() + c));
                    }

                }
                column += 3;

            }
        }
        else {                  //vertical permutation
            int row = 0;         //use the 1st cell of image
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 9; c++) {
                    newGrid.setValue(r + 1 + row, c + 1,
                            grid.getValue(image[0].getrIndex() + r,
                                    image[0].getcIndex() + c));
                }
            }
            row += 3;

            for (int r = 0; r < 3; r++) {       //use the 4th cell of image
                for (int c = 0; c < 9; c++) {
                    newGrid.setValue(r + 1 + row, c + 1,
                            grid.getValue(image[3].getrIndex() + r,
                                    image[3].getcIndex() + c));
                }
            }
            row += 3;

            for (int r = 0; r < 3; r++) {       //use the 5th cell of image
                for (int c = 0; c < 9; c++) {
                    newGrid.setValue(r + 1 + row, c + 1,
                            grid.getValue(image[4].getrIndex() + r,
                                    image[4].getcIndex() + c));
                }
            }
            row += 3;
        }

        for (int k= 1; k<10; k++){
            for (int i= 1; i<10; i++){
                grid.setValue(k,i,newGrid.getValue(k,i));
            }
        }
    }

    /**
     * The solution of this function makes use of the fact that there are only 11 possible Block Permutations. (10 + 1 which is the ID)
     * It applies all 11 images on grid1 and compares those with grid2. If any of them match, grid2 is the result of a grid1 block Permutation
     * @author Alexander Nikolov
     * @param grid1 The original grid.
     * @param grid2 The grid to compare to.
     * The grid to compare to, once permutated.
     * @return Returns true if grid2 is a block permutation of grid1, otherwise false.
     *
     */
    @Override
    public boolean isBlockPermutation(Grid grid1, Grid grid2) {

        Cell[][] images = new Cell[11][5];

        //ID
        images[0][0] = new Cell(1,1);
        images[0][1] = new Cell(1,4);
        images[0][2] = new Cell(1,7);
        images[0][3] = new Cell(4,1);
        images[0][4] = new Cell(7,1);

        //Horizontal
        images[1][0] = new Cell(1,1);
        images[1][1] = new Cell(1,7);
        images[1][2] = new Cell(1,4);
        images[1][3] = new Cell(4,1);
        images[1][4] = new Cell(7,1);

        images[2][0] = new Cell(1,4);
        images[2][1] = new Cell(1,1);
        images[2][2] = new Cell(1,7);
        images[2][3] = new Cell(4,4);
        images[2][4] = new Cell(7,4);

        images[3][0] = new Cell(1,4);
        images[3][1] = new Cell(1,7);
        images[3][2] = new Cell(1,1);
        images[3][3] = new Cell(4,4);
        images[3][4] = new Cell(7,4);

        images[4][0] = new Cell(1,7);
        images[4][1] = new Cell(1,4);
        images[4][2] = new Cell(1,1);
        images[4][3] = new Cell(4,7);
        images[4][4] = new Cell(7,7);

        images[5][0] = new Cell(1,7);
        images[5][1] = new Cell(1,1);
        images[5][2] = new Cell(1,4);
        images[5][3] = new Cell(4,7);
        images[5][4] = new Cell(7,7);

        //Vertical
        images[6][0] = new Cell(1,1);
        images[6][1] = new Cell(1,4);
        images[6][2] = new Cell(1,7);
        images[6][3] = new Cell(7,1);
        images[6][4] = new Cell(4,1);

        images[7][0] = new Cell(4,1);
        images[7][1] = new Cell(4,4);
        images[7][2] = new Cell(4,7);
        images[7][3] = new Cell(1,1);
        images[7][4] = new Cell(7,1);

        images[8][0] = new Cell(4,1);
        images[8][1] = new Cell(4,4);
        images[8][2] = new Cell(4,7);
        images[8][3] = new Cell(7,1);
        images[8][4] = new Cell(1,1);

        images[9][0] = new Cell(7,1);
        images[9][1] = new Cell(7,4);
        images[9][2] = new Cell(7,7);
        images[9][3] = new Cell(4,1);
        images[9][4] = new Cell(1,1);

        images[10][0] = new Cell(7,1);
        images[10][1] = new Cell(7,4);
        images[10][2] = new Cell(7,7);
        images[10][3] = new Cell(1,1);
        images[10][4] = new Cell(4,1);



        //applies all possible permutations on grid1. If grid2 is never achieved, grid2 is not a result of a permutation of grid1
        for (int k = 0; k<11; k++){
            Grid testGrid = new Grid(9);
            for (int j= 1; j<10; j++){
                for (int i= 1; i<10; i++){
                    testGrid.setValue(j,i,grid1.getValue(j,i));
                }
            }
            applyBlockPermutation(testGrid, images[k]);
            if (sameGrid(testGrid,grid2)){
                return true;
            }
        }
        return false;
    }

    /**
     * This method compares both grids by going through each cell.
     * @param g grid 1.
     * @param g2 grid 2.
     * @return Returns true if the grids have the same values.
     */
    //compares the two grids
    public boolean sameGrid (Grid g, Grid g2){

        for (int k = 1; k<10; k++){
            for (int i = 1; i<10; i++){

                if (g.getValue(k,i)!=g2.getValue(k,i)){
                    return false;
                }

            }
        }


        return true;
    }

    /**
     * Idea: See isBlockPermutation
     * Once the permutation of grid1 matches grid2, return the image that made it match.
     *
     * @author Alexander Nikolov
     * @param grid1 The original grid
     * @param grid2 The grid to compare grid1 to, once permutated.
     * @return The method returns the image which led to the permutated grid1 that matches grid2.
     *
     */
    @Override
    public Cell[] getBlockPermutationImage(Grid grid1, Grid grid2) {
        Cell[][] images = new Cell[11][5];

        //ID
        images[0][0] = new Cell(1,1);
        images[0][1] = new Cell(1,4);
        images[0][2] = new Cell(1,7);
        images[0][3] = new Cell(4,1);
        images[0][4] = new Cell(7,1);

        //Horizontal
        images[1][0] = new Cell(1,1);
        images[1][1] = new Cell(1,7);
        images[1][2] = new Cell(1,4);
        images[1][3] = new Cell(4,1);
        images[1][4] = new Cell(7,1);

        images[2][0] = new Cell(1,4);
        images[2][1] = new Cell(1,1);
        images[2][2] = new Cell(1,7);
        images[2][3] = new Cell(4,4);
        images[2][4] = new Cell(7,4);

        images[3][0] = new Cell(1,4);
        images[3][1] = new Cell(1,7);
        images[3][2] = new Cell(1,1);
        images[3][3] = new Cell(4,4);
        images[3][4] = new Cell(7,4);

        images[4][0] = new Cell(1,7);
        images[4][1] = new Cell(1,4);
        images[4][2] = new Cell(1,1);
        images[4][3] = new Cell(4,7);
        images[4][4] = new Cell(7,7);

        images[5][0] = new Cell(1,7);
        images[5][1] = new Cell(1,1);
        images[5][2] = new Cell(1,4);
        images[5][3] = new Cell(4,7);
        images[5][4] = new Cell(7,7);

        //Vertical
        images[6][0] = new Cell(1,1);
        images[6][1] = new Cell(1,4);
        images[6][2] = new Cell(1,7);
        images[6][3] = new Cell(7,1);
        images[6][4] = new Cell(4,1);

        images[7][0] = new Cell(4,1);
        images[7][1] = new Cell(4,4);
        images[7][2] = new Cell(4,7);
        images[7][3] = new Cell(1,1);
        images[7][4] = new Cell(7,1);

        images[8][0] = new Cell(4,1);
        images[8][1] = new Cell(4,4);
        images[8][2] = new Cell(4,7);
        images[8][3] = new Cell(7,1);
        images[8][4] = new Cell(1,1);

        images[9][0] = new Cell(7,1);
        images[9][1] = new Cell(7,4);
        images[9][2] = new Cell(7,7);
        images[9][3] = new Cell(4,1);
        images[9][4] = new Cell(1,1);

        images[10][0] = new Cell(7,1);
        images[10][1] = new Cell(7,4);
        images[10][2] = new Cell(7,7);
        images[10][3] = new Cell(1,1);
        images[10][4] = new Cell(4,1);



        //applies all possible permutations on grid1. If grid2 is never achieved, grid2 is not a result of a permutation of grid1
        for (int k = 0; k<11; k++) {
            Grid testGrid = new Grid(9);
            for (int j = 1; j < 10; j++) {
                for (int i = 1; i < 10; i++) {
                    testGrid.setValue(j, i, grid1.getValue(j, i));
                }
            }
            applyBlockPermutation(testGrid, images[k]);
            if (sameGrid(testGrid, grid2)) {
                return images[k];
            }



        }
        return new Cell[0];
    }

    /**
     * By going through each cell of the block, set the value as dictated by the image (only if it is not empty).
     * @author Alexander Nikolov
     * @param grid The grid to apply the Value permutation on
     * @param anchor The anchor determines the block to apply the value permutation on
     * @param image Is used to apply the permutation
     */
    //go through every cell in the block and if it is not empty, replace it with the number as defined in the image
    @Override
    public void applyBlockValuePermutation(Grid grid, Cell anchor, int[] image) {

        for (int r = 0; r<3; r++){
            for (int c = 0; c<3; c++){
                int value = -1;
                value = grid.getValue(anchor.getrIndex()+r,anchor.getcIndex()+c);
                if (value!=-1){
                    grid.setValue(anchor.getrIndex()+r, anchor.getcIndex()+c, image[value-1]);
                }
            }
        }



    }


    /**
     *
     * First, the method initializes a default image full of -2, which stands for "undefined".
     * Then, it compares two cells with the same coordinates in both grids.
     * If both cells are filled, take a look at the image. If it has been defined (i.e. it is not -2 anymore), then the value of the cell in grid2 must match the
     * definition in the image at index "[value-1]". If it doesn't, there is no valid value permutation. The method only returns an image if there is an output value for every input value.
     * At the end, after replacing the -2 entries with -1, make sure that no two different input numbers point to the same output number in the image. If there is such a case, again: no value permutation
     * could have taken place between those two grids.
     *
     *
     * @author Alexander Nikolov
     * @param grid1 The original grid.
     * @param grid2 The output.
     * @param anchor The anchor determines the block.
     * @return Returns the image that led to the permutation.
     */
    @Override
    public int[] getBlockValuePermutationImage(Grid grid1, Grid grid2, Cell anchor) {

        int[]image = {-2,-2,-2,-2,-2,-2,-2,-2,-2};      //-2 means undefined yet
        for (int r = 0; r <3; r++){
            for (int c  = 0; c<3; c++){
                int value1 = grid1.getValue(anchor.getrIndex()+r,anchor.getcIndex()+c);
                int value2 = grid2.getValue(anchor.getrIndex()+r,anchor.getcIndex()+c);



                if (value1!=-1&&value2!=-1){
                    if (image[value1-1]!=value2&&image[value1-1]!=-2){  //if both cells are populated, the image entry is defined but does not match what is being found in this iteration, return an empty image
                        return new int[0];
                    }
                    image[value1-1]=value2; //define what number should value1-1 change to (value2)
                }
                else if(value1==-1&&value2==-1){        //if both cells are empty, its all good

                }
                else {
                    return new int[0];
                }
            }
        }
        for (int i = 0; i<9; i++){      //replace all the undefined numbers with a -1
            if (image[i]==-2){
                image[i]=-1;
            }
        }
        //go through the vector. If a number appears twice, i.e. two numbers point to the same number, the image is invalid, thus g2 is not a result of g1
        for (int i = 0; i<8; i++) {
            int a = image[i];
            for (int j = i + 1; j < 9; j++) {
                if (a == image[j]&&a!=-1) {
                    return new int[0];
                }
            }
        }

                return image;
    }


    /**
     *
     * First, the method initializes a default image full of -2, which stands for "undefined".
     * Then, it compares two cells with the same coordinates in both grids.
     * If both cells are filled, take a look at the image. If it has been defined (i.e. it is not -2 anymore), then the value of the cell in grid2 must match the
     * definition in the image at index "[value-1]". If it doesn't, there is no valid value permutation. The method only returns "true" if there is an output value for every input value.
     * After replacing the -2 entries with -1, make sure that no two different input numbers point to the same output number in the image. If there is such a case, again: no value permutation
     * could have taken place between those two grids.
     * @author Alexander Nikolov
     * @param grid1 grid1 is the original grid.
     * @param grid2 grid2 is the possible result of a value permutation in grid1,
     * @param anchor Determines the block.
     * @return Returns true if grid2 is the result of a value permution of grid1.
     */
    @Override
    public boolean isBlockValuePermutation(Grid grid1, Grid grid2, Cell anchor) {


        int[]image = {-2,-2,-2,-2,-2,-2,-2,-2,-2};      //-2 means undefined yet
        for (int r = 0; r <3; r++){
            for (int c  = 0; c<3; c++){
                int value1 = grid1.getValue(anchor.getrIndex()+r,anchor.getcIndex()+c);
                int value2 = grid2.getValue(anchor.getrIndex()+r,anchor.getcIndex()+c);



                if (value1!=-1&&value2!=-1){
                    if (image[value1-1]!=value2&&image[value1-1]!=-2){  //if both cells are populated, the image entry is defined but does not match what is being found in this iteration, return an empty image
                        return false;
                    }
                    image[value1-1]=value2; //define what number should value1-1 change to (value2)
                }
                else if(value1==-1&&value2==-1){        //if both cells are empty, its all good

                }
                else {
                    return false;
                }
            }
        }
        for (int i = 0; i<9; i++){      //replace all the undefined numbers with a -1
            if (image[i]==-2){
                image[i]=-1;
            }
        }

        //go through the vector. If a number appears twice, i.e. two numbers point to the same number, the image is invalid, thus g2 is not a result of g1
        for (int i = 0; i<8; i++) {
            int a = image[i];
            for (int j = i + 1; j < 9; j++) {
                if (a == image[j]&&a!=-1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * By going through each cell in the block, count how many times a certain number occurs. If any number appears more than once, this is not a valid block.
     * @author Alexander Nikolov
     * @param grid The grid to perform the check on,
     * @param anchor The anchor determines the block.
     * @return Returns true if the grid is valid at anchor cell "anchor".
     */

    @Override
    public boolean isValidBlock(Grid grid, Cell anchor) {
       int[] numbers = {0,0,0,0,0,0,0,0,0};                                          //a list tracking the amount of each number from 1 to 9
       int r = anchor.getrIndex();
       int c = anchor.getcIndex();
       for (int i = 0; i < 3; i++){                                                  //go through each row (1 to 3) of the current block
           for (int j = 0; j< 3; j++){                                               //go through each column (1 to 3) of the current block
            if (grid.getValue(r+i, c+j)>0){
                   if (numbers[grid.getValue(r + i, c + j) - 1] ==0) {  //if the counter for the found value is not larger than 1, increase the counter by 1
                       numbers[grid.getValue(r + i, c + j) - 1] += 1;   //else return false (since the value appears more than once)
                   } else {
                       return false;
                   }
               }
           }
       }
       return true;
    }


    /**
     *
     * By going through each of the cells in the block, an empty cell is being added to a list "list".
     * @author Alexander Nikolov
     * @param grid The grid to work on.
     * @param anchor Anchor determines the block.
     * @return Returns a cell list with all the empty cells.
     */
    @Override
    public List<Cell> getBlockWhiteSpaces(Grid grid, Cell anchor) {
        List<Cell> list = new ArrayList<Cell>();
        int r = anchor.getrIndex();
        int c = anchor.getcIndex();
        for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
            for (int j = 0; j < 3; j++) {                                              //go through each column (1 to 3) of the current block
                if (grid.getValue(i+r, j+c)==-1){                       //if  the value is -1, add the cell to the list
                    list.add(grid.getCell(r+i, c+j));
                }
            }
        }
        return list;
    }


    /**
     *The method isFullHouseBlock is being applied for each of the 9 blocks in the grid. If any of them are a Full House Block, the method returns true.
     *
     * @author Alexander Nikolov
     * @param grid The grid to check.
     * @return Returns true if the grid has a full house block.
     */
    @Override
    public boolean hasFullHouseBlock(Grid grid) {
        boolean result = false;
        for (int r = 1; r < 10; r +=3) {                                                   //go through every anchor cell
                for (int c = 1; c < 10; c +=3) {
                    if (isFullHouseBlock(grid, grid.getCell(r, c))) {                      // if the block is a Full House Block, return true
                        return true;
                    }
                }
        }
        return result;
    }


     /**
     * The first condition to be met is that the block must be valid. So isValidBlock is being called.
     * Next, the method goes through each of the cells in the block and counts how many of them are empty. If there are exactly 1, then this block is a Full House Block.
     *
     * @author Alexander Nikolov
     * @param grid The grid to check.
     * @param anchor The anchor cell determines the block.
     * @return Returns true if the block is a full house block.
     */

    @Override
    public boolean isFullHouseBlock(Grid grid, Cell anchor) {

        if (isValidBlock(grid, anchor)) {                                                   // if the block is not valid, it cannot be a Full House block.
            int countBlanks = 0;                                                            //this variable counts the number of  blank fields
            int r = anchor.getrIndex();
            int c = anchor.getcIndex();

            for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
                for (int j = 0; j < 3; j++) {                                               //go through each column (1 to 3) of the current block
                    if (countBlanks<2) {
                        if (grid.getValue(i + r, j + c) == -1) {                       //if  the value is -1, increase the count
                            countBlanks += 1;
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
            if (countBlanks==1){
                return true;
            }
        }
        return false;
    }



    /**
     *
     * This method is being used in the Naked/Hidden Pair methods and checks which numbers appear in the row where the current cell is located. The method receives an array with size 9
     * which codifies the candidates by either 0 (candidate) or 1(not a candidate). The index of the array indicates which number is concerned.
     * So for example, if a given number appears somewhere in the row, the respective index in the array is being assigned 1.
     * @author Alexander Nikolov
     * @param candidates An array of length 9. Each index stands for a number and if it is 0, that means that it is a candidate for the current cell.
     * @param r The row to check.
     * @param grid The grid used.
     * @return Returns the list "candidates" with the updated entries.
     */
    public Integer[] crossOutCandidatesR (Integer[] candidates, int r,Grid grid){
        for (int i = 1; i<10; i++){
            if (grid.getValue(r,i)>0){
                candidates[grid.getValue(r,i)-1]= 1;
            }
        }
        return candidates;
    }

    /**
     *
     * This method is being used in the Naked/Hidden Pair methods and checks which numbers appear in the column where the current cell is located. The method receives an array with size 9
     *  which codifies the candidates by either 0 (candidate) or 1(not a candidate). The index of the array indicates which number is concerned.
     * If a given number appears somewhere in the column, the respective index in the array is being assigned 1. 
     * @author Alexander Nikolov
     * @param candidates An array of length 9. Each index stands for a number and if it is 0, that means that it is a candidate for the current cell.
     * @param c The column to check
     * @param grid The grid used.
     * @return Returns the list "candidates" with the updated entries.
     */
    public Integer[] crossOutCandidatesC (Integer[] candidates, int c, Grid grid) {
        for (int i = 1; i < 10; i++) {
            if (grid.getValue(i, c) > 0) {
                candidates[grid.getValue(i, c) - 1]= 1;
            }
        }
        return candidates;
    }

    /**

     * This method is being used in the Naked/Hidden Pair methods and checks which numbers appear in the block where the current cell is located. The method receives an array with size 9
     * which codifies the candidates by either 0 (candidate) or 1(not a candidate). The index of the array indicates which number is concerned.
     * If a given number appears somewhere in the block, the respective index in the array is being assigned 1. 
     * @author Alexander Nikolov
     * @param candidates An array of length 9. Each index stands for a number and if it is 0, that means that it is a candidate for the current cell.
     * @param r Helps indicate the block to check.
     * @param c Helps indicate the block to check.
     * @param grid The grid used.
     * @return Returns the list "candidates" with the updated entries.
     */
    public Integer[] crossOutCandidatesB (Integer[] candidates, int r, int c, Grid grid){
        for (int i =r; i < r+3; i++) {
            for (int j = c; j < c+3; j++){
                if (grid.getValue(i, j) > 0) {
                    candidates[grid.getValue(i, j) - 1]= 1;
                }
            }

        }
        return candidates;
    }


    /**
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     *
     * For every number from 1-9 k check whether it appears only once in a cell, if yes, return true.
     * @author Alexander Nikolov
     * @param grid The grid to check.
     * @param anchor The anchor cell determines the block.
     * @return Returns true if the block has a naked single cell.
     */
    @Override
    public boolean isBlockWithNakedSingleCell(Grid grid, Cell anchor) {


        int r = anchor.getrIndex();
        int c = anchor.getcIndex();

        for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
            for (int j = 0; j < 3; j++) {                                               //go through each column (1 to 3) of the current block
                if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty
                    Integer[] candidates = {0,0,0,0,0,0,0,0,0};                    //a list with all the numbers from 1-9. Such a list will be used for every cell in a block to keep track of the candidates
                    int numberCand = 9;
                    candidates = crossOutCandidatesR(candidates, i + r, grid);                          //checks the whole ROW of the current cell
                    candidates = crossOutCandidatesC(candidates, j + c, grid);                        //checks the whole COLUMN of the current cell
                    candidates = crossOutCandidatesB(candidates, r, c, grid);                          //checks the whole block of the current cell

                    for (int k = 0; k < 9; k++) {                                                            //subtract the amount of unique candidates
                        numberCand -=candidates[k];
                    }

                    if (numberCand == 1) {
                                                                                 //if there is only one candidate left, the cell is a single naked cell
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     *
     * For every number from 1-9 k check whether it appears only once in a cell, if yes, return the cell. At the beginning of the method we start looking from the cell with the lowest coordinates, 
     * Thus, it is guaranteed that the cell returned will be minimal.
     * @param grid The grid to check.
     * @param anchor The anchor cell determines the block.
     * @return Returns the minimal naked single cell.
     */
    @Override
    public Cell getBlockNakedSingleCell(Grid grid, Cell anchor) {


       if (isBlockWithNakedSingleCell(grid, anchor)){
           int r = anchor.getrIndex();
           int c = anchor.getcIndex();

           for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
               for (int j = 0; j < 3; j++) {                                               //go through each column (1 to 3) of the current block
                   if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty
                       Integer[] candidates = {0,0,0,0,0,0,0,0,0};                    //a list with all the numbers from 1-9. Such a list will be used for every cell in a block to keep track of the candidates
                       int numberCand = 9;
                       candidates = crossOutCandidatesR(candidates, i + r, grid);                          //checks the whole ROW of the current cell
                       candidates = crossOutCandidatesC(candidates, j + c, grid);                        //checks the whole COLUMN of the current cell
                       candidates = crossOutCandidatesB(candidates, r, c, grid);                          //checks the whole block of the current cell

                       for (int k = 0; k < 9; k++) {                                                            //subtract the number of unique candidates
                           numberCand -= candidates[k];
                       }

                       if (numberCand == 1) {
                          return grid.getCell(r+i, c+j);                                           //if there is only one candidate left, the cell is a single naked cell

                       }
                   }
               }
           }

       }

       return null;
    }

    /**
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     * Next, check for every number k 1-9 if there is only once cell that accepts that k. Put that cell into a list. Finally, if the list is not empty, there is a hidden single cell.
     *
     * @author Alexander Nikolov
     * @param grid The grid used.
     * @param anchor The anchor cell determines the block.
     * @return Returns true if the block has a hidden single cell.
     */
    @Override
    public boolean isBlockWithHiddenSingleCell(Grid grid, Cell anchor) {

        int r = anchor.getrIndex();
        int c = anchor.getcIndex();
        Integer[][] candidates = new Integer[9][9];                                      //create 9 lists with 9 values "0"
        for (int k = 0; k<9; k++){
            for (int l = 0; l< 9; l++){
                if (grid.getValue(anchor.getrIndex()+k/3, anchor.getcIndex()+k%3)==-1){     //if a cell is populated, fill its list with ones, so it won't be considered later on
                    candidates[k][l] = 0;
                }
                else
                    candidates[k][l] = 1;

            }
        }
        int cellInBlock = 0;                                                        //a counter variable
        for (int i = 0; i < 3; i++) {                                                  //go through each row and column of the current block and put ones into the list for numbers that cannot be candidates as they exist
            for (int j = 0; j < 3; j++) {                                               //somewhere in a row, column, or in the block

                if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty

                    int numberCand = 9;
                    candidates [cellInBlock] = crossOutCandidatesR(candidates[cellInBlock], i + r, grid);                          //puts ones for numbers that cannot be candidates
                    candidates [cellInBlock] = crossOutCandidatesC(candidates[cellInBlock], j + c, grid);
                    candidates [cellInBlock] = crossOutCandidatesB(candidates[cellInBlock], r, c, grid);

                }
                cellInBlock++;
            }
        }
        List<Cell> listOfHiddenCells = new ArrayList<Cell>();                                                   //create a list of the hiddenCells found
        Cell hiddenCell = null;

        for (int k = 0; k<9; k++){                                                                              //go through the numbers from 1-9

            int countK = 0;

            for (int j = 0; j<9; j++){                                                                      //by going through the candidate lists of every cell, check whether a number (k) is allowed into only one cell and no others. If yes, thats a hidden single cell for the number (k)
                if (candidates[j][k]==0 && countK==0){
                    countK+=1;
                    hiddenCell = new Cell(anchor.getrIndex()+j/3, anchor.getcIndex()+j%3);
                }
                else if (candidates[j][k]==0 && countK>0){                                                  //if there is another cell that accepts the number k, we cant be dealing with a hidden single cell for this number, so remove it from the list
                    hiddenCell = null;
                }

            }
            if (hiddenCell!=null){
                listOfHiddenCells.add(hiddenCell);                                                          //if there was only one cell found for k, it is a hidden cell, so add it to the list
            }
        }
        if (!listOfHiddenCells.isEmpty()){                                                                      //if the list has an entry, the block has a hidden single cell

                return true;

        }

        return false;

    }


    /**
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     * Next, check for every number k 1-9 if there is only one cell that accepts that k. Put that cell into a list. Finally, search for the hidden single cell with the lowest coordinates and return that.
     * @author Alexander Nikolov
     * @param grid The grid used.
     * @param anchor The anchor cell determines the block.
     * @return Returns a single hidden cell with the lowest coordinates.
     */
    @Override
    public Cell getBlockMinimalHiddenSingleCell(Grid grid, Cell anchor) {
        List<Integer>tempNumber = new ArrayList<Integer>();
        int r = anchor.getrIndex();
        int c = anchor.getcIndex();
        Integer[][] candidates = new Integer[9][9];                                      //create 9 lists with 9 values "0"
        for (int k = 0; k<9; k++){
            for (int l = 0; l< 9; l++){
                if (grid.getValue(anchor.getrIndex()+k/3, anchor.getcIndex()+k%3)==-1){     //if a cell is populated, fill its list with ones, so it won't be considered later on
                    candidates[k][l] = 0;
                }
                else
                    candidates[k][l] = 1;

            }
        }
        int cellInBlock = 0;                                                            //a counter variable
        for (int i = 0; i < 3; i++) {                                                  //go through each row and column of the current block and put ones into the list for numbers that cannot be candidates as they exist
            for (int j = 0; j < 3; j++) {                                                   //somewhere in a row, column, or in the block

                if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty

                    int numberCand = 9;
                    candidates [cellInBlock] = crossOutCandidatesR(candidates[cellInBlock], i + r, grid);                          //checks the whole ROW of the current cell
                    candidates [cellInBlock] = crossOutCandidatesC(candidates[cellInBlock], j + c, grid);                        //checks the whole COLUMN of the current cell
                    candidates [cellInBlock] = crossOutCandidatesB(candidates[cellInBlock], r, c, grid);                          //checks the whole block of the current cell

                }
                cellInBlock++;
            }
        }
        List<Cell> listOfHiddenCells = new ArrayList<Cell>();                                                               //create a list of the hiddenCells found

        Cell hiddenCell = null;

        for (int k = 0; k<9; k++){                                                                       //go through the numbers from 1-9

            int countK = 0;

            for (int j = 0; j<9; j++){              //by going through the candidate lists of every cell, check whether a number (k) is allowed into only one cell. If yes, thats a hidden single cell for the number (k)
                if (candidates[j][k]==0 && countK==0){              //if  the cell accepts the number k, it is a potential single naked cell.
                    countK+=1;
                    hiddenCell = new Cell(anchor.getrIndex()+j/3, anchor.getcIndex()+j%3);
                }
                else if (candidates[j][k]==0 && countK>0){          //if there is another cell that accepts the number k too, we cant be dealing with a hidden single cell for this number, thus so remove it from the list
                    hiddenCell = null;
                }

            }
            if (hiddenCell!=null){                                  //if there was only one cell found for k, it is a hidden cell, so add it to the list
                listOfHiddenCells.add(hiddenCell);
                tempNumber.add(k+1);

            }
        }
        if (!listOfHiddenCells.isEmpty()){
            Cell minHiddenCell = new Cell(100,100);
            for (int k=0; k<listOfHiddenCells.size(); k++){
                if (listOfHiddenCells.get(k).getrIndex()<minHiddenCell.getrIndex()                                                                          //if the row index of the found cell is smaller than the previous minimal cell
                        || listOfHiddenCells.get(k).getrIndex()==minHiddenCell.getrIndex() && listOfHiddenCells.get(k).getcIndex()<minHiddenCell.getcIndex()){      //or if the row is the same, but the column is smaller, update the minimal hidden cell
                    minHiddenCell=listOfHiddenCells.get(k);
                    numberToPutIntoSingle.add(0,tempNumber.get(k));
                }


            }
            return minHiddenCell;


        }

        return null;


    }

    /**
     *
     *
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     *
     * Then, for each list, check if it contains exactly 2 candidates. If that's the case, add it to a potential list of naked pairs (listNaked) and
     * also save their candidate lists into (cellCandList).
     * Then, compare every cell's candidate list in "listNaked" with all the others'. If there is an exact match of candidate lists, return true.
     * If there is no match at the end of the loop, return false.
     * @author Alexander Nikolov
     * @param grid The grid to check.
     * @param anchor The anchor determines the block.
     * @return Returns true if the block has a naked pair.
     */
    @Override
    public boolean isBlockWithNakedPair(Grid grid, Cell anchor) {

            List<Integer[]> cellCandList = new ArrayList<Integer[]>();
            int r = anchor.getrIndex();
            int c = anchor.getcIndex();
            List<Cell> listNaked = new ArrayList<Cell>();
            for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
                for (int j = 0; j < 3; j++) {                                               //go through each column (1 to 3) of the current block
                    if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty
                        Integer[] candidates = {0,0,0,0,0,0,0,0,0};                    //a list with all the numbers from 1-9. Such a list will be used for every cell in a block to keep track of the candidates
                        int numberCand = 9;
                        candidates = crossOutCandidatesR(candidates, i + r, grid);                          //checks the whole ROW of the current cell
                        candidates = crossOutCandidatesC(candidates, j + c, grid);                        //checks the whole COLUMN of the current cell
                        candidates = crossOutCandidatesB(candidates, r, c, grid);                          //checks the whole block of the current cell

                        for (int k = 0; k < 9; k++) {                                                            //subtract the number of unique candidates
                            numberCand -= candidates[k];
                        }

                        if (numberCand == 2) {

                            cellCandList.add(candidates);
                            listNaked.add(grid.getCell(r+i,c+j));                                           //if there are two candidates left, the cell is a potential part of a naked pair

                        }
                    }
                }
            }

            if (listNaked.size()>1) {
                for (int k = 0; k < listNaked.size()-1; k++) {
                    for (int l = k+1; l < listNaked.size(); l++) {
                        Cell naked1 = listNaked.get(k);
                        Cell naked2;

                        if (listNaked.get(k + l).getcIndex() == naked1.getcIndex() && listNaked.get(k + l).getrIndex() == naked1.getrIndex() + 1                //if there there are two neighboring naked Cells, they make a Naked pair.
                                || listNaked.get(k + l).getrIndex() == naked1.getrIndex() && listNaked.get(k + l).getcIndex() == naked1.getcIndex() + 1) {

                           boolean sameCand = true;
                           for (int m = 0; m<9; m++){                       //go through all numbers and set sameCand=false if there is a difference in the candidates

                               if (cellCandList.get(k)[m]!=cellCandList.get(k+l)[m]){
                                   sameCand = false;

                               }
                           }
                           if (sameCand) {
                               naked2 = listNaked.get(k + 1);
                               return true;
                           }
                        }


                    }

                }
            }

        return false;
    }

    /**
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     *
     * Then, for each list, check if it contains exactly 2 candidates. If that's the case, add it to a potential list of naked pairs (listNaked) and
     * also save their candidate lists into (cellCandList).
     * Then, compare every cell's candidate list in "listNaked" with all the others'. If there is an exact match of candidate lists, that is a naked pair.
     * Return the first match as it is guaranteed that the cell with the lowest coordinates will be saved before any other cell (just like in the method getBlockNakedSingleCell).
     *
     * @author Alexander Nikolov
     * @param grid The grid to check.
     * @param anchor The anchor determines the block.
     * @return Returns the coordinates of the lowest member of a naked pair.
     */
    @Override
    public Cell[] getBlockNakedPairCells(Grid grid, Cell anchor) {
        List<Integer[]> cellCandList = new ArrayList<Integer[]>();      //this list will contain the candidates for each cell in the block
        int r = anchor.getrIndex();
        int c = anchor.getcIndex();
        List<Cell> listNaked = new ArrayList<Cell>();      //the list of cells that accept only 2 numbers, i.e. are naked singles
        for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
            for (int j = 0; j < 3; j++) {                                               //go through each column (1 to 3) of the current block
                if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty
                    Integer[] candidates = {0,0,0,0,0,0,0,0,0};                    //a list with all the numbers from 1-9. Such a list will be used for every cell in a block to keep track of the candidates
                    int numberCand = 9;
                    candidates = crossOutCandidatesR(candidates, i + r, grid);                          //checks the whole ROW of the current cell
                    candidates = crossOutCandidatesC(candidates, j + c, grid);                        //checks the whole COLUMN of the current cell
                    candidates = crossOutCandidatesB(candidates, r, c, grid);                          //checks the whole block of the current cell

                    for (int k = 0; k < 9; k++) {                                                            //subtract the number of unique candidates
                        numberCand -= candidates[k];
                    }

                    if (numberCand == 2) {
                        cellCandList.add(candidates);
                        listNaked.add(grid.getCell(r+i,c+j));                                           //if there are two candidates left, the cell is a potential part of a naked pair

                    }
                }
            }
        }

        if (listNaked.size()>1) {
            for (int k = 0; k < listNaked.size()-1; k++) {
                for (int l = k+1; l < listNaked.size(); l++) {
                    Cell naked1 = listNaked.get(k);
                    Cell naked2;

                        boolean sameCand = true;
                        for (int m = 0; m<9; m++){                       //go through all numbers and set sameCand=false if there is a difference in the candidates

                            if (cellCandList.get(k)[m]!=cellCandList.get(k+l)[m]){
                                sameCand = false;
                            }
                        }
                        if (sameCand) {

                            naked2 = listNaked.get(k + 1);
                            Cell[] pair =  {naked1, naked2};

                            for (int match = 0; match<9; match++){
                                if (cellCandList.get(k)[match]==0){
                                    numbersToPutIntoPair.add(match);     //adds the same number for the naked pairs into the global variable numbersToPutIntoPair
                                }
                            }

                            return pair;
                        }

                }
            }
        }


        Cell[] result = new Cell[0];
        return result;
    }

    /**
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     * Go through each cell in the block and complete all 9 candidate lists by calling the methods crossOutCandidatesR, crossOutCandidatesC and crossOutCandidatesB (which check
     * which numbers have already been put in a place that disqualifies them as candidates. For more information, go to the descriptions of those methods).
     * Once the lists are complete, go through all the numbers 1-9 and check in how many candidate lists they appear. If they appear in exactly two candidate lists,
     * put the respective cells into a new list, called "listHiddenCells". Then, search for matching pairs by looking at their coordinates. If two cells appear twice as a pair (i.e. next to each other in "listHiddenCells", 
     * they are a hidden pair. Put those into a final hidden pair list. If the list is having at least 2 entries, then return true for the entire method.
     * @author Alexander Nikolov
     * @param grid The grid to check.
     * @param anchor The anchor determines the block.
     * @return Returns true if the block has a hidden pair.
     */
    @Override
    public boolean isBlockWithHiddenPair(Grid grid, Cell anchor) {

        List<Integer[]> cellCandList = new ArrayList<Integer[]>(); //this list will contain the candidates for each cell in the block
        int r = anchor.getrIndex();
        int c = anchor.getcIndex();
        List<Cell> listCells = new ArrayList<Cell>();       //
        for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
            for (int j = 0; j < 3; j++) {                                               //go through each column (1 to 3) of the current block
                if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty
                    Integer[] candidates = {0,0,0,0,0,0,0,0,0};                    //a list with all the numbers from 1-9. Such a list will be used for every cell in a block to keep track of the candidates

                    candidates = crossOutCandidatesR(candidates, i + r, grid);                          //checks the whole ROW of the current cell
                    candidates = crossOutCandidatesC(candidates, j + c, grid);                        //checks the whole COLUMN of the current cell
                    candidates = crossOutCandidatesB(candidates, r, c, grid);                          //checks the whole block of the current cell
                    cellCandList.add(candidates);
                    listCells.add(grid.getCell(r+i,c+j));
                }
                else {
                    Integer[] candidates = {1,1,1,1,1,1,1,1,1};                     //all 1 means this cell is populated and there are no candidates available
                    cellCandList.add(candidates);
                    listCells.add(grid.getCell(r+i,c+j));
                }
            }
        }

        List<Cell> listHiddenCells = new ArrayList<Cell>();             //a list of potential Hidden Cell Pairs
        for (int k = 0; k<9; k++){
            int countCells = 0;
            for (int j = 0; j<listCells.size(); j++){
                if (cellCandList.get(j)[k]==0){                                         //if a given cell accepts the number k, and there no more than 2 such cells this far, put it into a list of potential hiddenPairs
                    countCells +=1;
                    listHiddenCells.add(grid.getCell(anchor.getrIndex()+j/3, anchor.getcIndex()+j%3));

                }
            }
            if (countCells>2||countCells==1) {              //if there are more than 3 or exactly one cell accepting that number, discard them. Those cant be part of a hidden pair
                for (int a = 0; a<countCells; a++) {
                    listHiddenCells.remove(listHiddenCells.size() - 1);
                }
            }
        }

        if (listHiddenCells.size()>3){          //only if there are at least 4 cells in the list, there can be a hidden pair because a hidden pair means the cells have to appear twice each for 2 different k-numbers
            List<Cell> listHiddenCellsFinal = new ArrayList<Cell>(); //here we will put all the cells that appear twice and are true hidden pairs

            for (int k = listHiddenCells.size()-1; k>2; k-=2){

                for (int j = k-2; j>0; j-=2){
                    if (listHiddenCells.get(k).getrIndex()==listHiddenCells.get(j).getrIndex()          //if two cells appear twice, then they are a hidden pair. Compare their coordinates
                            &&listHiddenCells.get(k).getcIndex()==listHiddenCells.get(j).getcIndex()
                            &&listHiddenCells.get(k-1).getrIndex()==listHiddenCells.get(j-1).getrIndex()
                            &&listHiddenCells.get(k-1).getcIndex()==listHiddenCells.get(j-1).getcIndex()){

                        listHiddenCellsFinal.add(listHiddenCells.get(k-1));     //add the true hidden pairs to the final list
                        listHiddenCellsFinal.add(listHiddenCells.get(k));
                    }
                }



            }
            if (listHiddenCellsFinal.size()>1){                      //if there are 4 or more cells left at the end, we are having a hidden pair
                return true;
            }
        }





        return false;
    }

    /**
     * Keep track of the candidates for each cell by creating a special list:
     * cellCandList will contain all the candidates for a given cell in the format: {0,0,0,0,1,0,0,1,1} means this cell accepts all the numbers except for 5,8 and 9.
     * In other words, the index of the array indicates the number. 0 means it is a candidate and 1 means it is not.
     * Go through each cell in the block and complete all 9 candidate lists by calling the methods crossOutCandidatesR, crossOutCandidatesC and crossOutCandidatesB (which check
     * which numbers have already been put in a place that disqualifies them as candidates. For more information, go to the descriptions of those methods).
     * Once the lists are complete, go through all the numbers 1-9 and check in how many candidate lists they appear. If they appear in exactly two candidate lists,
     * put the cells into a new list, called "listHiddenCells". Then, search for matching pairs by looking at their coordinates. If two cells appear twice as a pair (i.e. next to each other in listHiddenCelld), 
     * they are a hidden pair. At the end, pick the pair with the minimal coordinates and return it.
     *
     * @author Alexander Nikolov
     * @param grid The grid to check.
     * @param anchor The anchor determines the block.
     * @return Returns the cell pair with the minimal coordinates.
     */
    @Override
    public Cell[] getBlockHiddenPairCells(Grid grid, Cell anchor) {
        List<Integer[]> cellCandList = new ArrayList<Integer[]>();      //this list will contain the candidates for each cell in the block
        int r = anchor.getrIndex();
        int c = anchor.getcIndex();
        List<Cell> listCells = new ArrayList<Cell>();       //this will put all the cells of the block into an array
        for (int i = 0; i < 3; i++) {                                                  //go through each row (1 to 3) of the current block
            for (int j = 0; j < 3; j++) {                                               //go through each column (1 to 3) of the current block
                if (grid.getValue(r+i,c+j)==-1) {                             //the cell has to be empty
                    Integer[] candidates = {0,0,0,0,0,0,0,0,0};                    //a list with all the numbers from 1-9. Such a list will be used for every cell in a block to keep track of the candidates
                    int numberCand = 9;
                    candidates = crossOutCandidatesR(candidates, i + r, grid);                          //checks the whole ROW of the current cell
                    candidates = crossOutCandidatesC(candidates, j + c, grid);                        //checks the whole COLUMN of the current cell
                    candidates = crossOutCandidatesB(candidates, r, c, grid);                          //checks the whole block of the current cell
                    cellCandList.add(candidates);
                    listCells.add(grid.getCell(r+i,c+j));
                }
                else {
                    Integer[] candidates = {1,1,1,1,1,1,1,1,1};             //if the cell is populated, fill the candidates list with 1
                    cellCandList.add(candidates);
                    listCells.add(grid.getCell(r+i,c+j));
                }

            }
        }

        List<Cell> listHiddenCells = new ArrayList<Cell>();             //this list contains possible hiddenPairs by taking cells that are the only two cells that accept a particular number
        List<Integer> numberAss = new ArrayList<Integer>();

        for (int k = 0; k<9; k++){
            int countCells = 0;             //this will count how many times a particular cell appears. It should appear exactly twice
            for (int j = 0; j<listCells.size(); j++){
                if (cellCandList.get(j)[k]==0){                                         //if a given cell accepts the number k, and there no more than 2 such cells this far, put it into a list of potential hiddenPairs
                    countCells +=1;
                    listHiddenCells.add(grid.getCell(anchor.getrIndex()+j/3, anchor.getcIndex()+j%3));
                    numberAss.add(k+1);
                }
            }
            if (countCells>2||countCells==1) {
                for (int a = 0; a<countCells; a++) {
                    listHiddenCells.remove(listHiddenCells.size() - 1);
                    numberAss.remove(numberAss.size()-1);
                }
            }
        }

        if (listHiddenCells.size()>3){          //only if there are at least 4 cells in the list, there can be a hidden pair because a hidden pair means the cells have to appear twice each for 2 different k-numbers
            List<Cell> listHiddenCellsFinal = new ArrayList<Cell>(); //here we will put all the cells that appear twice and are true hidden pairs
            int i = listHiddenCells.size()-1;
            for (int k = i; k>2; k-=2){

                for (int j = k-2; j>0; j-=2){
                    if (listHiddenCells.get(k).getrIndex()==listHiddenCells.get(j).getrIndex()          //if two cells appear twice (pairwise, i.e. the 4th and the 2nd are compared with the 3th and the 1st), then they are a hidden pair
                            &&listHiddenCells.get(k).getcIndex()==listHiddenCells.get(j).getcIndex()
                            &&listHiddenCells.get(k-1).getrIndex()==listHiddenCells.get(j-1).getrIndex()
                            &&listHiddenCells.get(k-1).getcIndex()==listHiddenCells.get(j-1).getcIndex()


                            ){

                        listHiddenCellsFinal.add(listHiddenCells.get(k-1));     //add the true hidden pairs to the final list
                        listHiddenCellsFinal.add(listHiddenCells.get(k));
                    }
                }




            }

            if (listHiddenCellsFinal.size()>1) {     //list length still has to be at least 4




                Cell min = listHiddenCellsFinal.get(0);                               //search for the cell with the lowest coordinates
                int minIndex = 0;
                for (int k = 1; k<listHiddenCellsFinal.size(); k++){         //search for the cell with the lowest coordinates
                    if (listHiddenCellsFinal.get(k).getrIndex()<min.getrIndex()
                            ||listHiddenCellsFinal.get(k).getrIndex()==min.getrIndex()
                            &&listHiddenCellsFinal.get(k).getcIndex()<min.getcIndex()){
                        min = listHiddenCellsFinal.get(k);
                        minIndex = k;

                    }
                }
                Cell[] hiddenPair = new Cell[2];            //return the min cell. Look for its partner by checking whether its order in the list is odd or even
                if (minIndex % 2 == 1) {            //if its odd, that means that the min cell is the right partner in the pair
                    hiddenPair[1] = min;
                    hiddenPair[0] = listHiddenCellsFinal.get(minIndex - 1);
                } else {
                    hiddenPair[0] = min;
                    hiddenPair[1] = listHiddenCellsFinal.get(minIndex + 1);
                }
                return hiddenPair;
            }
        }



        return new Cell[0];
    }



    /**
     * Clones a grid.
     * @author Alexander Nikolov
     * @param grid The grid to clone.
     * @return Returns the clone.
     */
    public Grid copyGrid (Grid grid){
        Grid result = new Grid(9);
        for (int r=1; r<10; r++){
            for (int c=1; c<10; c++){
                result.setValue(r,c,grid.getValue(r,c));
            }
        }

        return result;
    }


    /**
     * Note: as of now not in use.
     * Similarly to the createGlobalList method, the method clears the global candidate list of any numbers that are already used.
     * @author Alexander Nikolov
     * @param grid The grid to update.
     * @param clearNumber The number to delete from the candidate list.
     */
    public void update(Grid grid, int clearNumber) {


        for (int k = 1; k<10; k++){             //the number to check for in the cells
            for (int r = 0; r<9; r++){
                for (int c = 0; c<9; c++){
                    if (grid.getValue(r+1,c+1)==k){
                        removeCandidatesSameRow (grid, r, k, globalCandidateList[r]);
                        removeCandidatesSameCol (grid, c, k, globalCandidateList);
                        removeCandidatesSameBlock (grid, r, c, k, globalCandidateList);


                    }

                }
            }
        }


        for (int r = 0; r<9; r++){
            for (int c = 0; c<9; c++){
                if (grid.getValue(r+1,c+1)==clearNumber){
                    removeCandidatesSameRow (grid, r, clearNumber, globalCandidateList[r]);
                    removeCandidatesSameCol (grid, c, clearNumber, globalCandidateList);
                    removeCandidatesSameBlock (grid, r, c, clearNumber, globalCandidateList);

                }
            }
        }




    }


    /**
     * A complete copy of solveBlockBased with the only difference being that it doesn't add the current grid to the list at the very beginning of the method. For convenience reasons related
     * to the recursive approach to the solver method.
     * @author Alexander Nikolov
     * @param grid The grid to solve.
     * @param grids Needed to add the next grid to the grid list.
     * @return Returns a grid which is one step closer to being solved.
     */
    public Grid solveBlockBasedWithoutStep0(Grid grid, List<Grid> grids) {



        createGlobalList(grid);
        if (completeAndValid(grid)){                //Schritt 1
            return grid;
        }

        if (hasFullHouseBlock(grid)){          //Schritt 2
            fillFullHouse(grid);
          
            //Update missing
            grids.add( copyGrid(grid));
            solveBlockBasedWithoutStep0(grid, grids);

        }

        for (int r=1; r<10; r+=3) {
            for (int c = 1; c < 10; c += 3) {
                if (isBlockWithNakedSingleCell(grid, grid.getCell(r, c))) {                                 //Schritt 3

                    fillNakedSingle(grid, r,c);
                    
                    // Update missing
                    grids.add( copyGrid(grid));
                    solveBlockBasedWithoutStep0(grid,grids);


                }
            }
        }

        for (int r=1; r<10; r+=3) {
            for (int c = 1; c < 10; c += 3) {
                if (isBlockWithHiddenSingleCell(grid, grid.getCell(r, c))) {                                 //Schritt 4

                    fillHiddenCell(grid, r, c);
                 
                    //Update missing
                    grids.add( copyGrid(grid));
                    solveBlockBasedWithoutStep0(grid,grids);


                }
            }
        }

        /*for (int r=1; r<10; r+=3) {
            for (int c = 1; c < 10; c += 3) {
                if (isBlockWithNakedPair(grid, grid.getCell(r, c))) {                                 //Schritt 5

                    useNakedPair(grid, r, c);
                    //update not needed here, because no number is being deleted. useNakedPair however does the job of clearing the two numbers of a pair in any other
                    //cell in the same row or column if the the pair shares a row or a column.
                    solveBlockBasedWithoutStep0(grids.get(1),grids);
                }
            }
        }
        */

        /**for (int r=1; r<10; r+=3) {
         for (int c = 1; c < 10; c += 3) {
         if (isBlockWithHiddenPair(grid, grid.getCell(r, c))) {                                 //Schritt 5


         solveBlockBasedWithoutStep0(grids.get(1), grids);
         }
         }
         }

         */



        return grid;
    }

    /**
     *
     * 0. The method creates a global candidate list.
     * 1. It checks whether the grid is complete and valid using the completeAndValid method..
     * 2. It looks if there is a full house block; if yes, it fills it using fillNakedSingle.
     * 3. By going through each anchor cell, it looks if there is a block with a naked single. If yes, it fills it using fillHiddenSingle.
     * 4. By going through each anchor cell, it looks if there is a block with a hidden single. If yes, it fills it using fillHiddenCell.
     * 5.(In development): By going through each anchor cell, it looks if there is a block with a naked pair. If yes, it updates the candidate list of all the related cells using
     * useNakedPair.
     * 6.(In development): By going through each anchor cell, it looks if there is a block with a hidden pair.
     * @author Alexander Nikolov
     * @param grid The grid to solve.
     * @return Returns a list of grids that document the change in the grid throughout the method.
     */
    @Override
   public List<Grid> solveBlockBased(Grid grid) {

        createGlobalList(grid);                     //Schritt 0
        grids.add(copyGrid(grid));
        //grids.add(grid);
        



        if (completeAndValid(grid)){                //Schritt 1
            return grids;
        }

        if (hasFullHouseBlock(grid)){          //Schritt 2
            fillFullHouse(grid);
            //Update missing
         
            solveBlockBasedWithoutStep0(grid, grids);

        }

        for (int r=1; r<10; r+=3) {
            for (int c = 1; c < 10; c += 3) {
                if (isBlockWithNakedSingleCell(grid, grid.getCell(r, c))) {                                 //Schritt 3

                    fillNakedSingle(grid, r,c);
                   // Update missing
               

                    solveBlockBasedWithoutStep0(grid, grids);

                }
            }
        }



        for (int r=1; r<10; r+=3) {
            for (int c = 1; c < 10; c += 3) {
                if (isBlockWithHiddenSingleCell(grid, grid.getCell(r, c))) {                                 //Schritt 4

                    fillHiddenCell(grid, r, c);
                    //Update missing
                    
                
                    solveBlockBasedWithoutStep0(grid, grids);

                }
            }
        }

       /* for (int r=1; r<10; r+=3) {
            for (int c = 1; c < 10; c += 3) {
                if (isBlockWithNakedPair(grid, grid.getCell(r, c))) {                                 //Schritt 5

                    useNakedPair(grid, r, c);
                    //update not needed here, because no number is being deleted. useNakedPair however does the job of clearing the two numbers of a pair in any other
                    //cell in the same row or column if the the pair shares a row or a column.
                    solveBlockBasedWithoutStep0(grids.get(1), grids);
                }
            }
        }
        */

       /**for (int r=1; r<10; r+=3) {
            for (int c = 1; c < 10; c += 3) {
                if (isBlockWithHiddenPair(grid, grid.getCell(r, c))) {                                 //Schritt 5


                    solveBlockBasedWithoutStep0(grids.get(1), grids);
                }
            }
        }

*/

        return grids;
    }


    /**
     * Note: as of now not in use because the global candidate list is not utilized within the getBlockxPairCells methods.
     *
     * This method fetches the cells from the global list getBlockPairCells (which are just the two cells of the minimal Pair in a block) and compares their coordinates.
     * If and only if they share a column or a row, clear the candidate lists
     * of all cells that are in the same column or row.
     * @author Alexander Nikolov
     * @param grid The current grid.
     * @param r The row.
     * @param c The column.
     */
    public void useNakedPair(Grid grid, int r, int c){
        boolean alreadyFoundOne = false;

        if (isBlockWithNakedPair(grid, grid.getCell(r,c))&&!alreadyFoundOne){
            Cell[] naked = new Cell[2];
            naked[0] = getBlockNakedPairCells(grid, grid.getCell(r,c))[0];
            naked[1] = getBlockNakedPairCells(grid, grid.getCell(r,c))[1];

            //you need to take into consideration whether the pair shares a row or a column before deleting the numbers

            if (naked[0].getcIndex()==naked[1].getcIndex()) { //if the pairs share the same column, delete the numbers from the candidate lists of all the other cells in the same column

                for (int row=1; row<10; row++){
                    removeNumberFromCandidateList(globalCandidateList[row][c],numbersToPutIntoPair.get(0));
                    removeNumberFromCandidateList(globalCandidateList[row][c],numbersToPutIntoPair.get(1));

                }
                numbersToPutIntoPair.remove(0); //clear the list again
                numbersToPutIntoPair.remove(0);
            }

            if (naked[0].getrIndex()==naked[1].getrIndex()) { //if the pairs share the same row, delete the numbers from the candidate lists of all the other cells in the same row
                for (int col=1; col<10; col++) {
                    removeNumberFromCandidateList(globalCandidateList[r][col],numbersToPutIntoPair.get(0));
                    removeNumberFromCandidateList(globalCandidateList[r][col],numbersToPutIntoPair.get(1));
                }

                numbersToPutIntoPair.remove(0); //clear the list again
                numbersToPutIntoPair.remove(0);
            }
            alreadyFoundOne=true;

        }
    }
    /**
     * This method looks for the first unit in the grid with a hidden single cell and fills it using the getBlockMinimalHiddenSingleCell method.
     * @author Alexander Nikolov
     * @param grid The current grid.
     * @param r The row.
     * @param c The column.
     */
    public void fillHiddenCell(Grid grid, int r, int c){
        boolean alreadyFoundOne = false;        //we only want to fill the first full house cell in case there are more than one.

                if (isBlockWithHiddenSingleCell(grid, grid.getCell(r,c))&&!alreadyFoundOne){
                    Cell hidden = getBlockMinimalHiddenSingleCell(grid, grid.getCell(r,c));  //used to get the coordinates of the hidden single
                    int value = numberToPutIntoSingle.get(0);
                    grid.getCell(hidden.getrIndex(),hidden.getcIndex()).setValue(value);                             //set its value to the number put into the numberToPutIntoSingle list

                    alreadyFoundOne=true;

        }
    }



    /**
     * This method looks for the first unit in the grid with a naked naked cell and fills it using the getBlockNakedSingleCell method.
     * @author Alexander Nikolov
     * @param grid The current grid to fill.
     * @param r The row.
     * @param c The column.
     */
    public void fillNakedSingle(Grid grid, int r, int c){
        boolean alreadyFoundOne = false;        //we only want to fill the first full house cell in case there are more than one.

                if (isBlockWithNakedSingleCell(grid, grid.getCell(r,c))&&!alreadyFoundOne){
                    Cell naked = getBlockNakedSingleCell(grid, grid.getCell(r,c));
                    naked.setValue(globalCandidateList[naked.getrIndex()-1][naked.getcIndex()-1].get(0)); //set its value to the only remaining candidate in its list.
                    alreadyFoundOne=true;

        }
    }

    /**
     * This method looks for the first unit in the grid with a full house cell and fills it using the getBlockNakedSingleCell method. A full house cell is also a naked single cell.
     * @author Alexander Nikolov
     * @param grid The current grid to fill.
     */
    public void fillFullHouse(Grid grid){
        boolean alreadyFoundOne = false;        //we only want to fill the first full house cell in case there are more than one.
        for (int r=1; r<10; r+=3){
            for (int c=1; c<10; c+=3){
                if (isFullHouseBlock(grid, grid.getCell(r,c))&&!alreadyFoundOne){
                   Cell naked = getBlockNakedSingleCell(grid, grid.getCell(r,c));       //the full house cell is also a naked cell, so use that method.
                   naked.setValue(globalCandidateList[naked.getrIndex()-1][naked.getcIndex()-1].get(0)); //set its value to the only remaining candidate in its list.
                           alreadyFoundOne=true;
                }
            }
        }
    }

    /**
     * This method stands for "Schritt 1" in the BlockBasedSolver pseudo-code and checks first whether the whole grid is valid. Then it checks if it is filled.
     * @author Alexander Nikolov
     * @param grid The current grid to check.
     * @return Returns true if the grid is both complete and valid.
     */
    public boolean completeAndValid (Grid grid){
    boolean result = true;
    for (int r = 1; r<10; r+=3){
        for (int c = 1; c<10; c+=3){
            if (!isValidBlock(grid, grid.getCell(r,c))) {    //if block valid
                result = false;
            }
        }
    }
    if (result==true){
        for (int row = 1; row < 10; row++) {
            for (int col = 1; col < 10; col++) {
                if (grid.getValue(row, col) == -1) {
                    return false;
                }
            }
        }
    }
    return result;
}
    /**
     * This method fills all the candidate lists for the empty cells with all the numbers 1-9. Then, by checking if a certain number k appears somewhere in the grid,
     * it removes the number k from the candidate lists of all the cells in the same row, column and block.
     * @author Alexander Nikolov
     * @param grid The current grid.
     * @return Returns the 81 candidate array lists in a two-dimensional array.
     */
    public List<Integer>[][] createGlobalList(Grid grid){

        for (int r = 0; r<9; r++){  //initialize every list with all the candidates 1-9
            for (int c = 0; c<9; c++) {
                globalCandidateList[r][c] = new ArrayList<Integer>();
                if(grid.getValue(r+1,c+1)==-1) {            //if the cell is empty, put all 9 candidates
                    for (int i = 0; i < 9; i++) { //go through the whole list of the cell
                        globalCandidateList[r][c].add(i + 1);
                    }
                }
            }
        }

        for (int k = 1; k<10; k++){             //the number to check for in the cells
            for (int r = 0; r<9; r++){
                for (int c = 0; c<9; c++){
                    if (grid.getValue(r+1,c+1)==k){
                        removeCandidatesSameRow (grid, r, k, globalCandidateList[r]);
                        removeCandidatesSameCol (grid, c, k, globalCandidateList);
                        removeCandidatesSameBlock (grid, r, c, k, globalCandidateList);


                    }
                }
            }
        }

        return globalCandidateList;
    }

    /**
     * Note: as of now not in use.
     * Called by the update method. The method goes through all the cells in the row where a cell is already populated with a number k and removes k from their candidate lists.
     * @author Alexander Nikolov
     * @param grid The current grid.
     * @param r The row to check.
     * @param k The number to look for in the candidate lists.
     * @param list A part of the global list for the row r.
     *
     */
    public void removeCandidatesSameRow (Grid grid, int r, int k, List<Integer> list[]){ //removes the candidate k from the cells on the same row
        for (int c = 0; c<9; c++){
            for (int n = 0; n<list[c].size(); n++) { //go through all the candidates
                if (list[c].get(n) == k){
                    list[c].remove(n);

                }
            }
        }

    }

    /**
     * Note: as of now not in use.
     * Called by the update method. The method goes through all the cells in the column where a cell is already populated with a number k and removes k from their candidate lists.
     * @author Alexander Nikolov
     * @param grid The current grid.
     * @param c The column to check.
     * @param k The number to look for in the candidate lists.
     * @param list Here the complete List is being passed on and the column is specified within the method
     *
     */
    public void removeCandidatesSameCol (Grid grid, int c, int k, List<Integer> list[][]){

        for (int r = 0; r<9; r++){
            for (int n = 0; n<list[r][c].size(); n++) { //go through all the candidates
                if (list[r][c].get(n) == k){
                    list[r][c].remove(n);

                }
            }
        }
    }

    /**
     * Note: as of now not in use.
     * The method goes through all the cells in the block where a cell is already populated with a number k and removes k from their candidate lists. It makes use
     * of the method getAnchorCoords, which helps identify the anchor cell of the block with which to initiate the check.
     * @author Alexander Nikolov
     * @param grid The current grid.
     * @param c The column to check.
     * @param r The column to check.
     * @param k The number to look for in the candidate lists.
     * @param list Here the complete List is being passed on and the column is specified within the method.
     *
     */
    public void removeCandidatesSameBlock (Grid grid, int r, int c, int k, List<Integer> list[][]){

        r = getAnchorCoords(r+1,c+1)[0]-1;
        c = getAnchorCoords(r+1,c+1)[1]-1;
        for (int row = r; row<r+3; row++){
            for (int col = c; col<c+3; col++){
                for (int n = 0; n<list[row][col].size(); n++) { //go through all the candidates
                    if (list[row][col].get(n) == k){
                        list[row][col].remove(n);

                    }
                }
            }
        }



    }

    /**
     * A support method which identifies the coordinates of the block anchor cell for any cell in the grid. E.g. if input=6,5, it will return the coordinates of the anchor, which is 4,4
     * @param r The row of the input cell.
     * @param c The column of the input cell.
     * @return The coordinates of the anchor cell.
     */

    public int[] getAnchorCoords (int r, int c){

        while ((r%3)!=1){
            r--;
        }
        while ((c%3)!=1){
            c--;
        }
        int[] result = new int[2];
        result[0]=r;
        result[1]=c;
        return result;
    }



  

}
