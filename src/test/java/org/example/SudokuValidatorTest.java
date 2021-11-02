package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;


public class SudokuValidatorTest {

    @Test
    public void validateCorrectSudoku() throws SudokuException, IOException {
        int[] sudoku = SudokuParser.parseSudoku(Paths.get("src", "test", "resources", "sudoku.csv"));
        assertTrue(new SudokuValidator(sudoku).validate());
    }

    @Test
    public void validateIncorrectSudoku() throws SudokuException, IOException {
        int[] sudoku = SudokuParser.parseSudoku(Paths.get("src", "test", "resources", "sudoku_invalid.csv"));
        assertFalse(new SudokuValidator(sudoku).validate());
    }
}
