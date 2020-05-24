


import java.util.List;

import com.company.BlockUtils;
import com.company.GridUtils1;

import data.Cell;
import data.Grid;


public class App {
	//Test-marker

    public static void main(String[] args) {
        Grid g = new Grid(9);
       /* g.setValue(1, 1, 1);
        g.setValue(2, 1, 2);
        g.setValue(3, 1, 3);
        g.setValue(4, 1, 4);
        g.setValue(5, 1, 5);
        g.setValue(6, 1, 6);
        g.setValue(3, 3, 5);


        g.setValue(7, 4, 9);
        g.setValue(6, 3, 9);

        g.setValue(9, 9, 1);
        g.setValue(9, 8, 2);
        g.setValue(9, 7, 3);
        g.setValue(9, 6, 4);
        g.setValue(9, 5, 5);
        g.setValue(9, 4, 6);

        g.setValue(1, 4, 8);
        g.setValue(2, 4, 8);
        g.setValue(3, 4, 8);
        g.setValue(4, 4, 8);
        g.setValue(5, 4, 8);
        g.setValue(6, 4, 8);

        g.setValue(1, 5, 7);
        g.setValue(2, 5, 7);
        g.setValue(3, 5, 7);
        g.setValue(4, 5, 7);
        g.setValue(5, 5, 7);
        g.setValue(6, 5, 7);

        g.setValue(1, 6, 9);
        g.setValue(2, 6, 9);
        g.setValue(3, 6, 9);
        g.setValue(4, 6, 9);
        g.setValue(5, 6, 9);
        g.setValue(6, 6, 9);



        /**g.setValue(4, 1, 1);
        g.setValue(4, 2, 2);
        g.setValue(4, 3, 3);
        g.setValue(5, 1, 4);
        g.setValue(5, 2, 5);
        g.setValue(5, 3, 6);
        g.setValue(6, 1, 7);
        g.setValue(6, 2, 8);
        g.setValue(6, 3, 9);

        g.setValue(1, 4, 1);
        g.setValue(1, 5, 2);
        g.setValue(1, 6, 3);
        g.setValue(2, 4, 4);
        g.setValue(2, 5, 5);
        g.setValue(2, 6, 6);
        g.setValue(3, 4, 7);
        g.setValue(3, 5, 8);
        g.setValue(3, 6, 9);
         */






        //macht man das so? ja, da projektvorgegeben. Sonst koennte man die Methode static machen (und auch das interface BlockIsoUtil) und man braeuchte kein Objekt mehr zu erstellen
        BlockUtils b = new BlockUtils(); //Methodenaufruf wuerde dann einfach lauten: BlockUtils.applyBlockPermutation. Static geht dann nur, wenn die Klasse keine Attributen enthaelt.











        //Test method hasFullHouseBlock
        //System.out.println("Grid has a full house Block: " + b.hasFullHouseBlock(g));

        //System.out.println("Is a valid block: "+b.isValidBlock(g, g.getCell(1,4)));

        /**Test for getBlockWhiteSpaces
        List<Cell> list = b.getBlockWhiteSpaces(g, g.getCell(1,1));
        for (int i = 0; i<list.size(); i++) {

            System.out.print(list.get(i).getrIndex() + ",");
            System.out.print(list.get(i).getcIndex()+"|");

        }*/


        /**Test for isBlockWithNakedSingleCell
       System.out.println("Block with nakedsingle cell: " + b.isBlockWithNakedSingleCell(g, g.getCell(4,1)));

        //Test for getNakedSingleCell
        try {
            System.out.println("Naked single Cell is "+b.getBlockNakedSingleCell(g, g.getCell(4,1)).getrIndex()+"," +b.getBlockNakedSingleCell(g, g.getCell(4,1)).getcIndex());
        }
        catch (NullPointerException e){
            System.out.println("This block does not have a naked single cell.");
        }


        System.out.println("Block 7,7 has a hidden single cell" +b.isBlockWithHiddenSingleCell(g, g.getCell(7,7)));
        System.out.println("and the cell has the coordinates: "+ b.getBlockMinimalHiddenSingleCell(g, g.getCell(7,7)).getrIndex()+","+b.getBlockMinimalHiddenSingleCell(g, g.getCell(7,7)).getcIndex());

        //Test getMinimalHiddenCell
        Cell test = b.getBlockMinimalHiddenSingleCell(g, g.getCell(1,1));
        System.out.print(test.getrIndex());
        System.out.println(test.getcIndex());
        */



        //test getBlockNakedPairCells

        /*try {
            System.out.println("Block 7,1 has a naked pair: "
                    + b.getBlockNakedPairCells(g, g.getCell(7, 1))[0].getrIndex()
                    + b.getBlockNakedPairCells(g, g.getCell(7, 1))[0].getcIndex()
                    + " and "
                    + b.getBlockNakedPairCells(g, g.getCell(7, 1))[1].getrIndex()
                    + b.getBlockNakedPairCells(g, g.getCell(7, 1))[1].getcIndex());
        }
        catch (Exception e){
            System.out.println("kein naked cell paar vorhanden.");
        }


*/





        Grid g1 = new Grid(9);

        //Sudoku with full House at 1,7
        /*int[] row1 = {-1,3,-1,7,5,4,2,8,6};
        int[] row2 = {-1,8,-1,-1,-1,1,4,5,7};
        int[] row3 = {7,4,5,-1,8,2,-1,9,1};
        int[] row4 = {3,-1,4,8,2,-1,6,-1,-1};
        int[] row5 = {-1,7,8,-1,-1,-1,-1,-1,2};
        int[] row6 = {-1,9,2,-1,-1,5,1,3,-1};
        int[] row7 = {-1,-1,7,-1,1,-1,-1,2,-1};
        int[] row8 = {4,-1,-1,5,-1,-1,-1,6,3};
        int[] row9 = {8,5,3,2,-1,-1,-1,1,-1};
*/

        //Test Sudoku not using pairs
        int[] row1 = {-1,-1,-1,-1,-1,-1,3,-1,-1};
        int[] row2 = {-1,-1,-1,-1,7,1,5,-1,-1};
        int[] row3 = {-1,-1,2,4,-1,-1,-1,1,8};
        int[] row4 = {-1,-1,-1,-1,-1,9,-1,4,-1};
        int[] row5 = {-1,9,-1,6,1,8,2,3,-1};
        int[] row6 = {6,1,-1,7,-1,-1,-1,-1,-1};
        int[] row7 = {4,3,-1,8,-1,7,6,-1,-1};
        int[] row8 = {-1,-1,8,1,4,-1,-1,-1,-1};
        int[] row9 = {-1,-1,9,-1,-1,-1,-1,-1,-1};



    //hidden pair
      /*  int[] row1 = {-1,-1,-1,-1,1,2,-1,-1,-1};
        int[] row2 = {-1,-1,-1,-1,-1,-1,2,1,-1};
        int[] row3 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row4 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row5 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row6 = {-1,-1,1,-1,-1,-1,-1,-1,-1};
        int[] row7 = {-1,-1,2,-1,-1,-1,-1,-1,-1};
        int[] row8 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row9 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
*/
       /*
        int[] row1 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row2 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row3 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row4 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row5 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row6 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row7 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row8 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] row9 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

*/



        g1.setRowValues(1, row1);
        g1.setRowValues(2, row2);
        g1.setRowValues(3, row3);
        g1.setRowValues(4, row4);
        g1.setRowValues(5, row5);
        g1.setRowValues(6, row6);
        g1.setRowValues(7, row7);
        g1.setRowValues(8, row8);
        g1.setRowValues(9, row9);






        /*System.out.println("Block has a hidden pair: "
                + b.isBlockWithHiddenPair(g1, g1.getCell(1,1)));

        try {
            System.out.println("Hidden pair: "
                    + b.getBlockHiddenPairCells(g1, g1.getCell(1, 1))[0].getrIndex()
                    + b.getBlockHiddenPairCells(g1, g1.getCell(1, 1))[0].getcIndex()
                    + " and "
                    + b.getBlockHiddenPairCells(g1, g1.getCell(1, 1))[1].getrIndex()
                    + b.getBlockHiddenPairCells(g1, g1.getCell(1, 1))[1].getcIndex());
        }
        catch (Exception e){
            System.out.println("kein hidden cell paar vorhanden.");
        }
        */




        GridUtils1 b1 = new GridUtils1();
      //  b1.transponse(g);




       //System.out.println("Tg is transposition of g? "+ b1.isTransposition(g, g1));

      //int[] valueP = {9,9,9,-1,-1,-1,9,9,9};
        //b.applyBlockValuePermutation(g1, g1.getCell(1,1), valueP );




        //System.out.println("g1 is a value permutation of g2: "+ b.isBlockValuePermutation(g,g1,g.getCell(1,1)));



   /* int[] vP = b.getBlockValuePermutationImage(g,g1,g.getCell(7,4));
        System.out.println("get value permutation image " + vP[0]);
        System.out.println("get value permutation image " + vP[1]);
        System.out.println("get value permutation image " + vP[2]);
        System.out.println("get value permutation image " + vP[3]);
        System.out.println("get value permutation image " + vP[4]);
        System.out.println("get value permutation image " + vP[5]);
        System.out.println("get value permutation image " + vP[6]);
        System.out.println("get value permutation image " + vP[7]);
        System.out.println("get value permutation image " + vP[8]);



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
        System.out.println("___");
        //test isBlockWithNakedPair
//System.out.println("Block has a hidden single: " + b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(1,1)).getrIndex()+
//        b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(1,1)).getcIndex());



        //System.out.println("Block has a naked pair: " + b.getBlockNakedPairCells(g1, g1.getCell(1,1))[0].getrIndex()
        //+b.getBlockNakedPairCells(g1, g1.getCell(1,1))[0].getcIndex());



/*


*/




        /*System.out.print(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(1,4)).getrIndex());
        System.out.println(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(1,4)).getcIndex());


        System.out.print(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(4,4)).getrIndex());
        System.out.println(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(4,4)).getcIndex());

        System.out.print(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(4,7)).getrIndex());
        System.out.println(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(4,7)).getcIndex());

        System.out.print(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(7,4)).getrIndex());
        System.out.println(b.getBlockMinimalHiddenSingleCell(g1, g1.getCell(7,4)).getcIndex());
*/

        //SOLVER
        /*List<Grid> grids = b.solveBlockBased(g1);
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


        System.out.println("Durchlaeufe: " + grids.size());
      */






/*





     System.out.println("Apply block permutation");
     for (int r = 1; r < 9 + 1; r++) {
         for (int c = 1; c < 9 + 1; c++) {
             if (g3.getValue(r, c) > 0) {
                 System.out.print(" " + g3.getValue(r, c)+" ");
             }
             else {
                 System.out.print( " _ ");
             }
         }
         System.out.println();

     }





     Grid g4 = b.copyGrid(g3);
     b1.transponse(g4);
     System.out.println("Transpose: ");
     for (int r = 1; r < 9 + 1; r++) {
         for (int c = 1; c < 9 + 1; c++) {
             if (g4.getValue(r, c) > 0) {
                 System.out.print(" " + g4.getValue(r, c)+" ");
             }
             else {
                 System.out.print( " _ ");
             }
         }
         System.out.println();

     }

     System.out.println("g4 is a transposition of g3: "+b1.isTransposition(g3, g4));


     System.out.println("g1 is valid and complete: "+ b.completeAndValid(g1));

     System.out.println(b.getBlockWhiteSpaces(g3,g3.getCell(1, 1)));

     g1.setValue(1, 1, -1);
     g1.setValue(1, 2, -1);

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
     System.out.println("__");

     Grid g10 = b.copyGrid(g1);

     Cell[] image = new Cell[5];
     image[0] = new Cell(7, 1);
     image[1] = new Cell(7, 4);
     image[2] = new Cell(7, 7);
     image[3] = new Cell(1, 1);
     image[4] = new Cell(4, 1);

     int[] valueP = {9,8,7,-1,5,4,-1,2,1};

     b.applyBlockValuePermutation(g1, g1.getCell(1, 1), valueP);


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

     System.out.println("has a naked pair: "+b.isBlockWithNakedPair(g1, g1.getCell(1, 1)));




     Grid gTestPairs = new Grid(9);
     gTestPairs.setValue(4, 1, 2);
     gTestPairs.setValue(5, 1, 3);
     gTestPairs.setValue(1, 4, 2);
     gTestPairs.setValue(1, 5, 3);
     gTestPairs.setValue(2, 7, 2);
     gTestPairs.setValue(2, 8, 3);

     for (int r = 1; r < 9 + 1; r++) {
         for (int c = 1; c < 9 + 1; c++) {
             if (gTestPairs.getValue(r, c) > 0) {
                 System.out.print(" " + gTestPairs.getValue(r, c)+" ");
             }
             else {
                 System.out.print( " _ ");
             }
         }
         System.out.println();

     }

     System.out.println(b.getBlockHiddenPairCells(gTestPairs, gTestPairs.getCell(1, 1))[0].getcIndex());

*/




        //Test Sudoku not using pairs
        Grid originalGrid = new Grid(9);


        //Test für Naked Single Case_4 //Ausgabe richtig
        int[] row11 = {4, 8, 9, 3, 1, 5, 2, 6, 7};
        int[] row21 = {1, 6, -1, 4, 9, 7, 3, 5, 8};
        int[] row31 = {3, 5, 7, 2, 8, 6, 9, 1, -1};
        int[] row41 = {8, -1, 5, 6, 3, 1, 4, 7, 2};
        int[] row51 = {6, 2, 1, 7, -1, 8, 5, 9, 3};
        int[] row61 = {7, 4, 3, 5, 2, 9, 1, 8, 6};
        int[] row71 = {9, 1, 4, 8, 7, 3, 6, 2, 5};
        int[] row81 = {2, 7, 6, 1, 5, 4, 8, 3, 9};
        int[] row91 = {-1, 3, -1, 9, 6, 2, 7, -1, 1};

        /*
        //Test für Naked Single Case_3 //Ausgabe richtig
        int[] row11 = {-1, 2, -1, -1, -1, -1, -1, -1, -1};
        int[] row21 = {-1, -1, 3, -1, -1, -1, -1, -1, 1};
        int[] row31 = {4, 5, 6, -1, -1, -1, -1, -1, 2};
        int[] row41 = {7, -1, -1, -1, -1, -1, -1, -1, 3};
        int[] row51 = {8, -1, -1, -1, -1, -1, -1, -1, 4};
        int[] row61 = {9, -1, -1, -1, -1, -1, -1, -1, 5};
        int[] row71 = {-1, 6, 9, -1, -1, -1, -1, -1, 6};
        int[] row81 = {1, -1, 2, 3, -1, -1, -1, -1, 7};
        int[] row91 = {-1, 4, 7, -1, -1, -1, -1, -1, 8};



*/

        //Test für Naked Single Case_1 //Ausgabe Stimmt
       /*int[] row11 = {4, 1, 2, 7, 3, 6, 5, 8, 9};
        int[] row21 = {-1, -1, -1, -1, -1, -1, 1, -1, 6};
        int[] row31 = {5, 6, 8, -1, 1, -1, 3, 7, -1};
        int[] row41 = {-1, -1, -1, 8, 5, -1, 2, 1, -1};
        int[] row51 = {1, -1, -1, -1, -1, -1, -1, -1, 8};
        int[] row61 = {-1, 8, 7, -1, 9, -1, -1, -1, -1};
        int[] row71 = {-1, 3, -1, -1, 7, -1, 8, 6, 5};
        int[] row81 = {8, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] row91 = {-1, -1, -1, 9, -1, 8, 4, -1, 1};
        */

        //Test für Naked Single Case_2 //Ausgabe stimmt
       /*int[] row11 = {-1, 1, -1, 9, -1, -1, 7, 4, -1};
        int[] row21 = {-1, -1, -1, 8, -1, -1, -1, -1, 3};
        int[] row31 = {-1, 7, -1, 3, 2, -1, 6, 9, -1};
        int[] row41 = {-1, -1, 4, -1, 3, -1, 2, -1, -1};
        int[] row51 = {-1, -1, -1, 6, -1, 2, -1, -1, -1};
        int[] row61 = {-1, -1, 8, -1, 1, -1, 3, -1, -1};
        int[] row71 = {-1, 8, 1, -1, 7, -1, -1, 3, -1};
        int[] row81 = {3, -1, -1, -1, -1, 8, -1, -1, -1};
        int[] row91 = {-1, 6, 9, -1, -1, 3, -1, 2, -1};
*/
        originalGrid.setRowValues(1, row11);
        originalGrid.setRowValues(2, row21);
        originalGrid.setRowValues(3, row31);
        originalGrid.setRowValues(4, row41);
        originalGrid.setRowValues(5, row51);
        originalGrid.setRowValues(6, row61);
        originalGrid.setRowValues(7, row71);
        originalGrid.setRowValues(8, row81);
        originalGrid.setRowValues(9, row91);


        //Output of the grid
        for (int r = 1; r < 9 + 1; r++) {
            for (int c = 1; c < 9 + 1; c++) {
                if (originalGrid.getValue(r, c) > 0) {
                    System.out.print(" " + originalGrid.getValue(r, c)+" ");
                }
                else {
                    System.out.print( " _ ");
                }
            }
            System.out.println();

            }

        //Test for getNakedSingleCell
        try {
            System.out.println("Naked single Cell is "+b.getBlockNakedSingleCell(originalGrid, originalGrid.getCell(1,1)).getrIndex()+
                    "," +b.getBlockNakedSingleCell(originalGrid, originalGrid.getCell(1,1)).getcIndex());
        }
        catch (NullPointerException e){
            System.out.println("This block does not have a naked single cell.");
        }


        System.out.println();




        Grid oG=  b.copyGrid(g1);

        //Output of the grid
        for (int r = 1; r < 9 + 1; r++) {
            for (int c = 1; c < 9 + 1; c++) {
                if (oG.getValue(r, c) > 0) {
                    System.out.print(" " + oG.getValue(r, c)+" ");
                }
                else {
                    System.out.print( " _ ");
                }
            }
            System.out.println();
        }
        System.out.println();

        Cell[] image = new Cell[5];
        image[0] = new Cell(1, 4);
        image[1] = new Cell(1, 7);
        image[2] = new Cell(1, 1);
        image[3] = new Cell(4, 4);
        image[4] = new Cell(7, 4);
        b.applyBlockPermutation(g1, image);


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
