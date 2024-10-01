import java.util.*;

class Solution {
    public int solution(int[] money) {
        
        int N = money.length;
        
        int[] dp0 = new int[N];
        int[] dp1 = new int[N];
        
        if (N==3) {
            return Math.max(money[2], Math.max(money[1], money[0]));
        }
        
        // dp0
        dp0[0] = dp0[1] = money[0];        
        for (int i=2; i<N-1; i++) {
            dp0[i] = Math.max(dp0[i-1], dp0[i-2]+money[i]);
        }
        
        // dp1
        dp1[0] = 0;
        dp1[1] = money[1];
        for (int i=2; i<N; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
        }
        
        int moneyStolen = Math.max(dp0[N-2], dp1[N-1]);
        
        
        return moneyStolen;
    }
}