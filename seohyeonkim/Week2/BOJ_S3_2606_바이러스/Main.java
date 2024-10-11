import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] network;
    static boolean[] visited;
    static int N;
    static int[] dc = {-1, 1, 0, 0};
    static int[] dr = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //컴퓨터 수
        int M = sc.nextInt(); //간선 수

        //인접행렬
        network = new int[N][N];
        for(int i = 0; i < N; i++)
            network[i][i] = 1;
        
        for(int i = 0; i < M; i++){
            int com1 = sc.nextInt() - 1;
            int com2 = sc.nextInt() - 1;
            network[com1][com2] = 1;
            network[com2][com1] = 1;
        }
        
        visited = new boolean[N];
        dfs(0);
        int cnt = 0;
        for(int i = 1; i < N; i++){
            if(visited[i])
                cnt++;
        }
        System.out.println(cnt);
    }

    public static void dfs(int start){
        visited[start] = true;
        
        for(int i = 0; i < N; i++){
            if(!visited[i] && network[start][i] == 1)
                dfs(i);
        }
    }
}