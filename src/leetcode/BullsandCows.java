/*
 * ���󣺸�������������ɵ��ַ���������������Ϸ��Ŀ299���ж�ͬΪֵͬ�ĸ����͵ڶ����ַ����к��е�һ���ַ��������֣�����ͬλ�ĸ�����
 * ˼·��1��������װ��Ϊchar[],�ж�ͬλֵͬ�ĸ���a
 * 		2����ͬλ��ֵͬ�����ֱ�װ����������
 * 		3�����������ֵ�ÿһλ�ڲ²�����������Ѱ�ң��ҵ�b+1�����ڲ²�����������ɾ������*/



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
