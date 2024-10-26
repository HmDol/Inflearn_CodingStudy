package DP;

import java.util.*;

/**
 * 동전교환
 */
public class 동전교환 {
    static int[] dy;
    static int[] coin;

    public static void solution(int n, int num) {
        for (int i = 0; i < coin.length; i++) {
            if (i < coin[0])
                dy[i] = 0;
            dy[coin[i]] = 1;
        }
        for (int i = coin[0]; i <= num; i++) {
            if (dy[i] != 1) {
                int min = Integer.MAX_VALUE;
                for (int j = coin.length - 1; j >= 0; j--) {
                    if (coin[j] < i) {
                        min = Math.min(dy[i - coin[j]], min);
                    }
                }
                dy[i] = min + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();// 동전 종류의 수

        coin = new int[n]; // 동전의 종류
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int num = sc.nextInt(); // 목표값
        dy = new int[num + 1]; // 각 num마다 최소 동전 사용 개수

        solution(n, num);
        System.out.println(dy[num]);
    }
}