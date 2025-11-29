package modes;

import Validation.ValidationResult;
import modes.ValidationFactory.SudokuValidator;
import checkers.RowChecker;
import checkers.ColumnChecker;
import checkers.BoxChecker;

public class Mode3Validator implements SudokuValidator {
    @Override
    public ValidationResult[] validate(int[][] board) {
        final ValidationResult[] results = new ValidationResult[27];
        Runnable rowsJob = () -> {
            for (int i = 0; i < 9; i++) {
                results[i] = RowChecker.checkRow(board, i);
            }
        };
        Runnable colsJob = () -> {
            for (int i = 0; i < 9; i++) {
                results[9 + i] = ColumnChecker.checkColumn(board, i);
            }
        };
        Runnable boxesJob = () -> {
            for (int i = 0; i < 9; i++) {
                results[18 + i] = BoxChecker.checkBox(board, i);
            }
        };

        Thread rowsThread = new Thread(rowsJob);
        Thread colsThread = new Thread(colsJob);
        Thread boxesThread = new Thread(boxesJob);

        rowsThread.start();
        colsThread.start();
        boxesThread.start();

        try {
            rowsThread.join();
            colsThread.join();
            boxesThread.join();
        } catch (InterruptedException e) {
            System.err.println("Mode 3 validation interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        return results;
    }
}