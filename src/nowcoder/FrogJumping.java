package nowcoder;

public class FrogJumping {

    public static int jumpFloor(int target) {

        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;

        return jumpFloor(target-1) + jumpFloor(target-2);
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor2(4));
    }

    public static int jumpFloor2(int target) {

        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;

        return 2*jumpFloor2(target-1) ;
    }
}
