/*
 * 需求：求两矩形所占平面的总面积
 * 思路：1、若不相交，面积为两矩形面积和
 * 		2、若相交，面积为两矩形面积和-相交面积
 * 重点：如何判断两矩形相交：
 * 		直接判断两矩形相交是麻烦的，可直接判断两矩形不相交即可，对应的否命题即两矩形相交
 * */

package leetcode;

public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeArea(-2,-2,2,2,-3,-3,3,-1));
	}
	
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = Math.abs(A - C)*Math.abs(D - B) + Math.abs(G - E)*Math.abs(H - F);
        
        //两矩形不相交
        if(E>=C || G<=A || F>=D || H<=B) return area;
        
        int dx = Math.abs(Math.min(C, G) - Math.max(A, E));
        int dy = Math.abs(Math.min(D, H) - Math.max(B, F));
        return area - dx*dy;
    }

}
