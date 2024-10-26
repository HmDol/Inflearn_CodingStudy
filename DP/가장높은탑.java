package DP;

import java.util.*;

class Stone implements Comparable<Stone> {
    public int s, h, w;

    public Stone(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Stone o) {
        // TODO Auto-generated method stub
        return o.s - this.s;
    }
}

public class 가장높은탑 {
    static ArrayList<Integer> dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Stone> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Stone(s, h, w));
        }
        Collections.sort(list);

        solution(n, list);

        Collections.sort(dy);

        System.out.println(dy.get(dy.size() - 1));
    }

    public static void solution(int n, ArrayList<Stone> list) {
        dy = new ArrayList<>();
        dy.add(list.get(0).h);
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).w < list.get(j).w) {
                    max = Math.max(max, dy.get(j));
                }
            }
            if (max == 0) {
                dy.add(list.get(i).h);
            } else {
                dy.add(list.get(i).h + max);
            }
        }

    }
}
