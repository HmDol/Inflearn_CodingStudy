import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex0203_1 {
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 가로 및 세로 크기 입력 받기
        int C = Integer.parseInt(st.nextToken());  // 가로 크기
        int R = Integer.parseInt(st.nextToken());  // 세로 크기

        // 결과값을 100000으로 나눈 나머지를 출력하기 위한 모듈러 변수
        int mod = 100000;

        // dp 배열 초기화
        dp = new long[R + 1][C + 1][4];

        // 초기 조건 설정
        for (int i = 1; i <= R; i++) {
            dp[i][1][0] = 1;  // 맨 왼쪽 열에서 위로 올라가는 경우의 수는 1
        }

        for (int j = 1; j <= C; j++) {
            dp[1][j][2] = 1;  // 맨 위 행에서 왼쪽으로 가는 경우의 수는 1
        }

        // 동적 계획법(DP)을 이용하여 각 지점까지의 경우의 수 계산
        for (int i = 2; i <= R; i++) {
            for (int j = 2; j <= C; j++) {
                // 위에서 내려오는 경우의 수 계산
                dp[i][j][0] = (dp[i - 1][j][1] + dp[i - 1][j][0]) % mod;
                dp[i][j][1] = dp[i - 1][j][2];

                // 왼쪽에서 오는 경우의 수 계산
                dp[i][j][2] = (dp[i][j - 1][3] + dp[i][j - 1][2]) % mod;
                dp[i][j][3] = dp[i][j - 1][0];
            }
        }

        // 최종 결과 계산
        long ans = 0;
        for (int k = 0; k < 4; k++) {
            ans += dp[R][C][k];
        }

        // 결과값을 100000으로 나눈 나머지 출력
        System.out.println(ans % mod);
    }
}
