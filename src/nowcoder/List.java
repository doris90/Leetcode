package nowcoder;

import common.RandomListNode;

public class List {

    /**
     *
     * @param '输入一个复杂链表'（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     *
     * @return 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
     * 解法： 深拷贝第一个节点和random节点 -> 递归
     */
    public static RandomListNode Clone(RandomListNode pHead) {

        if(pHead == null) return null;
        RandomListNode copy = new RandomListNode(pHead.label);
        //Random should be copied deeply, not just copy address, but also copy as a new node
        if(pHead.random != null) {
            copy.random = new RandomListNode(pHead.random.label);
        } else {
            copy.random = null;
        }

        copy.next = Clone(pHead.next);

        return copy;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        RandomListNode r6 = new RandomListNode(6);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        r5.next = r6;
        r1.random = r4;
        r2.random = r1;
        r6.random = r5;

        RandomListNode x = Clone(r1);
        System.out.println("");
    }
}
