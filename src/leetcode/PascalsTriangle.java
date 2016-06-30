/*
 * 需求：帕斯卡三角形
 * 思路：层数为i(1,2...numRows),对应res中levelres 的下标为i-1，分为三种情况：
 *      1> 第一层自定义为[1],i=0
 *      2> 第二层自定义为[1,1],i=1;
 *      3> 第三层加入1；res.get(i-1-1).get(j-1)+res.get(i-1-1).get(j)循环放入；再次加入1；最后将本层结果放入
 *      总结果中。*/

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
