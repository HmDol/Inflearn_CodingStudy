package DFS_BFS_활용;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 섬나라아일랜드 {
    static int answer = 0, n;
    static int[][] board;
    static int[] dx = { -1, 0, 1, 0, -1, -1, 1, 1 };
    static int[] dy = { 0, 1, 0, -1, -1, 1, 1, -1 };

    public static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        board[x][y] = 0;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.x + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    q.offer(new Point(nx, ny));
                    board[nx][ny] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    BFS(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

}
