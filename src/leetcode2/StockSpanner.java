package leetcode2;

import java.util.Stack;

public class StockSpanner {
    private Stack<Integer> priceStack;
    private Stack<Integer> spanStack;

    /**
     * ================================901. Online Stock Span================
     * 数组局部连续count
     * @param args
     */
    public static void main(String[] args) {
        int[] in = {100, 80, 60, 70, 60, 75, 85};
        StockSpanner S = new StockSpanner();

        System.out.println(S.next(31));
        System.out.println(S.next(41));
        System.out.println(S.next(48));
        System.out.println(S.next(59));
        System.out.println(S.next(79));
//        System.out.println(S.next(75));
//        System.out.println(S.next(85));
    }

    public StockSpanner() {
        priceStack = new Stack<>();
        spanStack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        if(priceStack.isEmpty()) {
            priceStack.push(price);
            spanStack.push(span);

            return span;
        }

        Integer topItem = priceStack.peek();
        while(!priceStack.isEmpty() && topItem <= price) {
            priceStack.pop();
            span += spanStack.pop();
            if(!priceStack.isEmpty())topItem = priceStack.peek();
        }

        priceStack.push(price);
        spanStack.push(span);

        return spanStack.peek();

    }
}
