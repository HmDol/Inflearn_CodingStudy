package DFS_BFS_활용;

import java.util.Scanner;

public class 중복순열구하기 {
    static int n, m;
    static int[] arr;

    public static void DFS(int L) {
        if (L == m) {
            for (int i = 1; i <= m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                arr[L + 1] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m + 1];
        DFS(0);

    }
}
