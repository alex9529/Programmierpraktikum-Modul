import com.company.BlockUtils;
import com.company.GridUtils1;
import com.company.PuzzleBlock;
import data.Cell;
import data.Grid;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		Grid g = new Grid(9);
		Grid g1 = new Grid(9);
		Grid g2 = new Grid(9);
		Grid g3 = new Grid(9);

		// Grid with naked single cell and a hidden single cell
		int[] row1 = { 1, -1, -1, -1, 7, 9, -1, -1, -1 };
		int[] row2 = { 4, -1, -1, 5, 6, 2, -1, -1, -1 };
		int[] row3 = { 3, -1, 5, 8, 4, 1, 2, -1, -1 };
		int[] row4 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] row5 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] row6 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] row7 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] row8 = { -1, -1, 2, -1, -1, -1, -1, -1, -1 };
		int[] row9 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };

		g.setRowValues(1, row1);
		g.setRowValues(2, row2);
		g.setRowValues(3, row3);
		g.setRowValues(4, row4);
		g.setRowValues(5, row5);
		g.setRowValues(6, row6);
		g.setRowValues(7, row7);
		g.setRowValues(8, row8);
		g.setRowValues(9, row9);

		// Grid with a naked pair
		int[] row11 = { 1, -1, -1, -1, -1, -1, -1, -1, 4 };
		int[] row22 = { 2, -1, -1, 1, -1, -1, -1, -1, 5 };
		int[] row33 = { 3, -1, -1, -1, -1, -1, 1, -1, 6 };
		int[] row44 = { 4, 1, -1, -1, -1, -1, -1, -1, -1 };
		int[] row55 = { 5, 7, -1, -1, 1, -1, -1, -1, -1 };
		int[] row66 = { 6, -1, -1, 8, -1, -1, -1, 1, -1 };
		int[] row77 = { 9, 2, 1, -1, -1, -1, -1, 8, -1 };
		int[] row88 = { -1, -1, -1, -1, 3, 1, -1, -1, 9 };
		int[] row99 = { -1, -1, -1, 1, 2, 3, -1, -1, -1 };

		g1.setRowValues(1, row11);
		g1.setRowValues(2, row22);
		g1.setRowValues(3, row33);
		g1.setRowValues(4, row44);
		g1.setRowValues(5, row55);
		g1.setRowValues(6, row66);
		g1.setRowValues(7, row77);
		g1.setRowValues(8, row88);
		g1.setRowValues(9, row99);

		// Grid with a hidden pair
		int[] row111 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] row222 = { -1, -1, -1, 1, -1, -1, -1, -1, -1 };
		int[] row333 = { -1, -1, -1, -1, -1, -1, 1, -1, 9 };
		int[] row444 = { -1, 1, -1, -1, -1, -1, -1, -1, -1 };
		int[] row555 = { -1, -1, -1, -1, 1, -1, -1, -1, -1 };
		int[] row666 = { -1, -1, -1, -1, -1, -1, -1, 1, 8 };
		int[] row777 = { -1, 9, 1, -1, 8, -1, -1, -1, -1 };
		int[] row888 = { -1, 8, -1, -1, 9, 1, -1, -1, -1 };
		int[] row999 = { 7, 6, 5, -1, -1, -1, -1, -1, -1 };

		g2.setRowValues(1, row111);
		g2.setRowValues(2, row222);
		g2.setRowValues(3, row333);
		g2.setRowValues(4, row444);
		g2.setRowValues(5, row555);
		g2.setRowValues(6, row666);
		g2.setRowValues(7, row777);
		g2.setRowValues(8, row888);
		g2.setRowValues(9, row999);

		// Create an instance of the class (method not static since dictated by the
		// assignment)
		BlockUtils b = new BlockUtils();

		// Output of the three grids in the console
		System.out.println("Sample grid with a naked single and a hidden single:");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (g.getValue(r, c) > 0) {
					System.out.print(" " + g.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Sample grid with a naked pair:");
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

		System.out.println("Sample grid with a hidden pair:");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (g2.getValue(r, c) > 0) {
					System.out.print(" " + g2.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();

		// Test method hasFullHouseBlock
		System.out.println("Grid 1 has a full house Block: " + b.hasFullHouseBlock(g));

		System.out.println("Block with anchor cell 1,4 in grid 1 is a valid block: " + b.isValidBlock(g, g.getCell(1, 4)));

		// Test for getBlockWhiteSpaces
		List<Cell> list = b.getBlockWhiteSpaces(g, g.getCell(1, 1));

		System.out.println("The block at 1,1 in the first grid contains the following white spaces:");
		for (int i = 0; i < list.size(); i++) {

			System.out.print(list.get(i).getrIndex() + ",");
			System.out.print(list.get(i).getcIndex() + "|");

		}
		System.out.println();
		System.out.println();

		// An image is used to perform a shuffle on the entire grid. 5 coordinates (5
		// cells as seen below) are needed to describe an unambiguous permutation.
		// In this image, the blocks are instructed to move horizontally 3 cells to the
		// left.
		Cell[] image = new Cell[5];
		image[0] = new Cell(1, 4);
		image[1] = new Cell(1, 7);
		image[2] = new Cell(1, 1);
		image[3] = new Cell(4, 4);
		image[4] = new Cell(7, 4);

		// Apply a permutation using the created image
		b.applyBlockPermutation(g, image);

		// Output of the grid in the console
		System.out.println("Grid 1 after the block permutation:");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (g.getValue(r, c) > 0) {
					System.out.print(" " + g.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();

		// Test for isBlockWithNakedSingleCell
		System.out.println(
				"Block with anchor cell 1,1 in Grid 1 has a naked single cell: " + b.isBlockWithNakedSingleCell(g, g.getCell(1, 1)));

		// Test for getNakedSingleCell
		try {
			System.out.println(
					"Naked single Cell in Grid 1 is " + b.getBlockNakedSingleCell(g, g.getCell(1, 1)).getrIndex() + ","
							+ b.getBlockNakedSingleCell(g, g.getCell(1, 1)).getcIndex());
		} catch (NullPointerException e) {
			System.out.println("This block in Grid 1 does not have a naked single cell.");
		}

		// Test getMinimalHiddenCell
		try {
			System.out.println("Block with anchor cell 1,7 in Grid 1 has a hidden single cell: "
					+ b.isBlockWithHiddenSingleCell(g, g.getCell(1, 7)));
			System.out.println("and the cell has the coordinates: "
					+ b.getBlockMinimalHiddenSingleCell(g, g.getCell(1, 7)).getrIndex() + ","
					+ b.getBlockMinimalHiddenSingleCell(g, g.getCell(1, 7)).getcIndex());
		} catch (NullPointerException e1) {

			System.out.println("This block in Grid 1 does not have a hidden single cell.");
		}

		// test getBlockNakedPairCells
		try {
			System.out.println("Block with anchor cell 7,1 in Grid 2 has a naked pair with coordinates: "
					+ b.getBlockNakedPairCells(g1, g1.getCell(7, 1))[0].getrIndex() + ","
					+ b.getBlockNakedPairCells(g1, g1.getCell(7, 1))[0].getcIndex() + " and "
					+ b.getBlockNakedPairCells(g1, g1.getCell(7, 1))[1].getrIndex() + ","
					+ b.getBlockNakedPairCells(g1, g1.getCell(7, 1))[1].getcIndex());
		} catch (Exception e) {
			System.out.println("No naked cell pair in grid 2.");
		}

		// Test Sudoku 1 not using pairs
		/*
		 * int[] row1 = {-1,-1,-1,-1,-1,-1,3,-1,-1}; int[] row2 =
		 * {-1,-1,-1,-1,7,1,5,-1,-1}; int[] row3 = {-1,-1,2,4,-1,-1,-1,1,8}; int[] row4
		 * = {-1,-1,-1,-1,-1,9,-1,4,-1}; int[] row5 = {-1,9,-1,6,1,8,2,3,-1}; int[] row6
		 * = {6,1,-1,7,-1,-1,-1,-1,-1}; int[] row7 = {4,3,-1,8,-1,7,6,-1,-1}; int[] row8
		 * = {-1,-1,8,1,4,-1,-1,-1,-1}; int[] row9 = {-1,-1,9,-1,-1,-1,-1,-1,-1};
		 */

		// Test Sudoku 2 not using pairs
		/*
		 * int[] row1 = {-1,9,-1,1,-1,8,-1,7,-1}; int[] row2 =
		 * {-1,-1,2,-1,-1,-1,3,-1,-1}; int[] row3 = {-1,6,-1,-1,-1,-1,-1,9,-1}; int[]
		 * row4 = {-1,-1,7,9,-1,6,5,-1,-1}; int[] row5 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 * int[] row6 = {-1,-1,4,3,-1,7,2,-1,-1}; int[] row7 =
		 * {-1,5,-1,-1,-1,-1,-1,2,-1}; int[] row8 = {-1,-1,3,-1,-1,-1,8,-1,-1}; int[]
		 * row9 = {-1,1,-1,5,-1,9,-1,6,-1};
		 */

		/*
		 * int[] row1 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row2 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row3 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 * int[] row4 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row5 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row6 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 * int[] row7 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row8 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row9 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 */

		// hidden pair
		/*
		 * int[] row1 = {-1,-1,-1,-1,1,2,-1,-1,-1}; int[] row2 =
		 * {-1,-1,-1,-1,-1,-1,2,1,-1}; int[] row3 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[]
		 * row4 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row5 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row6 = {-1,-1,1,-1,-1,-1,-1,-1,-1}; int[]
		 * row7 = {-1,-1,2,-1,-1,-1,-1,-1,-1}; int[] row8 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row9 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 */
		/*
		 * int[] row1 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row2 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row3 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 * int[] row4 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row5 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row6 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 * int[] row7 = {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row8 =
		 * {-1,-1,-1,-1,-1,-1,-1,-1,-1}; int[] row9 = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		 * 
		 */

		System.out.println("Block with anchor cell 7,7 in grid 3 has a hidden pair: "
				+ b.isBlockWithHiddenPair(g2, g2.getCell(7, 7)));

		try {
			System.out.println("Hidden pair coordinates: " + b.getBlockHiddenPairCells(g2, g2.getCell(7, 7))[0].getrIndex() + ","
					+ b.getBlockHiddenPairCells(g2, g2.getCell(7, 7))[0].getcIndex() + " and "
					+ b.getBlockHiddenPairCells(g2, g2.getCell(7, 7))[1].getrIndex() + ","
					+ b.getBlockHiddenPairCells(g2, g2.getCell(7, 7))[1].getcIndex());
		} catch (Exception e) {
			System.out.println("No hidden cell pair available.");
		}

		GridUtils1 b1 = new GridUtils1();
		b1.transponse(g);

		Grid tg = new Grid(9);
		// Transposing grid
		int[] trow1 = { -1, 7, 9, -1, -1, -1, 1, -1, -1 };
		int[] trow2 = { 5, 6, 2, -1, -1, -1, 4, -1, -1 };
		int[] trow3 = { 8, 4, 1, 2, -1, -1, 3, -1, 5 };
		int[] trow4 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] trow5 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] trow6 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] trow7 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] trow8 = { -1, -1, -1, -1, -1, -1, -1, -1, 2 };
		int[] trow9 = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };

		tg.setRowValues(1, trow1);
		tg.setRowValues(2, trow2);
		tg.setRowValues(3, trow3);
		tg.setRowValues(4, trow4);
		tg.setRowValues(5, trow5);
		tg.setRowValues(6, trow6);
		tg.setRowValues(7, trow7);
		tg.setRowValues(8, trow8);
		tg.setRowValues(9, trow9);

		System.out.println();
		System.out.println("Original grid:");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (tg.getValue(r, c) > 0) {
					System.out.print(" " + tg.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Original grid transposed:");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (g.getValue(r, c) > 0) {
					System.out.print(" " + g.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Check: Is tg (the transposed g) a transposition of g? " + b1.isTransposition(g, tg));

		int[] valueP = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		b.applyBlockValuePermutation(g, g.getCell(1, 1), valueP);

		//Block value permutation
		System.out.println();
		System.out.println(
				"First grid after transpose and after block value permutation (on block with anchor cells 1,1):");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (g.getValue(r, c) > 0) {
					System.out.print(" " + g.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();

		// transpose tg so it matches g
		b1.transponse(tg);

		System.out.println("Check: is pg (the permutated g) a permutation of g? "
				+ b.isBlockValuePermutation(g, tg, g.getCell(1, 1)));

		int[] vP = b.getBlockValuePermutationImage(g, tg, g.getCell(1, 1));
		
		System.out.println();
		System.out.println("Extract the permutation image that permutated g: ");
		System.out.println("1 is replaced with " + vP[0]);
		System.out.println("2 is replaced with " + vP[1]);
		System.out.println("3 is replaced with " + vP[2]);
		System.out.println("4 is replaced with " + vP[3]);
		System.out.println("5 is replaced with " + vP[4]);
		System.out.println("6 is replaced with " + vP[5]);
		System.out.println("-1 (blank) is replaced with " + vP[6]);
		System.out.println("8 is replaced with " + vP[7]);
		System.out.println("9 is replaced with " + vP[8]);

		
		Grid gridToSolve = new Grid(9);
		  //Test Sudoku to solve
        int[] r1 = {-1,-1,-1,-1,-1,-1,3,-1,-1};
        int[] r2 = {-1,-1,-1,-1,7,1,5,-1,-1};
        int[] r3 = {-1,-1,2,4,-1,-1,-1,1,8};
        int[] r4 = {-1,-1,-1,-1,-1,9,-1,4,-1};
        int[] r5 = {-1,9,-1,6,1,8,2,3,-1};
        int[] r6 = {6,1,-1,7,-1,-1,-1,-1,-1};
        int[] r7 = {4,3,-1,8,-1,7,6,-1,-1};
        int[] r8 = {-1,-1,8,1,4,-1,-1,-1,-1};
        int[] r9 = {-1,-1,9,-1,-1,-1,-1,-1,-1};

        gridToSolve.setRowValues(1, r1);
        gridToSolve.setRowValues(2, r2);
        gridToSolve.setRowValues(3, r3);
        gridToSolve.setRowValues(4, r4);
        gridToSolve.setRowValues(5, r5);
        gridToSolve.setRowValues(6, r6);
        gridToSolve.setRowValues(7, r7);
        gridToSolve.setRowValues(8, r8);
        gridToSolve.setRowValues(9, r9);
        
        System.out.println();
        System.out.println(
				"Grid to be solved");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (gridToSolve.getValue(r, c) > 0) {
					System.out.print(" " + gridToSolve.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		List<Grid> grids = b.solveBlockBased(gridToSolve);
		Grid solved = grids.get(grids.size() - 1);
		Grid initial = grids.get(0);
		
		System.out.println(
				"Solved grid");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (gridToSolve.getValue(r, c) > 0) {
					System.out.print(" " + gridToSolve.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();
		


		System.out.println("Iterations until grid solved: " + grids.size());

		PuzzleBlock p1 = new PuzzleBlock();
		// Grid conflictFree = p1.getBlockConflictFree(g1);

		List<Integer> permutationOfBlocks = new ArrayList<>();
		permutationOfBlocks.add(3);
		permutationOfBlocks.add(7);
		permutationOfBlocks.add(5);
		permutationOfBlocks.add(6);
		permutationOfBlocks.add(1);
		permutationOfBlocks.add(8);
		permutationOfBlocks.add(0);
		permutationOfBlocks.add(4);
		permutationOfBlocks.add(2);

		Grid testGrid = new Grid(9);

		int[] col1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int[] col2 = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
		int[] col3 = { 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		int[] col4 = { 4, 4, 4, 4, 4, 4, 4, 4, 4 };
		int[] col5 = { 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		int[] col6 = { 6, 6, 6, 6, 6, 6, 6, 6, -1 };
		int[] col7 = { 7, 7, 7, 7, 7, 7, 7, 7, 7 };
		int[] col8 = { 8, 8, 8, 8, 8, 8, 8, 8, 8 };
		int[] col9 = { 9, 9, 9, 9, 9, 9, 9, 9, 9 };

		testGrid.setRowValues(1, col1);
		testGrid.setRowValues(2, col2);
		testGrid.setRowValues(3, col3);
		testGrid.setRowValues(4, col4);
		testGrid.setRowValues(5, col5);
		testGrid.setRowValues(6, col6);
		testGrid.setRowValues(7, col7);
		testGrid.setRowValues(8, col8);
		testGrid.setRowValues(9, col9);

		// solved = p1.constructGrid(solved, permutationOfBlocks);

		Grid bla = new Grid(9);
		Grid putNumberColRow = new Grid(9);

		putNumberColRow.setValue(1, 1, 1);
		putNumberColRow.setValue(2, 2, 2);
		putNumberColRow.setValue(6, 2, 1);
		putNumberColRow.setValue(3, 3, 7);
		putNumberColRow.setValue(7, 3, 1);
		putNumberColRow.setValue(8, 3, 4);
		putNumberColRow.setValue(3, 4, 7);
		putNumberColRow.setValue(3, 5, 7);
		putNumberColRow.setValue(4, 5, 1);
		putNumberColRow.setValue(5, 5, 3);
		putNumberColRow.setValue(8, 7, 8);
		putNumberColRow.setValue(2, 8, 1);
		putNumberColRow.setValue(5, 9, 1);

		Grid hard2 = new Grid(9);
		hard2.setRowValues(1, new int[] { 8, -1, -1, 1, -1, 2, 6, 9, -1 });
		hard2.setRowValues(2, new int[] { -1, -1, -1, -1, 8, -1, 2, 1, -1 });
		hard2.setRowValues(3, new int[] { 1, 3, 2, -1, -1, -1, 8, 5, -1 });
		hard2.setRowValues(4, new int[] { -1, 2, 3, 8, 9, 1, 7, 6, -1 });
		hard2.setRowValues(5, new int[] { 7, -1, 1, -1, -1, 4, 9, 2, 8 });
		hard2.setRowValues(6, new int[] { 9, -1, -1, -1, 2, 7, -1, 3, 1 });
		hard2.setRowValues(7, new int[] { 2, 4, -1, -1, -1, 8, 1, -1, 6 });
		hard2.setRowValues(8, new int[] { 6, 1, -1, -1, 4, -1, 3, 8, 2 });
		hard2.setRowValues(9, new int[] { 3, -1, -1, 2, 1, 6, -1, -1, 9 });

		Grid easy = new Grid(9);
		easy.setRowValues(1, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(2, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(3, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(4, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(5, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(6, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(7, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(8, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		easy.setRowValues(9, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });

		Grid bsp1 = new Grid(9);

		bsp1.setValue(6, 1, 6);
		bsp1.setValue(7, 1, 4);
		bsp1.setValue(5, 2, 9);
		bsp1.setValue(6, 2, 1);
		bsp1.setValue(7, 2, 3);
		bsp1.setValue(3, 3, 2);
		bsp1.setValue(8, 3, 8);
		bsp1.setValue(9, 3, 9);
		bsp1.setValue(3, 4, 4);
		bsp1.setValue(5, 4, 6);
		bsp1.setValue(6, 4, 7);
		bsp1.setValue(7, 4, 8);
		bsp1.setValue(8, 4, 1);
		bsp1.setValue(2, 5, 7);
		bsp1.setValue(5, 5, 1);
		bsp1.setValue(8, 5, 4);
		bsp1.setValue(2, 6, 1);
		bsp1.setValue(4, 6, 9);
		bsp1.setValue(5, 6, 8);
		bsp1.setValue(7, 6, 7);
		bsp1.setValue(1, 7, 3);
		bsp1.setValue(2, 7, 5);
		bsp1.setValue(5, 7, 2);
		bsp1.setValue(7, 7, 6);
		bsp1.setValue(3, 8, 1);
		bsp1.setValue(4, 8, 4);
		bsp1.setValue(5, 8, 3);
		bsp1.setValue(3, 9, 8);

		Grid konfliktfrei = new Grid(9);

		// konfliktfrei.setValue(1, 1, 1);
		// konfliktfrei.setValue(1, 2, 2);
		// konfliktfrei.setValue(1, 3, 3);
		// konfliktfrei.setValue(2, 1, 1);
		// konfliktfrei.setValue(2, 2, 2);
		// konfliktfrei.setValue(2, 3, 3);
		// konfliktfrei.setValue(3, 1, 1);
		// konfliktfrei.setValue(3, 2, 2);
		// konfliktfrei.setValue(3, 3, 3);

		konfliktfrei.setValue(1, 1, 1);
		konfliktfrei.setValue(1, 2, 2);
		konfliktfrei.setValue(1, 3, 4);
		konfliktfrei.setValue(2, 1, 1);
		konfliktfrei.setValue(2, 2, 2);
		konfliktfrei.setValue(2, 3, 4);
		konfliktfrei.setValue(3, 1, 1);
		konfliktfrei.setValue(3, 2, 2);
		konfliktfrei.setValue(3, 3, 4);

		konfliktfrei.setValue(1, 4, 4);
		konfliktfrei.setValue(1, 5, 5);
		konfliktfrei.setValue(1, 6, 6);
		konfliktfrei.setValue(2, 4, 4);
		konfliktfrei.setValue(2, 5, 5);
		konfliktfrei.setValue(2, 6, 6);
		konfliktfrei.setValue(3, 4, 4);
		konfliktfrei.setValue(3, 5, 5);
		konfliktfrei.setValue(3, 6, 6);

		konfliktfrei.setValue(1, 7, 6);
		konfliktfrei.setValue(1, 8, 5);
		konfliktfrei.setValue(1, 9, 3);
		konfliktfrei.setValue(2, 7, 6);
		konfliktfrei.setValue(2, 8, 5);
		konfliktfrei.setValue(2, 9, 3);
		konfliktfrei.setValue(3, 7, 6);
		konfliktfrei.setValue(3, 8, 5);
		konfliktfrei.setValue(3, 9, 3);

		konfliktfrei.setValue(4, 1, 1);
		konfliktfrei.setValue(4, 2, 2);
		konfliktfrei.setValue(4, 3, 3);
		konfliktfrei.setValue(5, 1, 1);
		konfliktfrei.setValue(5, 2, 2);
		konfliktfrei.setValue(5, 3, 3);
		konfliktfrei.setValue(6, 1, 1);
		konfliktfrei.setValue(6, 2, 2);
		konfliktfrei.setValue(6, 3, 3);

		konfliktfrei.setValue(4, 4, 4);
		konfliktfrei.setValue(4, 5, 5);
		konfliktfrei.setValue(4, 6, 6);
		konfliktfrei.setValue(5, 4, 4);
		konfliktfrei.setValue(5, 5, 5);
		konfliktfrei.setValue(5, 6, 6);
		konfliktfrei.setValue(6, 4, 4);
		konfliktfrei.setValue(6, 5, 5);
		konfliktfrei.setValue(6, 6, 6);

		konfliktfrei.setValue(4, 7, 7);
		konfliktfrei.setValue(4, 8, 8);
		konfliktfrei.setValue(4, 9, 9);
		konfliktfrei.setValue(5, 7, 7);
		konfliktfrei.setValue(5, 8, 8);
		konfliktfrei.setValue(5, 9, 9);
		konfliktfrei.setValue(6, 7, 7);
		konfliktfrei.setValue(6, 8, 8);
		konfliktfrei.setValue(6, 9, 9);

		konfliktfrei.setValue(7, 1, 1);
		konfliktfrei.setValue(7, 2, 2);
		konfliktfrei.setValue(7, 3, 3);
		konfliktfrei.setValue(8, 1, 1);
		konfliktfrei.setValue(8, 2, 2);
		konfliktfrei.setValue(8, 3, 3);
		konfliktfrei.setValue(9, 1, 1);
		konfliktfrei.setValue(9, 2, 2);
		konfliktfrei.setValue(9, 3, 3);

		konfliktfrei.setValue(7, 4, 4);
		konfliktfrei.setValue(7, 5, 5);
		konfliktfrei.setValue(7, 6, 6);
		konfliktfrei.setValue(8, 4, 4);
		konfliktfrei.setValue(8, 5, 5);
		konfliktfrei.setValue(8, 6, 6);
		konfliktfrei.setValue(9, 4, 4);
		konfliktfrei.setValue(9, 5, 5);
		konfliktfrei.setValue(9, 6, 6);

		konfliktfrei.setValue(7, 7, 7);
		konfliktfrei.setValue(7, 8, 8);
		konfliktfrei.setValue(7, 9, 9);
		konfliktfrei.setValue(8, 7, 7);
		konfliktfrei.setValue(8, 8, 8);
		konfliktfrei.setValue(8, 9, 9);
		konfliktfrei.setValue(9, 7, 7);
		konfliktfrei.setValue(9, 8, 8);
		konfliktfrei.setValue(9, 9, 9);

		Grid sortColRow = new Grid(9);

		sortColRow.setValue(1, 1, 4);
		sortColRow.setValue(1, 2, 5);
		sortColRow.setValue(1, 3, 6);
		sortColRow.setValue(2, 1, 5);
		sortColRow.setValue(2, 2, 6);
		sortColRow.setValue(2, 3, 4);
		sortColRow.setValue(3, 1, 6);
		sortColRow.setValue(3, 2, 4);
		sortColRow.setValue(3, 3, 5);

		sortColRow.setValue(1, 4, 1);
		sortColRow.setValue(1, 5, 2);
		sortColRow.setValue(1, 6, 3);
		sortColRow.setValue(2, 4, 2);
		sortColRow.setValue(2, 5, 3);
		sortColRow.setValue(2, 6, 1);
		sortColRow.setValue(3, 4, 3);
		sortColRow.setValue(3, 5, 1);
		sortColRow.setValue(3, 6, 2);

		sortColRow.setValue(1, 7, 7);
		sortColRow.setValue(1, 8, 8);
		sortColRow.setValue(1, 9, 9);
		sortColRow.setValue(2, 7, 8);
		sortColRow.setValue(2, 8, 9);
		sortColRow.setValue(2, 9, 7);
		sortColRow.setValue(3, 7, 9);
		sortColRow.setValue(3, 8, 7);
		sortColRow.setValue(3, 9, 8);

		sortColRow.setValue(4, 1, 4);
		sortColRow.setValue(4, 2, 5);
		sortColRow.setValue(4, 3, 6);
		sortColRow.setValue(5, 1, 5);
		sortColRow.setValue(5, 2, 6);
		sortColRow.setValue(5, 3, 4);
		sortColRow.setValue(6, 1, 6);
		sortColRow.setValue(6, 2, 4);
		sortColRow.setValue(6, 3, 5);

		sortColRow.setValue(4, 4, 7);
		sortColRow.setValue(4, 5, 8);
		sortColRow.setValue(4, 6, 9);
		sortColRow.setValue(5, 4, 8);
		sortColRow.setValue(5, 5, 9);
		sortColRow.setValue(5, 6, 7);
		sortColRow.setValue(6, 4, 9);
		sortColRow.setValue(6, 5, 7);
		sortColRow.setValue(6, 6, 8);

		sortColRow.setValue(4, 7, 1);
		sortColRow.setValue(4, 8, 2);
		sortColRow.setValue(4, 9, 3);
		sortColRow.setValue(5, 7, 2);
		sortColRow.setValue(5, 8, 3);
		sortColRow.setValue(5, 9, 1);
		sortColRow.setValue(6, 7, 3);
		sortColRow.setValue(6, 8, 1);
		sortColRow.setValue(6, 9, 2);

		sortColRow.setValue(7, 1, 7);
		sortColRow.setValue(7, 2, 8);
		sortColRow.setValue(7, 3, 9);
		sortColRow.setValue(8, 1, 8);
		sortColRow.setValue(8, 2, 9);
		sortColRow.setValue(8, 3, 7);
		sortColRow.setValue(9, 1, 9);
		sortColRow.setValue(9, 2, 7);
		sortColRow.setValue(9, 3, 8);

		sortColRow.setValue(7, 4, 1);
		sortColRow.setValue(7, 5, 2);
		sortColRow.setValue(7, 6, 3);
		sortColRow.setValue(8, 4, 2);
		sortColRow.setValue(8, 5, 3);
		sortColRow.setValue(8, 6, 1);
		sortColRow.setValue(9, 4, 3);
		sortColRow.setValue(9, 5, 1);
		sortColRow.setValue(9, 6, 2);

		sortColRow.setValue(7, 7, 4);
		sortColRow.setValue(7, 8, 5);
		sortColRow.setValue(7, 9, 6);
		sortColRow.setValue(8, 7, 5);
		sortColRow.setValue(8, 8, 6);
		sortColRow.setValue(8, 9, 4);
		sortColRow.setValue(9, 7, 6);
		sortColRow.setValue(9, 8, 4);
		sortColRow.setValue(9, 9, 5);

		Grid solved1 = new Grid(9);

		int[] z1 = { 9, 8, 5, 7, 4, 1, 3, 6, 2 };
		int[] z2 = { 2, 7, 1, 3, 8, 6, 5, 9, 4 };
		int[] z3 = { 4, 3, 6, 9, 5, 2, 7, 1, 8 };
		int[] z4 = { 8, 2, 7, 3, 5, 9, 1, 4, 6 };
		int[] z5 = { 5, 9, 4, 6, 1, 8, 2, 3, 7 };
		int[] z6 = { 6, 1, 3, 7, 2, 4, 8, 5, 9 };
		int[] z7 = { 4, 3, 5, 8, 9, 7, 6, 2, 1 };
		int[] z8 = { 2, 6, 8, 1, 4, 3, 9, 7, 5 };
		int[] z9 = { 1, 7, 9, 5, 6, 2, 4, 8, 3 };

		solved1.setRowValues(1, z1);
		solved1.setRowValues(2, z2);
		solved1.setRowValues(3, z3);
		solved1.setRowValues(4, z4);
		solved1.setRowValues(5, z5);
		solved1.setRowValues(6, z6);
		solved1.setRowValues(7, z7);
		solved1.setRowValues(8, z8);
		solved1.setRowValues(9, z9);

		Grid m1 = new Grid(9);
		m1.setRowValues(1, new int[] { -1, 2, 3, 4, 5, 6, 7, 8, 9 });
		m1.setRowValues(2, new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 1 });
		m1.setRowValues(3, new int[] { 3, 4, 5, 6, 7, 8, 9, 1, 2 });
		m1.setRowValues(4, new int[] { 4, 5, 6, 7, 8, 9, 1, 2, 3 });
		m1.setRowValues(5, new int[] { 5, 6, 7, 8, 9, 1, 2, 3, 4 });
		m1.setRowValues(6, new int[] { 6, 7, 8, 9, 1, 2, 3, 4, 5 });
		m1.setRowValues(7, new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 });
		m1.setRowValues(8, new int[] { 8, 9, 1, 2, 3, 4, 5, 6, 7 });
		m1.setRowValues(9, new int[] { 9, 1, 2, 3, 4, 5, 6, 7, 8 });

		// p1.returnGrid(hard2);
		/*
		 * System.out.println("Methode 1"); p1.returnGrid(p1.getBlockConflictFree(m1));
		 * System.out.println("Methode 2"); p1.returnGrid(p1.getBlockSortColRow(m1));
		 * System.out.println("Methode 3"); p1.returnGrid(p1.getBlockSudoku(m1));
		 * 
		 * System.out.println("Methode 4: "+p1.hasBlockConflictFree(m1));
		 * System.out.println("Methode 5: "+p1.hasBlockSortColRow(m1));
		 * System.out.println("Methode 6: "+p1.hasBlockSudoku(m1));
		 */
		
		
		
		System.out.println(
				"Grid gridToSolve");
		for (int r = 1; r < 9 + 1; r++) {
			for (int c = 1; c < 9 + 1; c++) {
				if (hard2.getValue(r, c) > 0) {
					System.out.print(" " + hard2.getValue(r, c) + " ");
				} else {
					System.out.print(" _ ");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("In Grid hard2 "+ p1.putNumberColRow(hard2,3) + " 3-Extensions are possible." );
		// p1.returnGrid(hard2);
		p1.getBlockConflictFree(g);
		
		

	}

}
