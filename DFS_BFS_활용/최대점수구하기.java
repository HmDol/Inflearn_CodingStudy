package DFS_BFS_활용;

import java.util.Scanner;

public class 최대점수구하기 {
    static int n, m;
    static int[] score;
    static int[] time;

    static int max = 0;

    public static void DFS(int L, int sum_s, int sum_t) {
        if (sum_t > m)
            return;
        if (L == n) {
            max = Math.max(sum_s, max);
        } else {
            DFS(L + 1, sum_s + score[L], sum_t + time[L]);
            DFS(L + 1, sum_s, sum_t);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();

        }
        DFS(0, 0, 0);
        System.out.println(max);
    }

}
