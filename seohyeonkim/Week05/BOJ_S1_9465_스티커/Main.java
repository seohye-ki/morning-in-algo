import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            int n = sc.nextInt();
            int[][] sticker = new int[2][100001];
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < n; j++)
                    sticker[i][j] = sc.nextInt();
            }

            int[][] dp = new int[2][100001];
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];
            for(int i = 2; i < n; i++){
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
                
            }
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}