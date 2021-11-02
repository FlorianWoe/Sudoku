package org.example;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SudokuParserTest {

    @Test(expected = SudokuException.class)
    public void parseInvalidSudokuColumns() throws SudokuException, IOException {
        SudokuParser.parseSudoku(Paths.get("src", "test", "resources", "sudoku_invalid_columns.csv"));
    }

    @Test(expected = SudokuException.class)
    public void parseInvalidSudokuRows() throws SudokuException, IOException {
        SudokuParser.parseSudoku(Paths.get("src", "test", "resources", "sudoku_invalid_rows.csv"));
    }

    @Test(expected = SudokuException.class)
    public void parseInvalidSudokuNumber() throws SudokuException, IOException {
        SudokuParser.parseSudoku(Paths.get("src", "test", "resources", "sudoku_invalid_number.csv"));
    }
}
