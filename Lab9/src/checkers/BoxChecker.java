package checkers;

import Validation.ValidationResult;
import java.util.Collections;
import java.util.*;

public class BoxChecker {
    public static ValidationResult checkBox(int[][] board, int boxIndex){
        Map<Integer, List<Integer>> positions = new HashMap<>();
        int startRow = (boxIndex / 3) * 3;
        int startColumn = (boxIndex % 3) * 3;
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                int value = board[startRow + row][startColumn + column];
                int index = (row * 3) + column + 1;
                positions.computeIfAbsent(value, k -> new ArrayList<>()).add(index);
            }
        }
        Map<Integer, List<Integer>> duplicatedPositions = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : positions.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicatedPositions.put(entry.getKey(), entry.getValue());
            }
        }

        if (duplicatedPositions.isEmpty()) {
            return new ValidationResult(true, boxIndex + 1, "BOX", Collections.emptyMap());
        } else {
            return new ValidationResult(false, boxIndex + 1, "BOX", duplicatedPositions);
        }
    }
}