package tasks;

import checkers.ColumnChecker;
import Validation.ValidationResult;

public class AllColumnsTask implements Runnable {
    private final int[][] board;
    private final ValidationResult[] results = new ValidationResult[9];

    public AllColumnsTask(int[][] board) {
        this.board = board;
    }

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            this.results[i] = ColumnChecker.checkColumn(board, i);
        }
    }

    public ValidationResult[] getResults() {
        return results;
    }
}