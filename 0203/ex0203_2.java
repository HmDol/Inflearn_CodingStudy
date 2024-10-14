//https://velog.io/@silver_star/%EB%B0%B1%EC%A4%80-17485-%EC%A7%84%EC%9A%B0%EC%9D%98-%EB%8B%AC-%EC%97%AC%ED%96%89-Large-DP

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex0203_2 {
    static int n;
    static int m;
    static int[][] map;
    static int[][][] dp;
    static int minCost = Integer.MAX_VALUE;

    static void solution(){
        for(int i=1; i < n; i++){// 첫행은 초기화 이미 완료 -> 1부터 시작
            for(int j=0; j< m; j++){
                if(isValid(i-1,j+1)) // 전에서 0의 경우가 가능한 값인지 
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2]) + map[i][j];
                if(isValid(i-1, j))  // 전에서 1의 경우가 가능한 값인지    
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];
                if(isValid(i-1, j-1)) // 전에서 2의 경우가 가능한 값인지
                    dp[i][j][2] = Math.min(dp[i-1][j-1][0],dp[i-1][j-1][1]) + map[i][j];
            }
        }
        for(int j =0; j < m; j++){
            for(int k = 0; k < 3; k++){
                if(minCost > dp[n-1][j][k]) // 마지막행의 k값 중 최소값 찾기
                    minCost = dp[n-1][j][k];
            }
        }
    }
    static boolean isValid(int y, int x){
        return (0 <= y && y < n ) && (0 <= x && x < m);
    }
    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));

        n = Integer.parseInt(st.nextToken()); // 행 수
        m = Integer.parseInt(st.nextToken()); // 열수
        map = new int[n][m];
        dp = new int[n][m][3]; // 해당 부분의 최단 경로르 저장
        // 0 : 이전에서 왼쪽 대각선 아래
        // 1 : 이전에서 아래
        // 2 : 이전에서 오른쪽 대각선 아래

        for(int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0){
                    //dp 초기 첫행 초기화
                    dp[i][j][0] = map[i][j];
                    dp[i][j][1] = map[i][j];
                    dp[i][j][2] = map[i][j];
                    
                }else if(j == m-1){ 
                    // 오른쪽 끝의 경우 0은 불가능
                    dp[i][j][0] = Integer.MAX_VALUE;

                }else if(j == 0){
                    // 왼쪽 끝의 경우 2는 불가능
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
            }
        }
        solution();
        System.out.println(minCost);
    } 

}
