/*
 * 需求：给定两个数字组成的字符串，数字线索游戏题目299（判断同为同值的个数和第二个字符串中含有第一个字符串的数字，但不同位的个数）
 * 思路：1、将两串装换为char[],判断同位同值的个数a
 * 		2、将同位不同值的数分别装入俩个容器
 * 		3、用密码数字的每一位在猜测数字容器中寻找，找到b+1，并在猜测数字容器中删除该数*/



package leetcode;
import java.util.*;

public class BullsandCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHint("10", "01"));
	}
	
    public static String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        String res = null;
        List<Character> ms = new ArrayList< Character>();
        List<Character> mg = new ArrayList< Character>();
        char[] se = secret.toCharArray();
        char[] gu = guess.toCharArray();
        
        for(int i=0; i<se.length; i++) {
        	if(se[i] == gu[i]) {
        		a++;
        	}
        	else {
        		ms.add(se[i]);
        		mg.add(gu[i]);
        	}
        }
        
        Iterator<Character> its = ms.listIterator();
        
        while(its.hasNext()) {
        	Character tmp = its.next();
        	if(mg.contains(tmp)) {
        		b++;
        		mg.remove(tmp);
        	}
        }
        
        res = String.valueOf(a) + 'A' + String.valueOf(b) + 'B';
        return res;
    }

}
