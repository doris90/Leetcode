/*
 * 需求：在一个9*9的数独版上，判断数独是否合法。（数独:每行数不重复；每列数不重复；每个3*3的小九宫格数不重复）
 * 思路：1、行扫描判断
 * 		2、列扫描判断
 * 		3、3*3的小九宫格扫描判断
 * 要点：注意小方块的ij取法。对于当前这块板子来说，总共有9个小方格，按0~8从左到右依次编号。
 * 		按编号求'/'就是求得当前小方格的第一行横坐标，因为每个小方格有3行，所以循环3次。
 * 		按编号求'%'就是求得当前小方格的第一列纵坐标，因为每个小方格有3列，所以循环3次。 
 * */

package leetcode;
import java.util.*;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] c = {{'.' , '8','7','6','5','4','3','2','1'},{'2' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'} , {'3' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'} , {'4' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'} , {'5' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'} , {'6' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'} , {'7' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'} , {'8' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'} , {'9' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'}};
		System.out.println(isValidSudoku(c));
	}
	
    public static boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board == null) return false;
        List<Character> l = new ArrayList<Character>();
        //行判断
        for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		if(board[i][j] != '.') {
        			if(l.contains(board[i][j])) return false;
        			l.add(board[i][j]);
        		}
        	}
        	l.clear();
        }
        
        
        //列判断
        for(int c=0; c<9; c++) {
        	for(int r=0; r<9; r++) {
        		if(board[r][c] != '.') {
        			if(l.contains(board[r][c])) return false;
        			l.add(board[r][c]);
        		}
        	}
        	l.clear();
        }
        
        
        //9宫格判断
        for(int n=0; n<9; n++) {
        	for(int i=n/3*3; i<(n/3*3 + 3); i++) {
        		for(int j=(n%3)*3; j<((n%3)*3+3); j++) {
            		if(board[i][j] != '.') {
            			if(l.contains(board[i][j])) return false;
            			l.add(board[i][j]);
            		}
        		}
            }
        	l.clear();
        }
        
        
        return true;
    }

}
