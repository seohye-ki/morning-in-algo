import java.util.*;

class Solution {
    public long solution(int[] weights) {
        int N = weights.length;
        
        int[] count = new int[1001];
        
        for (int i=0; i<N; i++) {
            count[weights[i]]++;
        }
        
        long result = 0;
        for (int i=100; i<=999; i++) {
            if (count[i] == 0) continue;
            if (count[i] > 1) result += ((long)count[i]*((long)count[i]-1)/2);
            
            for (int j=i+1; j<=1000; j++) {
                if (count[j] == 0) continue;
                if (2*i==j || 3*i==2*j || 4*i==3*j) {
                    result += ((long)count[i] * (long)count[j]);
                }
            }
        }
        if (count[1000] > 1) result += ((long)count[1000]*((long)count[1000]-1)/2);
        return result;
    }
}