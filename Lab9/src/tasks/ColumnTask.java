package tasks;

import checkers.ColumnChecker;
import model.ValidationResult;

public class ColumnTask implements Runnable {
    private final int[][] board;
    private final int index;
    private ValidationResult result;
    public ColumnTask(int[][] board, int index) {
        this.board = board;
        this.index = index;
    }
    @Override
    public void run() {result= ColumnChecker.checkColumn(board,index);}
    public ValidationResult getResult(){return result;}
}
