package modes;

import Validation.ValidationResult;
import modes.ValidationFactory.SudokuValidator;
import tasks.RowTask;
import tasks.ColumnTask;
import tasks.BoxTask;
import java.util.ArrayList;
import java.util.List;
import java.lang.System;

public class Mode27Validator implements SudokuValidator {
    @Override
    public ValidationResult[] validate(int[][] board) {
        List<Runnable> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        ValidationResult[] results = new ValidationResult[27];

        for (int i = 0; i < 9; i++) {
            RowTask task = new RowTask(board, i);
            tasks.add(task);
            threads.add(new Thread(task));
        }

        for (int i = 0; i < 9; i++) {
            ColumnTask task = new ColumnTask(board, i);
            tasks.add(task);
            threads.add(new Thread(task));
        }

        for (int i = 0; i < 9; i++) {
            BoxTask task = new BoxTask(board, i);
            tasks.add(task);
            threads.add(new Thread(task));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Mode 27 validation interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        int resultIndex = 0;
        for (Runnable task : tasks) {
            if (task instanceof RowTask) {
                results[resultIndex++] = ((RowTask) task).getResult();
            } else if (task instanceof ColumnTask) {
                results[resultIndex++] = ((ColumnTask) task).getResult();
            } else if (task instanceof BoxTask) {
                results[resultIndex++] = ((BoxTask) task).getResult();
            }
        }

        return results;
    }
}