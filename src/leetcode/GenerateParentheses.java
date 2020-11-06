package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gs = new GenerateParentheses();

        List<String> res = gs.generateParenthesis(3);

        Iterator<String> it = res.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backTracking(res, sb, n, 0, 0);

        return res;

    }

    public  List<String> backTracking(List<String> res,  //Result collection
                                            StringBuilder sb,
                                            int n,            //amount
                                            int open,         //open amount
                                            int closed        //closed amount
    ) {

        if(open==n && closed==n) {
            res.add(sb.toString());
        }

        if(open < n) {
            sb.append("(");
            backTracking(res, sb, n, open+1, closed);
            sb.setLength(sb.length()-1);
        }

        if(closed < open) {
            sb.append(")");
            backTracking(res, sb, n, open, closed+1);
            sb.setLength(sb.length()-1);
        }

        return res;

    }

}
