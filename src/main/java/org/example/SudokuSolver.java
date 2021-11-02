package org.example;

public class SudokuSolver {

    private final int[] sudokuField;

    public SudokuSolver(int[] sudokuField) {
         this.sudokuField = sudokuField;
    }

    private boolean canSet(int pos, int val) {
        int row = pos / 9;
        for (int i = 0; i < 9; i++) {
            if (sudokuField[row * 9 + i] == val) {
                return false;
            }
        }

        int col = pos % 9;
        for (int i = 0; i < 9; i++) {
            if (sudokuField[col + i * 9] == val) {
                return false;
            }
        }

        int boxRowStart = row / 3;
        int boxColStart = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudokuField[(boxColStart * 3 + i) + (boxRowStart * 9 * 3 + j * 9)] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve() {
        int pos = -1;
        for (int i = 0; i < 81; i++) {
            if (sudokuField[i] == 0) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            return true;
        }

        for (int num = 1; num <= 9; num++) {
            if (canSet(pos, num)) {
                sudokuField[pos] = num;
                if (solve()) {
                    return true;
                } else {
                    sudokuField[pos] = 0;
                }
            }
        }
        return false;
    }

    public int[] getSudokuField() {
        return sudokuField;
    }

    public void printSudoku() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(sudokuField[i*9 + j] + ",");
            }
            System.out.println(sudokuField[i*9 + 8]);
        }
    }
}
