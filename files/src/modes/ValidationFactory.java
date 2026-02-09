package modes;

import Validation.ValidationResult;

public class ValidationFactory {
    public interface SudokuValidator {
        ValidationResult[] validate(int[][] board);
    }
    public static SudokuValidator getValidator(int mode) {
        switch (mode) {
            case 0: return new Mode0Validator();
            case 3: return new Mode3Validator();
            case 27: return new Mode27Validator();
            default: throw new IllegalArgumentException("Invalid mode: " + mode + ". Must be 0, 3, or 27.");
        }
    }
}

