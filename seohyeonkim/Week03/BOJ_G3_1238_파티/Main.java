import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
     static class Node {
        int V, W;
        public Node(int v, int w) {
            V = v;
            W = w;
        }
    }

    static final int INF = 987654321;
    static List<Node>[] adjList;
    static int N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        
        //인접 리스트
        adjList = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            adjList[i] = new ArrayList<>();
        for(int i = 0; i < M; i++)
            adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            int go = dijkstra(i, X);
            int back = dijkstra(X, i);
            max = Math.max(max, go + back);
        }
        
        System.out.println(max);
    }

    static int dijkstra(int start, int end){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->(a.W - b.W));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(dist[curr.V] < curr.W)
                continue;
            for(Node node : adjList[curr.V]){
                if(dist[node.V] > curr.W + node.W){
                    dist[node.V] = curr.W + node.W;
                    pq.add(new Node(node.V, dist[node.V]));
                }
            }
        }
        return dist[end];
    }
}