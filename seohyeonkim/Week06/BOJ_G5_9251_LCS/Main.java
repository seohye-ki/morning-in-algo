import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int[][] dp = new int[1001][1001];
        
        //초기화
        if(str1.charAt(0) == str2.charAt(0))
            dp[0][0] = 1;
        else
            dp[0][0] = 0;
        
        for(int i = 1; i < str2.length(); i++){
            if(str1.charAt(0) == str2.charAt(i) || dp[0][i - 1] == 1)
                dp[0][i] = 1;                
        }
        
        for(int i = 1; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    if(j == 0)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[str1.length() - 1][str2.length() - 1]);
    }
}
