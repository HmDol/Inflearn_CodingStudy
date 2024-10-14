import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 포탈 정보를 저장
class Edge {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class ex0203_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((br.readLine()));

        int N = Integer.parseInt(st.nextToken()); // 방의 개수
        int M = Integer.parseInt(st.nextToken()); // 워프의 개수

        Edge[] edges = new Edge[M]; // 워프 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer((br.readLine()));
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        int[] escapeTimes = new int[N]; // 비상탈출문 정보 저장
        st = new StringTokenizer((br.readLine()));
        for (int i = 0; i < N; i++) {
            escapeTimes[i] = Integer.parseInt(st.nextToken());
        }

        // Kruskal 알고리즘을 사용하여 최소 스패닝 트리 구하기
        Arrays.sort(edges, Comparator.comparingInt(e -> e.cost));

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int totalEscapeTime = 0;
        for (Edge edge : edges) {
            int rootA = find(parent, edge.from);
            int rootB = find(parent, edge.to);

            if (rootA != rootB) {
                totalEscapeTime += edge.cost;
                union(parent, rootA, rootB);
            }
        }

        // 비상탈출구 설치 시간 추가
        for (int i = 0; i < N; i++) {
            totalEscapeTime += escapeTimes[i];
        }

        System.out.println(totalEscapeTime);
    }

    private static int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent, parent[node]);
    }

    private static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}
