package nowcoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class OldEventArray {

    public static int[] reOrderArray(int [] array) {
        if(array==null || array.length==0) return null;

        Arrays.sort(array);
        LinkedList<Integer> res = new LinkedList<>();

        for(int i=0; i<array.length; i++) {
            if(array[i]%2 != 0) {
                res.add(array[i]);
            }
        }

        for(int i=0; i<array.length; i++) {
            if(!res.contains(array[i])) {
                res.add(array[i]);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }

        return array;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6,7};
        reOrderArray(ints);
    }
}
