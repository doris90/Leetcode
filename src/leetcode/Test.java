package leetcode;
import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		int[] S = {1,2,3};
		List<List<Integer>> l = subsets(S);
		Iterator<List<Integer>> it = l.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
	}
	
	public static List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0)
			return res;
		Arrays.sort(S);
		ArrayList<Integer> list = new ArrayList<Integer>();
		dfs(res, list, S, 0);
		return res;
	}
	public static void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] S, int pos){
		res.add(new ArrayList<Integer>(list));
		for (int i = pos; i < S.length; i++) {
			list.add(S[i]);
			dfs(res, list, S, i + 1);
			list.remove(list.size() - 1);
		}
	}	
}
