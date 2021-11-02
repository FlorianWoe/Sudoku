package org.example;

import java.nio.file.Paths;
import java.util.Arrays;

public class SudokuApp {
    public static void main(String[] args) {
        if (args.length < 2 || Arrays.stream(new String[]{"solve", "validate"}).noneMatch(s -> s.equals(args[1]))) {
            System.out.print("usage: <sudoku-file> solve|validate");

            return;
        }

        String inputFileName = args[0];
        String mode = args[1];

        int[] sudoku;
        try {
            sudoku = SudokuParser.parseSudoku(Paths.get(inputFileName));
        } catch (Exception e) {
            e.printStackTrace();

            System.exit(1);
            return;
        }

        if ("solve".equals(mode)) {
            SudokuSolver solver = new SudokuSolver(sudoku);
            if (solver.solve()) {
                System.out.println("I solved the sudoku for you :)");
                solver.printSudoku();
            } else {
                System.out.println("This sudoku is not solvable");
                System.exit(1);
            }
        } else {
            SudokuValidator validator = new SudokuValidator(sudoku);
            if (validator.validate()) {
                System.out.println("This sudoku is valid :)");
            } else {
                System.out.println("This sudoku is not valid :(");
                System.exit(1);
            }
        }

    }
}
