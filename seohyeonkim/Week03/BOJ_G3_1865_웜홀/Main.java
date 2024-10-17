import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int W;
    static final int INF = 987654321;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            N = sc.nextInt(); //정점 수
            M = sc.nextInt(); //양방향 간선 수
            W = sc.nextInt(); //단방향 간선 수
            
            //인접행렬
            int[][] dist = new int[N][N];
            //초기화
            for(int i = 0; i < N; i++){
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            //양방향 간선 입력
            for(int i = 0; i < M; i++){
                int start = sc.nextInt() - 1;
                int end = sc.nextInt() - 1;
                int cost = sc.nextInt();
                dist[start][end] = Math.min(dist[start][end], cost);
                dist[end][start] = Math.min(dist[end][start], cost);
            }

            //단방향 간선 입력
            for(int i = 0; i < W; i++){
                int start = sc.nextInt() - 1;
                int end = sc.nextInt() - 1;
                int cost = sc.nextInt() * -1;
                dist[start][end] = Math.min(dist[start][end], cost);
            }
            
            //플로이드 워셜
            for(int k = 0; k < N; k++){
                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        if(dist[i][j] > dist[i][k] + dist[k][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }

            //유효한 값 찾기
            boolean result = check(dist);
            if(result)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(int[][] dist){
        for(int i = 0; i < N; i++){
            if(dist[i][i] < 0)
                return true;
        }

        return false;
    }
}