package DFS_BFS_기초;

public class 부분집합구하기 {
    static int n;
    static int[] ch;
    static int cnt = 0;

    public static void DFS(int L) {
        if (L == n + 1) {
            // for (int i = 1; i <= n; i++) { //공집합 출력됨
            // if (ch[i] == 1)
            // System.out.print(i + " ");
            // }
            // cnt++;
            // System.out.println();

            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
                cnt++;
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        n = 7;
        ch = new int[n + 1];
        DFS(1);
        System.out.println("총 " + cnt + "개");
    }
}
