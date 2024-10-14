package DFS_BFS_활용;

import java.util.*;

class Point {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 최단거리미로탐색 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[][] board, dis;

    public static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>(); // BFS를 위한 Queue 생성
        Q.offer(new Point(x, y)); // q에 초기 출발지점 삽입
        board[x][y] = 1; // 출발지점 지나감 표시
        while (!Q.isEmpty()) { //
            Point tmp = Q.poll(); // q에 들어간 값 빼오기
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i]; // tmp의 네방향
                int ny = tmp.y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { // 네방향 검사
                    board[nx][ny] = 1; // 다음 경로 1로 표시
                    Q.offer(new Point(nx, ny)); // 해당 경로 q에 삽입
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // dis에는 현재까지의 거리를 업데이트
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8]; // 입력받을 보드
        dis = new int[8][8]; // 최단 거리가 입력될 보드
        for (int i = 1; i <= 7; i++) { // 보드 입력
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        BFS(1, 1); // BFS 실행
        if (dis[7][7] == 0) // 목적지 까지 길 없음
            System.out.println(-1);
        else // 목적지까지 최단 거리를 보여줌
            System.out.println(dis[7][7]);
    }
}
