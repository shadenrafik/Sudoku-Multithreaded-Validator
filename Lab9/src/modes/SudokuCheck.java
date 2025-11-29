package modes;

import Validation.ValidationResult;
import checkers.RowChecker;
import checkers.ColumnChecker;
import checkers.BoxChecker;

public class SudokuCheck implements Runnable {
    public enum CheckType {SINGLE_ROW,SINGLE_COL,SINGLE_BOX}
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
            case SINGLE_ROW:
                result = RowChecker.checkRow(board, index);
                break;
            case SINGLE_COL:
                result = ColumnChecker.checkColumn(board, index);
                break;
            case SINGLE_BOX:
                result = BoxChecker.checkBox(board, index);
                break;
        }
    }
    public ValidationResult getResult() {
        return result;
    }

}
