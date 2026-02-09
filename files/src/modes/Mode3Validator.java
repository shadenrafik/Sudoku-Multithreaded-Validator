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
        Runnable rows = () -> {
            for (int i = 0; i < 9; i++) {
                results[i] = RowChecker.checkRow(board, i);
            }
        };
        Runnable columns = () -> {
            for (int i = 0; i < 9; i++) {
                results[9 + i] = ColumnChecker.checkColumn(board, i);
            }
        };
        Runnable boxes = () -> {
            for (int i = 0; i < 9; i++) {
                results[18 + i] = BoxChecker.checkBox(board, i);
            }
        };

        Thread rThread = new Thread(rows);
        Thread cThread = new Thread(columns);
        Thread bThread = new Thread(boxes);

        rThread.start();
        cThread.start();
        bThread.start();

        try {
            rThread.join();
            cThread.join();
            bThread.join();
        } catch (InterruptedException e) {
            System.err.println("Mode 3 interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        return results;
    }
}