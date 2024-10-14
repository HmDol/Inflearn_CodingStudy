import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex0127_2 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] time = br.readLine().split(":");
		int M = Integer.parseInt(time[0]);
		int S = Integer.parseInt(time[1]);

        int cnt = 0; // 버튼 누르는 횟수

        if (S >= 30) {// 30초보다 클 경우

            cnt += M / 10;
            cnt += M % 10;

            cnt += (S - 30) / 10; // 30초 보다 작은 단위처리
            cnt++; // 30초 + 조리시작

        } else { // 30초 보다 작을 경우

            cnt += M / 10;
            cnt += M % 10;

            cnt += S / 10; // 10버튼
            cnt++; // 조리시작 버튼
        }
        System.out.println(cnt);

        

    }
}
