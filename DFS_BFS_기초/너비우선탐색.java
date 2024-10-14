package DFS_BFS_기초;

import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class 너비우선탐색 { // 1번만에 가는거 다 탐색 -> 2번만에 가는거 다 탐색 -> .....
    static Node root;

    public static void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int l = 0;
        while (!q.isEmpty()) {
            int len = q.size();// 처음 len 값이 고정되야 하기때문에 필요함
            System.out.print(l + "레벨 : ");
            for (int i = 0; i < len; i++) {
                Node cur = q.poll(); // 현재 노드 cur 대입
                System.out.print(cur.data + " ");
                if (cur.lt != null)
                    q.add(cur.lt);
                if (cur.rt != null)
                    q.add(cur.rt);
            }
            l++;
            System.out.println();
        }

    }

    public static void main(String[] args) {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }
}
