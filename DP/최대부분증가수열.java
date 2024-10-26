package DP;

import java.util.*;

public class 최대부분증가수열 {
    static ArrayList<Integer> dy = new ArrayList<>();

    public static void solution(int n, int[] arr) {
        dy.add(1);
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(dy.get(j), max);
                }
            }
            dy.add(max + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n, arr);
        Collections.sort(dy);

        System.out.println(dy.get(dy.size() - 1));

    }

}
