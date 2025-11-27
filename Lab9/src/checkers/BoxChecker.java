package checkers;

import ValidationResult;

public class BoxChecker {
    public static ValidationResult checkBox(int[][] board,int boxIndex){
        boolean[] seen=new boolean[10];
        int startRow=(boxIndex/3)*3;
        int startCol=(boxIndex%3)*3;
        for (int row=0;row<3;row++){
            for (int col=0;col<3;col++){
                int val=board[startRow+row][startCol+col];
                if (seen[val]){
                    return new ValidationResult(false,boxIndex+1,"BOX",val);
                } seen[val]=true;
            }
        } return new ValidationResult(true,boxIndex+1,"BOX",-1);
    }
}
