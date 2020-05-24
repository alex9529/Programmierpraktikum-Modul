package sample;

import com.company.BlockUtils;
import com.company.Handout;
import data.Cell;
import data.Grid;

public class handoutmain {

    public static void main(String[] args){


        Grid g1 = new Grid(9);
        int[] row1 = {-1,-1,-1,-1,-1,-1,3,-1,-1};
        int[] row2 = {-1,-1,-1,-1,7,1,5,-1,-1};
        int[] row3 = {-1,-1,2,4,-1,-1,-1,1,8};
        int[] row4 = {-1,-1,-1,-1,-1,9,-1,4,-1};
        int[] row5 = {-1,9,-1,6,1,8,2,3,-1};
        int[] row6 = {6,1,-1,7,-1,-1,-1,-1,-1};
        int[] row7 = {4,3,-1,8,-1,7,6,-1,-1};
        int[] row8 = {-1,-1,8,1,4,-1,-1,-1,-1};
        int[] row9 = {-1,-1,9,-1,-1,-1,-1,-1,-1};





        g1.setRowValues(1, row1);
        g1.setRowValues(2, row2);
        g1.setRowValues(3, row3);
        g1.setRowValues(4, row4);
        g1.setRowValues(5, row5);
        g1.setRowValues(6, row6);
        g1.setRowValues(7, row7);
        g1.setRowValues(8, row8);
        g1.setRowValues(9, row9);
        BlockUtils h = new BlockUtils();


        for (int r = 1; r < 9 + 1; r++) {
            for (int c = 1; c < 9 + 1; c++) {
                if (g1.getValue(r, c) > 0) {
                    System.out.print(" " + g1.getValue(r, c) + " ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
        System.out.println();



        BlockUtils b = new BlockUtils();
        Grid oG=  b.copyGrid(g1);

        Cell[] case3 = new Cell[5];
        case3[0] = new Cell(1, 4);
        case3[1] = new Cell(1, 7);
        case3[2] = new Cell(1, 1);
        case3[3] = new Cell(4, 4);
        case3[4] = new Cell(7, 4);

        Cell[] case2 = new Cell[5];
        case2[0] = new Cell(7, 1);
        case2[1] = new Cell(7, 4);
        case2[2] = new Cell(7, 7);
        case2[3] = new Cell(1, 1);
        case2[4] = new Cell(4, 1);
        b.applyBlockPermutation(g1, case2);


        //Output of the grid
        for (int r = 1; r < 9 + 1; r++) {
            for (int c = 1; c < 9 + 1; c++) {
                if (g1.getValue(r, c) > 0) {
                    System.out.print(" " + g1.getValue(r, c)+" ");
                }
                else {
                    System.out.print( " _ ");
                }
            }
            System.out.println();

        }




        System.out.println("grid2 is a result of a permutation of grid1: "
                + b.getBlockPermutationImage(oG,g1)[0].getrIndex()
                + b.getBlockPermutationImage(oG,g1)[0].getcIndex()
                +" "
                + b.getBlockPermutationImage(oG,g1)[1].getrIndex()
                + b.getBlockPermutationImage(oG,g1)[1].getcIndex()
                +" "
                + b.getBlockPermutationImage(oG,g1)[2].getrIndex()
                + b.getBlockPermutationImage(oG,g1)[2].getcIndex()
                +" "
                + b.getBlockPermutationImage(oG,g1)[3].getrIndex()
                + b.getBlockPermutationImage(oG,g1)[3].getcIndex()
                +" "
                + b.getBlockPermutationImage(oG,g1)[4].getrIndex()
                + b.getBlockPermutationImage(oG,g1)[4].getcIndex()
        );



    }
}
