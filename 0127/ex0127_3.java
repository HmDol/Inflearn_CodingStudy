import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex0127_3 {

    // 간선을 나타내는 클래스
    static class Node implements Comparable<Node> {
        int x, y, weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    // Disjoint Set을 위한 배열 및 find 함수
    static int[] parent;

    static int find(int v) {
        if (parent[v] == v) {
            return v;
        }

        parent[v] = find(parent[v]); // Path Compression
        return parent[v];
    }

    // 두 집합을 합치는 함수
    static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            parent[fa] = fb;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 정점의 수
            int n = Integer.parseInt(st.nextToken()); // 간선의 수

            if (m == 0 && n == 0) {
                break; // 입력 종료 조건
            }

            long max = 0; // 모든 간선의 가중치의 합
            parent = new int[m];

            // 각 정점의 부모 초기화
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();

            // 간선 정보를 우선순위 큐에 저장
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                max += z; // 모든 간선의 가중치 더하기
                pq.add(new Node(x, y, z));
            }

            long sum = 0;

            // Kruskal 알고리즘 수행
            while (!pq.isEmpty()) {
                final Node now = pq.poll();
                if (union(now.y, now.x)) {
                    sum += now.weight;
                }
            }

            // 최대 가중치에서 최소 신장 트리의 가중치를 빼고 출력
            bw.write(max - sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
