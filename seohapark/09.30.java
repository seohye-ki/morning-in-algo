import java.util.Scanner;

public class Solution {
    static int N, minDiff, synergy[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            synergy = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    synergy[i][j] = sc.nextInt();
            minDiff = Integer.MAX_VALUE;
            comb(0, 0, new boolean[N]);
            System.out.println("#" + t + " " + minDiff);
        }
    }

    static void comb(int idx, int count, boolean[] sel) {
        if (count == N / 2) {
            int diff = 0;
            for (int i = 0; i < N; i++)
                for (int j = i + 1; j < N; j++)
                    if (sel[i] == sel[j])
                        diff += sel[i] ? synergy[i][j] + synergy[j][i] : -(synergy[i][j] + synergy[j][i]);
            minDiff = Math.min(minDiff, Math.abs(diff));
            return;
        }
        if (idx < N) {
            sel[idx] = true;
            comb(idx + 1, count + 1, sel);
            sel[idx] = false;
            comb(idx + 1, count, sel);
        }
    }
}
