/*
 * ������˹��������
 * ˼·������Ϊi(1,2...numRows),��Ӧres��levelres ���±�Ϊi-1����Ϊ���������
 *      1> ��һ���Զ���Ϊ[1],i=0
 *      2> �ڶ����Զ���Ϊ[1,1],i=1;
 *      3> ���������1��res.get(i-1-1).get(j-1)+res.get(i-1-1).get(j)ѭ�����룻�ٴμ���1����󽫱���������
 *      �ܽ���С�*/

package leetcode;

import java.util.*;

public class PascalsTriangle {

	public static void main(String[] args) {
        List<List<Integer>> r = generate(5);
        Iterator<List<Integer>> it = r.iterator();
        while(it.hasNext()){
        	System.out.print(it.next());
        }

	}
	
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0) return res;
        List<Integer> levelres = new ArrayList<Integer>();
        
        for(int i=1; i<=numRows; i++) {
            if(i == 1) {
            	levelres.add(1);
            	res.add(levelres);
            }
            if(i == 2) {
            	levelres = new ArrayList<Integer>();
            	levelres.add(1);
            	levelres.add(1);
            	res.add(levelres);
            }
            if(i>2) {
            	levelres = new ArrayList<Integer>();
            	levelres.add(1);
                for(int j=1; j<i-1; j++) {
                	levelres.add(res.get(i-2).get(j-1) + res.get(i-2).get(j));
                }
                levelres.add(1);
                res.add(levelres);
            }

        }
        
        return res;

    }

}
