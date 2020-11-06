package leetcode2;

import common.DLinkedNode;

import java.util.HashMap;

public class LRUCache {

    //[2,1],[1,1],[2,3],[4,1],[1],[2]
    public static void main(String[] args) {

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));       // returns 1
        System.out.println(cache.get(2));       // returns 1
    }


    HashMap<Integer, DLinkedNode> map;
    DLinkedNode head;
    DLinkedNode tail;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity + 2);

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        if(map.containsKey(key)) {

            DLinkedNode cur = removeNode(map.get(key));

            return addNewToFirst(cur).value;

        } else {
            return -1;
        }

    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {

            DLinkedNode target = map.get(key);

            removeNode(target);
            target.value = value;
            addNewToFirst(target);

        } else {

            if(map.size() == capacity) {
                removeNode(tail.pre);
            }

            DLinkedNode cur = new DLinkedNode();
            cur.key = key;
            cur.value = value;

            map.put(key, addNewToFirst(cur));

        }

    }

    private DLinkedNode addNewToFirst(DLinkedNode cur) {
        DLinkedNode tmp = head.post;

        head.post = cur;
        cur.pre = head;
        cur.post = tmp;
        tmp.pre = cur;

        map.put(cur.key, cur);
        return cur;
    }

    private DLinkedNode removeNode(DLinkedNode target) {

        target.pre.post = target.post;
        target.post.pre = target.pre;

        target.pre = null;
        target.post = null;

        map.remove(target.key);

        return target;
    }

}
