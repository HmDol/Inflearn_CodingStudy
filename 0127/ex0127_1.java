import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex0127_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 양동이의 개수
        int K = Integer.parseInt(st.nextToken());  // K만큼 떨어진 거리

        // 각 좌표에 따른 얼음 양을 저장하는 배열
        long[] IceBoxes = new long[1000001];

        // 양동이의 정보 입력 및 좌표에 따른 얼음 양 누적
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());  // 얼음의 양
            int x = Integer.parseInt(st.nextToken());  // 양동이의 좌표
            IceBoxes[x] += g; // 각 위치에 얼음의 양의 누적합을 표시
        }

        long sum = 0;  // 현재 위치부터 K만큼의 거리에 있는 얼음 양의 합
        long max = 0;  // 최대 얼음 양

        // K가 배열의 크기 이상인 경우, 모든 얼음 양을 합하여 출력
        if (1000000 <= K) {
            for (int i = 0; i <= 1000000; i++) {
                sum += IceBoxes[i];
            }
            System.out.println(sum);
            return;
        }

        // 처음 K만큼의 거리에 있는 얼음 양의 합 계산
        for (int i = 0; i <= K; i++) {
            sum += IceBoxes[i];
        }
        
        for(int i=0; i < 18; i++){
            System.out.print(i + " : " + IceBoxes[i] + " / ");
        }
        // 슬라이딩 윈도우를 이용하여 최대 얼음 양 구하기
        for (int i = 0; i + K < 1000000; i++) {
            sum += IceBoxes[i + K + 1];  // 윈도우의 끝에 있는 얼음 양 추가
            if (i - K - 1 >= 0)
                sum -= IceBoxes[i - K - 1];  // 윈도우의 시작을 벗어난 얼음 양 제거
            max = Math.max(sum, max);  // 현재까지의 합 중에서 최대값 갱신
        }

        // 최대 얼음 양 출력
        System.out.println(max);
    }
}
//k = 3
// 0 : 0 / 1 : 5 / 2 : 2 / 3 : 0 / 4 : 0 / 5 : 0 / 6 : 0 / 7 : 4 / 8 : 0 / 9 : 0 / 
// 
// sum = 5 
