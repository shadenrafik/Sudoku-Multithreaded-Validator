package tasks;

import checkers.RowChecker;
import Validation.ValidationResult;

public class RowTask implements Runnable {
    private final int[][] board;
    private final int index;
    private ValidationResult result;
    public RowTask(int[][] board, int index) {
        this.board = board;
        this.index = index;
    }
    @Override
    public void run() {result= RowChecker.checkRow(board,index);}
    public ValidationResult getResult() {return result;}
}
