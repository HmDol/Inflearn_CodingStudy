package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class 큰수출력 {
    public ArrayList<Integer> solution(int l, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(arr[0]);

        for (int i = 1; i < l; i++) {
            if (arr[i] > arr[i - 1])
                answer.add(arr[i]);
        }
        return answer;

    }

    public static void main(String[] agrs) {
        큰수출력 T = new 큰수출력();
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : T.solution(l, arr)) {
            System.out.print(i + " ");
        }
    }
}