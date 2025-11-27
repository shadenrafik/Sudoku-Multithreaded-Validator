package checkers;

import model.ValidationResult;

public class ColumnChecker {
    public static ValidationResult checkColumn(int[][] board, int colIndex){
        boolean[] seen=new boolean[10];
        for (int row=0;row<9;row++){
            int val=board[row][colIndex];
            if (seen[val]){
                return new ValidationResult(false,colIndex+1,"COL",val);
            } seen[val]=true;
        } return new ValidationResult(true,colIndex+1,"COL",-1);
    }
}
