package DP;

import java.util.*;

public class 최대점수구하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] dy = new int[t + 1];
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            for (int j = t; j >= time; j--) { // 중복 사용이 안될때는 뒤에서 부터 하는게 포인트
                dy[j] = Math.max(dy[j - time] + score, dy[j]);
            }
        }
        System.out.println(dy[t]);
    }
}
