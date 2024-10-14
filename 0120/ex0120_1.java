
import java.io.*;
import java.util.StringTokenizer;

public class ex0120_1 {

    static long binarySearch(int index) {
        int lo = index, hi = N;
        long value = ink[index];
        while(lo+1<hi) {
            int mid = (hi-lo)/2 + lo;

            if(viscosity[mid]>value) {
                hi = mid;
            }
            else {
                lo =mid; 
            }
        }
        return lo-index;


    }
    static int N;
    static long[] ink;
    static long[] viscosity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄 토큰화
         ink = new long[N]; // 잉크지수
         viscosity = new long[N]; //점도 지수
        for(int i = 0;i<N;i++) {
            ink[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()); // 한줄 토큰화

        for(int i = 0;i<N;i++) {
            viscosity[i] = Long.parseLong(st.nextToken());
        }

        for(int i = 0;i<N;i++) {

            bw.write(binarySearch(i)+" ");

        }

bw.flush();bw.close();
    }
}