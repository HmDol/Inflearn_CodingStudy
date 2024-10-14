package Array;

import java.util.Scanner;

public class 소수개수구하기 { // 에라토스테네스 체 라는 방법을 이용
    public static int solution(int n) {
        int answer = 0;
        int[] test = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            if (test[i] == 0) {
                answer++;
                for (int j = 1; j * i <= n; j++) {
                    test[j * i] = 1;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
