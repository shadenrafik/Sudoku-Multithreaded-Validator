package board;

import java.util.*;
import java.io.*;


public class SudokuBoard {
    private final int[][] board=new int[9][9];
    public SudokuBoard(String filePath) throws Exception {loadFile(filePath); }
    private void loadFile(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int row=0;
        while ((line = br.readLine()) != null && row<9) {
            String[] values = line.split(",");
            for (int col=0;col<9;col++) {
                board[row][col]=Integer.parseInt(values[col].trim());
            } row++;
        } br.close();
    }
    public int[][] getBoard() {return board;}

}
