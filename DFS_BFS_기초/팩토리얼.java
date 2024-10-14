package DFS_BFS_기초;

public class 팩토리얼 {
    public static int DFS(int n) {
        if (n == 0)
            return 1;
        else {
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(DFS(5));
    }
}
