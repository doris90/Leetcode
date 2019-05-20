package leetcode;

import javax.lang.model.element.NestingKind;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    private static final Map<Integer, String> myMap;
    static
    {
        myMap = new HashMap<Integer, String>();
        myMap.put(1, "I");
        myMap.put(5, "V");
        myMap.put(10, "X");
        myMap.put(50, "L");
        myMap.put(100, "C");
        myMap.put(500, "D");
        myMap.put(1000, "M");
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        String tmp = String.valueOf(num);
        int div = 1;

       if(tmp.length() == 1) {
           //todo
       }else {
           for (int i = 0; i < tmp.length(); i++) {
               int tp = num % 10;
               sb.insert(0, getRomanNumber(tp, i));

           }


       }


        return String.valueOf(div);
    }

    private static String getRomanNumber(int tp, int level) {
        String res = null;

        switch (level) {
            case 0 :
                if(tp == 4) res = "IV";
                if(tp == 9) res = "IX";
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
}
