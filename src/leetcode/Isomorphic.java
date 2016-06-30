/*
 * �����ж������ַ����Ƿ�ͬ�ṹ
 * ˼·��ͬ�ṹ�ȼ��ڣ��ַ���A��һ���ַ���ӦB����һ���ַ�����Ӧ��ϵ�ǲ����
 * 		1��ͨ��HashMap������A�ʹ�B�ַ���Ķ�Ӧ��ϵ
 * 		2�����������ַ�������map�Ѿ����ڸü�������Ƿ���϶�Ӧ��ϵ
 * 						    ��֮map�����ڸü���������B����ֵ���޸ö�Ӧ��ϵ������false��
 * 										  ��֮Ҳ�����ڸ�ֵ�������ַ���Ӧ��ϵ����map*/

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
    		if(map.containsKey(c1)) {					//���ڼ�
    			if(c2 != map.get(sc[i])) return false;  //�ж�ӳ���ϵ
    		}
    		else if(map.containsValue(c2)) return false; //�����ڸü���ȴ���ڸ�ֵ������false
    			else map.put(c1, c2);					 //map�в����ö�ӳ���ϵ������ü�ֵ��
    	}
    	
    	return true;
    	
    }

}
