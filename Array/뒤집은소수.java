package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집은소수 {
    public static boolean isPrime(int num) { // 소수를 확인하는 함수
        if (num == 1)
            return false;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;

    }

    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) { // 숫자를 뒤집는 과정
                int t = tmp % 10;
                res = res * 10 + t;
                tmp /= 10;
            }

            if (isPrime(res))
                answer.add(res);

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int r : solution(n, arr))
            System.out.print(r + " ");

    }
}
