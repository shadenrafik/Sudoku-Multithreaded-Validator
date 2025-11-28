package tasks;

import checkers.BoxChecker;
import Validation.ValidationResult;

public class AllBoxesTask implements Runnable {
    private final int[][] board;
    private final ValidationResult[] results = new ValidationResult[9];

    public AllBoxesTask(int[][] board) {
        this.board = board;
    }

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            this.results[i] = BoxChecker.checkBox(board, i);
        }
    }

    public ValidationResult[] getResults() {
        return results;
    }
}