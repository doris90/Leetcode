package leetcode;

import javax.lang.model.element.NestingKind;
import java.util.*;

public class IntegerToRoman {
    private static final Map<Integer, String> myMap;
    static
    {
        myMap = new LinkedHashMap<>();
        myMap.put(1000, "M");
        myMap.put(900, "CM");
        myMap.put(500, "D");
        myMap.put(400, "CD");
        myMap.put(100, "C");
        myMap.put(90, "XC");
        myMap.put(50, "L");
        myMap.put(40, "XL");
        myMap.put(10, "X");
        myMap.put(9, "IX");
        myMap.put(5, "V");
        myMap.put(4, "IV");
        myMap.put(1, "I");
    }

    public static String intToRoman(int num) {

        StringBuilder res = new StringBuilder();

        int tmp = num;

        for (Integer i : myMap.keySet()) {
            int n = tmp/i;
            intToRomanBySingleNum(res, n, i);
            tmp = tmp % i;
        }

        return res.toString();

    }

    private static void intToRomanBySingleNum(StringBuilder res, int n, int number) {

        if(n==0) return;

        for (int i = 0; i < n; i++) {

            res.append(myMap.get(number));
        }

    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));


    }
}
