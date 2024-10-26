package DFS_BFS_활용;

import java.util.*;
import java.util.ArrayList;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }
}

public class 피자배달거리 {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs;

    static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point h : hs) { // 한집에서 피자집과의 최단 거리
                int dis = Integer.MAX_VALUE;
                for (int i : combi) { // 살아남은 피자집들과의 거리 비교
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis; // 도시의 피자배달 거리
            }
            answer = Math.min(answer, sum);

        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 도시 크기
        m = sc.nextInt(); // 살려야 하는 피자집 개수
        pz = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1)
                    hs.add(new Point(i, j));
                else if (tmp == 2)
                    pz.add(new Point(i, j));
            }
        }
        len = pz.size(); // 피자집 개수
        combi = new int[m]; // len C m 의 조합들이 들어감
        DFS(0, 0);
        System.out.println(answer);
    }
}
