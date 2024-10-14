package Array;

import java.util.*;

public class 가위바위보 {
    public ArrayList<String> solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i])
                answer.add("D");
            else if (arr1[i] == 1 && arr2[i] == 3)
                answer.add("A");
            else if (arr1[i] == 2 && arr2[i] == 1)
                answer.add("A");
            else if (arr1[i] == 3 && arr2[i] == 2)
                answer.add("A");
            else
                answer.add("B");

            // switch (arr1[i]) {
            // case 1:
            // if (arr2[i] == 2)
            // answer.add("B");
            // if (arr2[i] == 3)
            // answer.add("A");
            // if (arr2[i] == 1)
            // answer.add("D");
            // break;
            // case 2:
            // if (arr2[i] == 1)
            // answer.add("A");
            // if (arr2[i] == 3)
            // answer.add("B");
            // if (arr2[i] == 2)
            // answer.add("D");
            // break;
            // case 3:
            // if (arr2[i] == 1)
            // answer.add("B");
            // if (arr2[i] == 2)
            // answer.add("A");
            // if (arr2[i] == 3)
            // answer.add("D");
            // break;
            // default:
            // break;
            // }
        }

        return answer;
    }

    public static void main(String[] args) {
        가위바위보 T = new 가위바위보();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        for (String v : T.solution(n, arr1, arr2)) {
            System.out.println(v);
        }

    }

}
