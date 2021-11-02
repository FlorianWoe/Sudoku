package org.example;

public class SudokuException extends Exception {
    public SudokuException(String msg) {
        super(msg);
    }

    public SudokuException(String msg, Throwable t) {
        super(msg, t);
    }
}
