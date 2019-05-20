package leetcode;

/*
* Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.*/


import org.junit.Assert;
import org.junit.Test;

public class StringToInteger {

    private static int max = Integer.MAX_VALUE;
    private static int min = Integer.MIN_VALUE;


    @Test
    public void test() {
//        Assert.assertEquals(0, myAtoi(" "));
        Assert.assertEquals(0, myAtoi(" abd12"));
//        Assert.assertEquals(4193, myAtoi(" 4193 with words"));
//        Assert.assertEquals(-42, myAtoi(" -42abd"));
//        Assert.assertEquals(-2147483648, myAtoi(" -91283472332"));

    }

    public static int myAtoi(String str) {

        if(str == null || str.length()==0) return 0;

        String source  = str.trim();
        if(source == null || source.length()==0) return 0;

        String res = null;
        boolean isNegative = false;
        StringBuilder sb;
        if(source.charAt(0) == '+' || source.charAt(0) == '-' ) {
            if(source.charAt(0) == '-') isNegative = true;
            if(source.length()>1) {
                sb = new StringBuilder(String.valueOf(source.charAt(0))); //"+-"
                res = removeZeroOfBegining(source.substring(1));
                if(res != null && res.charAt(0)>='1' && res.charAt(0)<='9')sb.append(res.charAt(0));
            }
            else return 0;
        } else if(source.charAt(0) >= '0' && source.charAt(0) <= '9') {
            res = removeZeroOfBegining(source);
            if(res != null && res.charAt(0)>='1' && res.charAt(0)<='9')sb = new StringBuilder(String.valueOf(res.charAt(0)));
            else return 0;
        }else return 0;

        if(res.charAt(0)>'9' || res.charAt(0)<'0') return 0;

        Long result = 0l;

        for (int i = 1; i < res.length(); i++) {
            char tmp = res.charAt(i);
            if(tmp>='0' && tmp<='9') sb.append(res.charAt(i));
            else break;
        }

        if(sb.length() ==0 ) return 0;
        else if(sb.length()> 11) {
            if(isNegative) return min;
            else return max;
        }else {
            result = Long.valueOf(sb.toString());
            if(result >= max) return max;
            else if(result <= min) return min;
            else {
                return result.intValue();
            }
        }

    }

    public static String removeZeroOfBegining(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0') return s.substring(i);
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("   +0 123"));
    }
}
