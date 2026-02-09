package checkers;

import Validation.ValidationResult;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class RowChecker {
    public static ValidationResult checkRow(int[][] sudoku, int rowIndex){
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int position = 0; position < 9; position++){
            int value = sudoku[rowIndex][position];
            int index = position + 1;
            positions.computeIfAbsent(value, k -> new ArrayList<>()).add(index);
        }
        Map<Integer, List<Integer>> duplicatedPositions = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : positions.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicatedPositions.put(entry.getKey(), entry.getValue());
            }
        }

        if (duplicatedPositions.isEmpty()) {
            return new ValidationResult(true, rowIndex + 1, "ROW", Collections.emptyMap());
        } else {
            return new ValidationResult(false, rowIndex + 1, "ROW", duplicatedPositions);
        }
    }
}