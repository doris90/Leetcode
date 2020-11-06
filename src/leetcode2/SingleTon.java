package leetcode2;

public class SingleTon {

    private static volatile SingleTon instance = null;

    private SingleTon() {}

    public SingleTon getSingleTon() {

        if(this.instance == null) {

            synchronized (SingleTon.class) {

                if(this.instance == null) {
                    instance = new SingleTon();
                }
            }
        }

        return instance;

    }
}
