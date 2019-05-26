package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {

    public static void main(String[] args) {

        String s = "234";
        List res = letterCombinations(s);
        System.out.println(res.size());

        Iterator<String> it = res.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static List<String> letterCombinations(String digits) {

        if(digits==null || digits.length()==0) return null;

        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        ans.add("");

        for (int i = 0; i < digits.length(); i++) {

            int x = Character.getNumericValue(digits.charAt(i));
            char[] target = mapping[x].toCharArray();

            while(ans.peek().length() == i) { //Not good

                String t = ans.pop();

                for (int  j= 0; j < target.length; j++) {

                    ans.add(t+target[j]);

                }
            }
        }

        return ans;

    }
}
