package modes;

import checkers.*;
import Validation.ValidationResult;
import modes.ValidationFactory.SudokuValidator;

public class Mode0Validator implements SudokuValidator {
    @Override
    public ValidationResult[] validate(int[][] board) {
        ValidationResult[] results = new ValidationResult[27];
        int k = 0;
        for (int i = 0; i < 9; i++) {
            results[k++] = RowChecker.checkRow(board, i);
        }
        for (int i = 0; i < 9; i++) {
            results[k++] = ColumnChecker.checkColumn(board, i);
        }
        for (int i = 0; i < 9; i++) {
            results[k++] = BoxChecker.checkBox(board, i);
        }
        return results;
    }
}