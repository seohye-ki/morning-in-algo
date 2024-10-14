import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cost = new int[N][3];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 3; j++)
                cost[i][j] = sc.nextInt();
        }
        
        dp = new int[N][3];
        //초기값 설정
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        //빨강으로 시작
        int min_r = coloring(N - 1, 0);
        //초록으로 시작
        int min_g = coloring(N - 1, 1);
        //파랑으로 시작
        int min_b = coloring(N - 1, 2);
        
        System.out.println(Math.min(Math.min(min_r, min_g) , min_b));
    }

    public static int coloring(int cnt, int color){
        if(dp[cnt][color] == 0){
            //빨간색을 칠하고 싶을때
            if(color == 0){
                dp[cnt][0] = Math.min(coloring(cnt - 1, 1), coloring(cnt - 1, 2)) + cost[cnt][0];
            }
            //초록색을 칠하고 싶을때
            else if(color == 1){
                dp[cnt][1] = Math.min(coloring(cnt - 1, 0), coloring(cnt - 1, 2)) + cost[cnt][1];
            }
            //파란색을 칠하고 싶을때
            else{
                dp[cnt][2] = Math.min(coloring(cnt - 1, 0), coloring(cnt - 1, 1)) + cost[cnt][2];
            }
        }

        return dp[cnt][color];
    }
}