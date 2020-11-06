package nowcoder;

public class Rectangle {

    public static void main(String[] args) {
        System.out.println(RectCover(10));
    }

    public static int RectCover2(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;

        return RectCover2(target-1) + RectCover2(target-2);

    }

    public static int RectCover(int target) {
        if(target <1 ) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;

        return myRectCover(target, 2*target);

    }


    public static int myRectCover(int n, int s) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        return myRectCover(n-1, s-2) + myRectCover(n-2, s-4);

    }
}
