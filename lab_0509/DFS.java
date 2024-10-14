package lab_0509;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DFS {
    static int n, m; // 그래프의 크기(세로, 가로)
    static int[][] graph; // 그래프
    static boolean[][] visited; // 방문 여부
    static int count = 0; // 그림의 크기
    static int[][] pos = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } }; // 네 방향

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        boolean zero = true;
        List<Integer> answer = new ArrayList<>(); // count들이 들어갈 배열, 값:그림의 크기, 배열 길이 : 그림 갯수

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                graph[j][i] = sc.nextInt();
                if (graph[j][i] == 1) {
                    zero = false;
                }
            }
        }

        if (zero == true) {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0;
                if (!visited[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        System.out.println(answer.get(answer.size() - 1));

    }
}

/*
 * 백준 1926
 * 1. 아이디어
 * - 이중 for -> 값 1 && 방문x => BFS
 * - BFS 돌면서 그림개수 + 1, 최대값 갱신
 * 
 * 2. 시간 복잡도
 * BFS : O(V+E)
 * V : 500 * 500
 * E : 4 * 500 * 500
 * V+E : 4 * 250000 = 100만 < 2억 ===> 가능
 * 
 * 3. 자료구조
 * - 그래프 전체 지도 : int[][]
 * - 방문 : bool[][]
 * - queue(bfs)
 */