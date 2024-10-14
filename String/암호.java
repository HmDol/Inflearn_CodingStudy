package String;

import java.util.Scanner;

public class 암호 {
    public String solution(int n, String str) {
        String answer = "";

        int num = 0;
        for (int r = 0; r < n; r++) {
            int result = 0;
            int t = 64;
            for (int i = 0; i < 7; i++) {
                if (str.length() - 1 < num) {
                    // System.out.println("TEST");
                    break;
                }
                if (str.charAt(num) == '#') {
                    // System.out.println(i);
                    result += t;
                }
                t /= 2;
                num++;
            }
            answer += (char) result;
        }

        return answer;
    }

    public static void main(String[] args) {
        암호 T = new 암호();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(num, str));

    }

}
