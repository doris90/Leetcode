package leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gs = new GenerateParentheses();
        StringBuffer re = new StringBuffer();

        gs.scoreOfParentheses("(()(()()))");

        System.out.println(re);


    }

//    public List<String> generateParenthesis(int n, StringBuffer re) {
//
//        List<String> res = new ArrayList<>();
//
//
//    }

    public void generate(int i, int n, StringBuffer re) {
        if(n <= 0) return ;

        if(i == n) return;

        re.append("C");

        generate(i+1, n, re);

    }

    int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;

    }

}
