package DFS_BFS_기초;

import java.util.*;

public class 송아지찾기 { // BFS(너비우선 탐색) 최단거리 알고리즘
    static int answer = 0;
    static int[] dis = { 1, -1, 5 };
    static int[] ch; // 큐에 중복값을 업애기 위한 체크 배열
    static Queue<Integer> q = new LinkedList<>();

    public static int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        q.offer(s);
        int L = 0; // 깊이 레벨
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                if (x == e)
                    return L;
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    // if (nx == e)
                    // return L + 1; // 같은 결과
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.add(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s, e));
    }
}
