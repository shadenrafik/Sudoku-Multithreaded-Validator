// C:\Users\HP\Desktop\PROG2\Sudoku_Checker_Lab9

import modes.ValidationFactory;
import Validation.ValidationResult;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar <app-name.jar> <.csv filepath> <mode>");
            return;
        }

        try {
            String filePath = args[0];
            int mode = Integer.parseInt(args[1]);

            SudokuBoard board = new SudokuBoard(filePath);

            ValidationFactory.SudokuValidator validator = ValidationFactory.getValidator(mode);
            ValidationResult[] results = validator.validate(board.getBoard());

            boolean overallValid = true;

            for (ValidationResult result : results) {
                if (!result.isValid()) {
                    overallValid = false;
                    break;
                }
            }

            if (overallValid) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");
                for (ValidationResult result : results) {
                    if (!result.isValid()) {
                        System.out.println(result.toString());
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("An error occurred during validation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}