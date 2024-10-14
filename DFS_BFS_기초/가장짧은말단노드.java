package DFS_BFS_기초;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int d) {
        data = d;
        lt = rt = null;
    }
}

public class 가장짧은말단노드 {
    Node root;

    public int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null)
            return L;
        else
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
    }

    public static void main(String[] args) {
        가장짧은말단노드 T = new 가장짧은말단노드();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.DFS(0, T.root));

    }
}
