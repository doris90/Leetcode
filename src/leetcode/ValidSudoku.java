/*
 * ������һ��9*9���������ϣ��ж������Ƿ�Ϸ���������:ÿ�������ظ���ÿ�������ظ���ÿ��3*3��С�Ź��������ظ���
 * ˼·��1����ɨ���ж�
 * 		2����ɨ���ж�
 * 		3��3*3��С�Ź���ɨ���ж�
 * Ҫ�㣺ע��С�����ijȡ�������ڵ�ǰ��������˵���ܹ���9��С���񣬰�0~8���������α�š�
 * 		�������'/'������õ�ǰС����ĵ�һ�к����꣬��Ϊÿ��С������3�У�����ѭ��3�Ρ�
 * 		�������'%'������õ�ǰС����ĵ�һ�������꣬��Ϊÿ��С������3�У�����ѭ��3�Ρ� 
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
        //���ж�
        for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		if(board[i][j] != '.') {
        			if(l.contains(board[i][j])) return false;
        			l.add(board[i][j]);
        		}
        	}
        	l.clear();
        }
        
        
        //���ж�
        for(int c=0; c<9; c++) {
        	for(int r=0; r<9; r++) {
        		if(board[r][c] != '.') {
        			if(l.contains(board[r][c])) return false;
        			l.add(board[r][c]);
        		}
        	}
        	l.clear();
        }
        
        
        //9�����ж�
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
