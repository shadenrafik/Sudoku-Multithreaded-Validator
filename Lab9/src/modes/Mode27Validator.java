package modes;

import Validation.ValidationResult;
import modes.ValidationFactory.SudokuValidator;
import modes.SudokuCheck;
import modes.SudokuCheck.CheckType;
import java.util.ArrayList;
import java.util.List;

public class Mode27Validator implements SudokuValidator {
    @Override
    public ValidationResult[] validate(int[][] board) {
        List<SudokuCheck> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            tasks.add(new SudokuCheck(board, CheckType.SINGLE_ROW, i));
            tasks.add(new SudokuCheck(board, CheckType.SINGLE_COL, i));
            tasks.add(new SudokuCheck(board, CheckType.SINGLE_BOX, i));
        }
        for (SudokuCheck task : tasks) {
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

        ValidationResult[] results = new ValidationResult[27];
        int resultIndex = 0;
        for (SudokuCheck task : tasks) {
            results[resultIndex++] = task.getResult();
        } return results;
    }
}