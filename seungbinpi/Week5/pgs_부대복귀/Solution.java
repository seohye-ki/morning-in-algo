import java.util.*;

class Solution {
    
    static int n;
    static int[][] roads;
    static int[] sources;
    static int destination;
    static int[] result;
    static List<Integer>[] link;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.n = n;
        this.roads = roads;
        this.sources = sources;
        this.destination = destination;
        result = sources;
        
        link = new List[n+1];
        for (int i=0; i<roads.length; i++) {
            int node1 = roads[i][0];
            int node2 = roads[i][1];
            
            if (link[node1] == null)
                link[node1] = new ArrayList<Integer>();
            if (link[node2] == null)
                link[node2] = new ArrayList<Integer>();
            
            link[node1].add(node2);
            link[node2].add(node1);
        }
        
        for (int i=0; i<sources.length; i++) {
            int source = sources[i];
            result[i] = -1;
            method(destination, source, i);
        }
        
        
        return result;
    }
    static void method(int start, int end, int index) {
        if (start == end) {
            result[index] = 0;
            return;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        int[] startNode = {start, 0};
        queue.add(startNode);
        
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0];
            int currDepth = curr[1];
            
            if (link[currNode] == null) continue;
            
            for (int i=0; i<link[currNode].size(); i++) {
                int node = link[currNode].get(i);
                if (node == end) {
                    result[index] = currDepth+1;
                    return;
                }
                
                if (visited[node]) continue;
                
                int[] tmp = {node, currDepth+1};
                queue.add(tmp);
                visited[node] = true;
            }
        }
    }
}