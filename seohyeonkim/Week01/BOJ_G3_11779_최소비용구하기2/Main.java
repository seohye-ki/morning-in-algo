import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Node{
        int V;
        int W;

        Node(int v, int w) {
            V = v;
            W = w;
        }
    }

    static int V;
    static int E;
    static List<Node>[] adjList;
    static int dist[];
    static int pre[];
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        //인접리스트 초기화
        adjList = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adjList[i] = new ArrayList<>();

        //인접리스트 입력받기
        for(int i = 0; i < E; i++)
            adjList[sc.nextInt() - 1].add(new Node(sc.nextInt() - 1, sc.nextInt()));
        
        //dist배열 초기화
        dist = new int[V];
        Arrays.fill(dist, INF);

        //다익스트라
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        dijkstra(start);

        //경로 구하기
        Stack<Integer> stack = new Stack<>();
        stack.push(end + 1);
        int i = end;
        while(pre[i] != start){
            stack.push(pre[i] + 1);
            i = pre[i];
        }
        stack.push(start + 1);

        //출력
        System.out.println(dist[end]);
        System.out.println(stack.size());
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void dijkstra(int start){
        boolean[] visited = new boolean[V];
        pre = new int[V];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->(a.W - b.W));

        //초기설정
        visited[start] = true;
        dist[start] = 0;
        pre[start] = start;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            //최솟값으로 나온값이 이미 저장되어있는 값보다 크다면
            if(dist[curr.V] < curr.W)
                continue;
            //갱신하기
            for(Node node : adjList[curr.V]){
                //작으면 갱신
                if(dist[node.V] > dist[curr.V] + node.W){
                    dist[node.V] = dist[curr.V] + node.W;
                    pq.add(new Node(node.V, (dist[curr.V] + node.W)));
                    pre[node.V] = curr.V;
                }
            }
        }
    }
}