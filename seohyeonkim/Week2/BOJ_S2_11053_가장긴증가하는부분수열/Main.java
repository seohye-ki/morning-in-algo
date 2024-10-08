import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int max = Integer.MIN_VALUE;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if(dp[i] == 0)
                dp[i] = 1;
            if(max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}