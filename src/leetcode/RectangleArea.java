/*
 * ��������������ռƽ��������
 * ˼·��1�������ཻ�����Ϊ�����������
 * 		2�����ཻ�����Ϊ�����������-�ཻ���
 * �ص㣺����ж��������ཻ��
 * 		ֱ���ж��������ཻ���鷳�ģ���ֱ���ж������β��ཻ���ɣ���Ӧ�ķ����⼴�������ཻ
 * */

package leetcode;

public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeArea(-2,-2,2,2,-3,-3,3,-1));
	}
	
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = Math.abs(A - C)*Math.abs(D - B) + Math.abs(G - E)*Math.abs(H - F);
        
        //�����β��ཻ
        if(E>=C || G<=A || F>=D || H<=B) return area;
        
        int dx = Math.abs(Math.min(C, G) - Math.max(A, E));
        int dy = Math.abs(Math.min(D, H) - Math.max(B, F));
        return area - dx*dy;
    }

}
