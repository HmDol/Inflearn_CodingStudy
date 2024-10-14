package DFS_BFS_활용;

import java.util.*;

public class 조합구하기 {
    static int n, m;
    static int[] ch, answer;

    public static void DFS(int L, int s) {
        if (L == m) {
            for (int x = 0; x < m; x++)
                System.out.print(answer[x] + " ");
            System.out.println();

        } else {
            for (int i = s; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    answer[L] = i;
                    DFS(L + 1, i + 1);
                    ch[i] = 0;

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n + 1];
        answer = new int[m + 1];
        DFS(0, 1);

    }
}
