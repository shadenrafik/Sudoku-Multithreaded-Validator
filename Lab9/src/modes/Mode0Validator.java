package modes;

import checkers.*;
import Validation.ValidationResult;
import modes.ValidationFactory.SudokuValidator;

public class Mode0Validator implements SudokuValidator {
    @Override
    public ValidationResult[] validate(int[][] board) {
        ValidationResult[] results = new ValidationResult[27];
        int x = 0;
        for (int i = 0; i < 9; i++) {
            results[x++] = RowChecker.checkRow(board, i);
        }
        for (int i = 0; i < 9; i++) {
            results[x++] = ColumnChecker.checkColumn(board, i);
        }
        for (int i = 0; i < 9; i++) {
            results[x++] = BoxChecker.checkBox(board, i);
        }
        return results;
    }
}