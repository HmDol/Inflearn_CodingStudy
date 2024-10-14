package Array;

import java.util.Scanner;

public class 피보나치수열 {

    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {

            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        피보나치수열 T = new 피보나치수열();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i : T.solution(n)) {
            System.out.print(i + " "); // ' '을 입력시 ASCII코드로 변환됨
        }
    }
}
