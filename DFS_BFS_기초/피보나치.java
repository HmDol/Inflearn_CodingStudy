package DFS_BFS_기초;

import java.util.*;

public class 피보나치 {
    static int[] fibo;

    public static int DFS(int n) {
        if (n == 2 || n == 1)
            return fibo[n] = 1;

        else
            return fibo[n] = DFS(n - 1) + DFS(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n + 1];
        DFS(n);
        for (int i : fibo)
            System.out.print(i + " ");
    }
}
