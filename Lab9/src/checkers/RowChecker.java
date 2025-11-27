package checkers;

import model.ValidationResult;
import java.util.*;

public class RowChecker {
    public static ValidationResult checkRow(int[][] board,int rowIndex){
        boolean[] seen=new boolean[10];
        for (int val:board[rowIndex]){
            if (seen[val]){
                return new ValidationResult(false,rowIndex+1,"ROW",val);
            } seen[val]=true;
        } return new ValidationResult(true,rowIndex+1,"ROW",-1);
    }
}
