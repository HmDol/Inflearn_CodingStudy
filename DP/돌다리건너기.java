package DP;

import java.util.*;

public class 돌다리건너기 { // 돌의 개수(n)에 +1 해줘야함. 그래야 건너는 거니까
    static int[] dy;

    public static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dy = new int[n + 2];
        System.out.println(solution(n + 1));
    }
}
