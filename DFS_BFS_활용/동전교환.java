package DFS_BFS_활용;

import java.util.*;

public class 동전교환 {
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static Integer[] arr;

    public static void DFS(int L, int sum) {
        if (sum > m)
            return;
        if (L >= answer)
            return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {

                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder()); // 큰수부터 들어가야 시간 절약
        m = sc.nextInt();
        DFS(0, 0);
        System.out.println(answer);

    }
}
