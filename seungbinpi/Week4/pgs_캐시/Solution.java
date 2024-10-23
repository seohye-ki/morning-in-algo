import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int N = cities.length;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Queue<String> cache = new LinkedList<>();
        Queue<String> tmp = new LinkedList<>();
        
        int time = 0;
        
        for (int i=0; i<N; i++) {
            String curr = cities[i].toLowerCase();
            boolean isInCache = false;
            
            int iter = cache.size();
            for (int j=0; j<iter; j++) {
                String inCache = cache.poll();
                if (curr.equals(inCache))
                    isInCache = true;
                else
                    tmp.offer(inCache);
            }
            
            while (!tmp.isEmpty()) 
                cache.offer(tmp.poll());
            
            if (isInCache) {
                cache.offer(curr);
                time += 1;
            }
            else {
                time += 5;
                if (cache.size() == cacheSize)
                    cache.poll();
                cache.offer(curr);
            }
        }
        return time;
    }
}