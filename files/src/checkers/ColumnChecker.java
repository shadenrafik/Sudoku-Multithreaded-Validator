package checkers;

import Validation.ValidationResult;

import java.util.*;


public class ColumnChecker {
    public static ValidationResult checkColumn(int[][] board, int columnIndex){
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int row = 0; row < 9; row++){
            int value = board[row][columnIndex];
            int index = row + 1;
            positions.computeIfAbsent(value, k -> new ArrayList<>()).add(index);
        }
        Map<Integer, List<Integer>> duplicatedPositions = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : positions.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicatedPositions.put(entry.getKey(), entry.getValue());
            }
        }

        if (duplicatedPositions.isEmpty()) {
            return new ValidationResult(true, columnIndex + 1, "COL", Collections.emptyMap());
        } else {
            return new ValidationResult(false, columnIndex + 1, "COL", duplicatedPositions);
        }
    }
}
