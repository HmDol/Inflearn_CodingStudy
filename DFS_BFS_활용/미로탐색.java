package DFS_BFS_활용;

import java.util.*;

public class 미로탐색 {
    static int[][] arr, ch;
    static int answer = 0;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void DFS(int n, int m) {
        if (n == 6 && m == 6) { // 목적지 도착
            answer++;
        } else {
            for (int i = 0; i < 4; i++) { // 4방향 탐색
                int nx = n + dx[i];
                int ny = m + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && ch[nx][ny] == 0 && arr[nx][ny] == 0) {
                    ch[nx][ny] = 1; // 방문 표시
                    DFS(nx, ny); // 다음 좌표로 이동
                    ch[nx][ny] = 0; // 백트래킹 시 방문 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = sc.nextInt(); // 미로 입력
            }
        }

        ch = new int[7][7]; // 방문 체크 배열 초기화
        ch[0][0] = 1; // 시작점 방문 처리
        DFS(0, 0); // DFS 탐색 시작
        System.out.println(answer); // 경로의 개수 출력
    }
}
