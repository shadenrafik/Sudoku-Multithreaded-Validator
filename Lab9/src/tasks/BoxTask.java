package tasks;

import checkers.BoxChecker;
import Validation.ValidationResult;


public class BoxTask implements Runnable {
    private final int[][] board;
    private final int index;
    private ValidationResult result;
    public BoxTask(int[][] board,int index){
        this.board=board;
        this.index=index;
    }
    @Override
    public void run() {result= BoxChecker.checkBox(board,index);}
    public ValidationResult getResult(){return result;}
}
