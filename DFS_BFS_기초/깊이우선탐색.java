package DFS_BFS_기초;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class 깊이우선탐색 {
    static Node root;

    public static void DFS(Node root) {
        if (root == null)
            return;
        else {
            // System.out.print(root.data + " "); // 전위순회
            DFS(root.lt);
            System.out.print(root.data + " ");// 중위순회
            DFS(root.rt);
            // System.out.print(root.data + " ");// 후위순회
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
        DFS(root);
    }
}
