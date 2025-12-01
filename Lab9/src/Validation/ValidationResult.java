package Validation;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class ValidationResult {
    private final boolean valid;
    private final int index;
    private final String type;
    private final Map<Integer, List<Integer>> duplicateLocations;

    public ValidationResult(boolean valid, int index, String type, Map<Integer, List<Integer>> duplicateLocations) {
        this.valid = valid;
        this.index = index;
        this.type = type;
        this.duplicateLocations = duplicateLocations;
    }
    public boolean isValid() {return valid;}

    @Override
    public String toString(){
        if (valid) return "";
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, List<Integer>> entry : duplicateLocations.entrySet()) {
            int duplicatedValue = entry.getKey();
            List<Integer> positions = entry.getValue();

            sb.append(type).append(" ").append(index).append(", ");
            sb.append("#").append(duplicatedValue).append(", ");

            String indexString = positions.toString().replace(" ", "");
            sb.append(indexString).append("\n");
        }

        return sb.toString().trim();
    }
}