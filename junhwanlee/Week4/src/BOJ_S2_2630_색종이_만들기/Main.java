import java.util.Scanner;

public class Main {
    private static int w = 0;
    private static int b = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }

        cC(paper, N, 0, 0);
        System.out.println(w);
        System.out.println(b);
    }

    private static void cC(int[][] paper, int s, int r, int c) {
        if (can(paper, s, r, c)) {
            if (paper[r][c] == 0) {
                w++;
            } else {
                b++;
            }
            return;
        }

        int nS = s / 2;
        cC(paper, nS, r, c);
        cC(paper, nS, r, c + nS);
        cC(paper, nS, r + nS, c); 
        cC(paper, nS, r + nS, c + nS);
    }

    private static boolean can(int[][] paper, int s, int r, int c) {
        int color = paper[r][c];
        for (int i = r; i < r + s; i++) {
            for (int j = c; j < c + s; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
