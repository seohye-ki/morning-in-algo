import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int x, int y, int n) {
        
        answer = -1;
        
        method(x, y, n);
        
        return answer;
    }
    void method(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        
        if (x==y) {
            answer = 0;
            return;
        }
        
        boolean[] visited = new boolean[y];
        
        int[] start = {x, 0};
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int curr_x = curr[0];
            int depth = curr[1];
            
            if (curr_x+n==y || curr_x*2==y || curr_x*3==y) {
                answer = depth + 1;
                break;
            }
            
            if (curr_x+n < y && !visited[curr_x+n]) {
                int[] one = {curr_x+n, depth+1};
                queue.add(one);
                visited[curr_x+n] = true;
            }
            
            if (curr_x*2 < y && !visited[curr_x*2]) {
                int[] two = {curr_x*2, depth+1};
                queue.add(two);
                visited[curr_x*2] = true;
            }
            
            if (curr_x*3 < y && !visited[curr_x*3]) {
                int[] three = {curr_x*3, depth+1};
                queue.add(three);
                visited[curr_x*3] = true;
            }
        }
    }
}
