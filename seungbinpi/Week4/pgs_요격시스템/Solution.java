import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        Arrays.sort(targets, (a, b) -> a[0] - b[0]);
        
        int N = targets.length;
        
        int count = 0;
        int index = 0;
        
        while (index < N) {
            int start = targets[index][0];
            int end = targets[index++][1];
            
            if (index == N) {
                count++;
                break;
            }
            
            while (index < N) {
                if (targets[index][0] < end)
                    end = Math.min(end, targets[index++][1]);
                else {
                    count++;
                    break;
                }
            }
            if (index == N)
                count++;
        }
        
        return count;
    }
}
