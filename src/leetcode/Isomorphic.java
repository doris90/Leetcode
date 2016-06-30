/*
 * 需求：判断两个字符串是否同结构
 * 思路：同结构等价于，字符串A的一个字符对应B串的一个字符，对应关系是不变的
 * 		1、通过HashMap建立串A和串B字符间的对应关系
 * 		2、遍历两个字符串，若map已经存在该键，检查是否符合对应关系
 * 						    反之map不存在该键，若存在B串的值，无该对应关系，返回false；
 * 										  反之也不存在该值，将两字符对应关系插入map*/

package leetcode;

import java.util.*;

public class Isomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("bb", "aa"));
	}
	
    public static boolean isIsomorphic(String s, String t) {
    	if(s.length() == 1) return true;
    	
    	char[] sc = s.toCharArray();
    	char[] tc = t.toCharArray();
    	Map<Character , Character> map = new HashMap<Character , Character>();
    	
    	for(int i=0; i<sc.length; i++) {
    		char c1 = sc[i];
    		char c2 = tc[i];
    		if(map.containsKey(c1)) {					//存在键
    			if(c2 != map.get(sc[i])) return false;  //判断映射关系
    		}
    		else if(map.containsValue(c2)) return false; //不存在该键，却存在该值，返回false
    			else map.put(c1, c2);					 //map中不含该对映射关系，插入该键值对
    	}
    	
    	return true;
    	
    }

}
