import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[301];
        for(int i = 1; i <= n; i++)
            stair[i] = Integer.parseInt(br.readLine());
        int dp[] = new int[301];
        dp[0] = 0;
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        for(int i = 3; i <= n; i++)
            dp[i] = Math.max(stair[i] + dp[i - 2], stair[i] + stair[i - 1] + dp[i - 3]);
        System.out.println(dp[n]);
    }
}