import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            int n = sc.nextInt();
            long[] dp = new long[101];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            for(int i = 5; i <= n; i++)
                dp[i] = dp[i - 1] + dp[i - 5];
            System.out.println(dp[n]);
        }
    }
}