package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuValidator {

    private final int[] sudokuField;

    public SudokuValidator(int[] sudokuField) {
        this.sudokuField = sudokuField;
    }

    private boolean validateValueRange() {
        return Arrays.stream(sudokuField).allMatch(value -> value >= 1 && value <= 9);
    }

    private boolean validateRow(int row) {
        IntStream.Builder intStreamBuilder = IntStream.builder();
        for (int i = 0; i < 9; i++) {
            intStreamBuilder.add(sudokuField[row * 9 + i]);
        }

        return intStreamBuilder.build().distinct().count() == 9;
    }

    private boolean validateColumn(int column) {
        IntStream.Builder intStreamBuilder = IntStream.builder();
        for (int i = 0; i < 9; i++) {
            intStreamBuilder.add(sudokuField[9 * i + column]);
        }

        return intStreamBuilder.build().distinct().count() == 9;
    }

    private boolean validateRectangle(int rectangle) {
        IntStream.Builder intStreamBuilder = IntStream.builder();
        int x = rectangle % 3;
        int y = rectangle / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                intStreamBuilder.add(sudokuField[(x * 3 + i) + (y * 9 * 3 + j * 9)]);
            }
        }

        return intStreamBuilder.build().distinct().count() == 9;
    }

    public boolean validate() {
        if (!validateValueRange()) {

            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!(validateRow(i) &&
                    validateColumn(i) &&
                    validateRectangle(i))) {

                return false;
            }
        }

        return true;
    }
}
