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
        List<SudokuCheck> checks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            checks.add(new SudokuCheck(board, CheckType.ROW, i));
            checks.add(new SudokuCheck(board, CheckType.COLUMN, i));
            checks.add(new SudokuCheck(board, CheckType.BOX, i));
        }
        for (SudokuCheck task : checks) {
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
            System.err.println("Mode 27 interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        ValidationResult[] results = new ValidationResult[27];
        int resultIndex = 0;
        for (SudokuCheck check : checks) {
            results[resultIndex++] = check.getResult();
        } return results;
    }
}