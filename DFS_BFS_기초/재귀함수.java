package DFS_BFS_기초;

public class 재귀함수 {
    public static void DFS(int n) {
        if (n == 0)
            return;
        else {
            System.out.println(n);
            DFS(n - 1);
        }

    }

    public static void main(String[] args) {

        DFS(3);
    }
}
