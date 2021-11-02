package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SudokuParser {
    public static int[] parseSudoku(Path filePath) throws IOException, SudokuException {
        List<String> lines = Files.readAllLines(filePath);
        if (lines.size() != 9) {

            throw new SudokuException("Invalid input file: must contain exactly 9 lines");
        }
        int[] sudoku = new int[9 * 9];
        for (int row = 0; row < 9; row++) {
            String[] line = lines.get(row).split(",");
            if (line.length != 9) {

                throw new SudokuException("Invalid input file: must contain exactly 9 values per line");
            }

            for (int column = 0; column < 9; column++) {
                try {
                    sudoku[row * 9 + column] = Integer.parseInt(line[column]);
                } catch (NumberFormatException ex) {

                    throw new SudokuException("Invalid input file: invalid number format", ex);
                }
            }
        }

        return sudoku;
    }
}
