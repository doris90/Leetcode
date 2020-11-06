package leetcode2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        DFS dfs = new DFS();

        System.out.println(dfs.ladderLength(0, "hit", "cog", wordList, 0));
    }

    public int ladderLength(int res, String beginWord, String endWord, List<String> wordList, int start) {

        if(endWord.equals(wordList.get(start))) {
            return res + 1;
        } else {

            for (int i = start; i < wordList.size(); i++) {
                if(canChangeTo(beginWord, wordList.get(i))) {
                    ladderLength(res+1, wordList.get(i), endWord, wordList, i+1);

                }

            }
        }




        return res;

    }

    public boolean canChangeTo(String from, String to) {
        if(from.length() != to.length()) return false;
        int count = 0;

        for (int i = 0; i < from.length(); i++) {
            if(from.charAt(i) != to.charAt(i)) {
                count ++;
            }
        }

        return count == 1;
    }




    /**
     * =================================search word==================================
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int idx, String word) {
        if(idx==word.length()) {
            return true;
        }

        if(i<0 || i>= board.length || j<0 || j>=board[i].length || word.charAt(idx) != board[i][j]) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = ' ';

        boolean res = dfs(board, i-1, j,idx+1, word) ||
                dfs(board, i+1, j,idx+1, word) ||
                dfs(board, i, j-1,idx+1, word) ||
                dfs(board, i, j+1,idx+1, word);

        board[i][j] = tmp;

        return res;

    }

}
