package DFS_BFS_활용;

import java.util.Scanner;

public class 바둑이승차 {
    static int c;
    static int n;
    static int max = 0;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if (sum > c)
            return;
        if (L == n) {
            max = Math.max(sum, max);
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0, 0);
        System.out.println(max);
    }

}
