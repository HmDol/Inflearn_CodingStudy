package DFS_BFS_기초;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int d) {
        data = d;
        lt = rt = null;
    }
}

public class 가장짧은말단노드_BFS {
    Node root;

    public int BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node tmp = q.poll();
                if (tmp.lt == null && tmp.rt == null) {
                    return L;
                }
                if (tmp.lt != null)
                    q.add(tmp.lt);
                if (tmp.rt != null)
                    q.add(tmp.rt);
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        가장짧은말단노드_BFS T = new 가장짧은말단노드_BFS();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.BFS(T.root));

    }
}
