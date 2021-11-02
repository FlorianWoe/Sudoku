package org.example;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SudokuSolverTest {

    @Test
    public void testSolvableSudoku() throws SudokuException, IOException {
        int[] sudoku = SudokuParser.parseSudoku(Paths.get("src", "test", "resources", "sudoku_empty.csv"));
        assertTrue(new SudokuSolver(sudoku).solve());
    }

    @Test
    public void testUnsolvableSudoku() throws SudokuException, IOException {
        int[] sudoku = SudokuParser.parseSudoku(Paths.get("src", "test", "resources", "sudoku_unsolvable.csv"));
        assertFalse(new SudokuSolver(sudoku).solve());
    }
}
