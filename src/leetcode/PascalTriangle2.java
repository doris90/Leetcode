package leetcode;

import java.util.*;

public class PascalTriangle2 {

	public static void main(String[] args) {
		List<Integer> level  = new ArrayList<Integer>();
		level = getRow(3);
		Iterator<Integer> it = level.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}

	}
	
    public static List<Integer> getRow(int rowIndex) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> levelres  = new ArrayList<Integer>();
        
        for(int i=0; i<=rowIndex; i++) {
            if(i == 0) {
            	levelres.add(1);
            	res.add(levelres);
            }
            if(i == 1) {
            	levelres = new ArrayList<Integer>();
            	levelres.add(1);
            	levelres.add(1);
            	res.add(levelres);
            }
            if(i > 1) {
            	levelres = new ArrayList<Integer>();
            	levelres.add(1);
            	for(int j=1; j<i; j++ ) {
            		levelres.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            	}
            	levelres.add(1);
            	res.add(levelres);      	
            }
        }
        return res.get(rowIndex);
        

    }

}
