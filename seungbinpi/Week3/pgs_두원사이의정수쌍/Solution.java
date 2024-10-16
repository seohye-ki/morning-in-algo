class Solution {
    
    public long solution(int r1, int r2) {
        
        long result = (r2 - r1 + 1);
        
        for (int i=1; i<r2; i++) {
            for (int j=1; j<r2; j++) {
                long tmp = i*i + j*j;
                if (tmp<r1*r1) continue;
                if (tmp>r2*r2) break;
                result++;
            }
        }
        
        return 4*result;
    }
}