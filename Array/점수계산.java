package Array;

import java.util.Scanner;

public class 점수계산 {

    public static int solution(int n, int[] arr) {
        int answer = 0;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else
                cnt = 0;
        }

        // int[] score = new int[n];

        // for (int i = 0; i < n; i++) {
        // if (i == 0 && arr[0] == 1) {
        // score[i] = 1;
        // answer += score[i];
        // }

        // else if (arr[i] == 1) {
        // score[i] = score[i - 1] + 1;
        // answer += score[i];
        // }
        // }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }
}
