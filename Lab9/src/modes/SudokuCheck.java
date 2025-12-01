package modes;

import Validation.ValidationResult;
import checkers.RowChecker;
import checkers.ColumnChecker;
import checkers.BoxChecker;

public class SudokuCheck implements Runnable {
    public enum CheckType {ROW, COLUMN, BOX}
    private final int[][] board;
    private final CheckType type;
    private final int index;
    private ValidationResult result;

    public SudokuCheck(int[][] board, CheckType type, int index) {
        this.board = board;
        this.type = type;
        this.index = index;
    }
    @Override
    public void run() {
        switch (type) {
            case ROW:
                result = RowChecker.checkRow(board, index);
                break;
            case COLUMN:
                result = ColumnChecker.checkColumn(board, index);
                break;
            case BOX:
                result = BoxChecker.checkBox(board, index);
                break;
        }
    }
    public ValidationResult getResult() {
        return result;
    }

}
