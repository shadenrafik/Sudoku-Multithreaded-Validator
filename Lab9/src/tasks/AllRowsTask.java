package tasks;

import checkers.RowChecker;
import Validation.ValidationResult;

public class AllRowsTask implements Runnable {
    private final int[][] board;
    private final ValidationResult[] results = new ValidationResult[9];

    public AllRowsTask(int[][] board) {
        this.board = board;
    }

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            this.results[i] = RowChecker.checkRow(board, i);
        }
    }

    public ValidationResult[] getResults() {
        return results;
    }
}