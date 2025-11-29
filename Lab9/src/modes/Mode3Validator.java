package modes;

import Validation.ValidationResult;
import modes.ValidationFactory.SudokuValidator;
import tasks.AllRowsTask;
import tasks.AllColumnsTask;
import tasks.AllBoxesTask;
import java.lang.System;


public class Mode3Validator implements SudokuValidator {
    @Override
    public ValidationResult[] validate(int[][] board) {
        AllRowsTask rowsTask = new AllRowsTask(board);
        AllColumnsTask colsTask = new AllColumnsTask(board);
        AllBoxesTask boxesTask = new AllBoxesTask(board);

        Thread rowsThread = new Thread(rowsTask);
        Thread colsThread = new Thread(colsTask);
        Thread boxesThread = new Thread(boxesTask);

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

        ValidationResult[] results = new ValidationResult[27];

        System.arraycopy(rowsTask.getResults(), 0, results, 0, 9);

        System.arraycopy(colsTask.getResults(), 0, results, 9, 9);

        System.arraycopy(boxesTask.getResults(), 0, results, 18, 9);

        return results;
    }
}