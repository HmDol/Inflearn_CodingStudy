package DFS_BFS_활용;

import java.util.Scanner;

public class 수열추측하기 { // 각 숫자의 갯수가 n-1C0 ~ n-1Cn-1 로 됨
    static int[] b, p, ch;
    static int n, f;
    static boolean flag = false;
    static int[][] dy = new int[35][35];

    public static int combi(int n, int r) {
        if (dy[n][r] > 0)
            return dy[n][r];
        if (n == r || r == 0)
            return 1;
        else
            return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);

    }

    public static void DFS(int L, int sum) {
        if (flag == true)
            return;
        if (L == n) {
            if (sum == f) {
                for (int x : p)
                    System.out.print(x + " ");
                flag = true;
            }
        } else {

            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) {// n에 의해 정해진 각 숫자의 개수를 넣음
            b[i] = combi(n - 1, i);
        }
        DFS(0, 0);

    }
}
