import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int M;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            M = sc.nextInt(); //가로
            N = sc.nextInt(); //세로
            int K = sc.nextInt(); //배추 개수
            
            map = new int[N][M];
            for(int i = 0; i < K; i++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                map[x][y] = 1;
            }
            
            cnt = 0;
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int i, int j){
        visited[i][j] = true;

         for(int k = 0; k < 4; k++){
             int row = i + dr[k];
             int col = j + dc[k];
             if(0 <= row && row < N && 0 <= col && col < M && !visited[row][col] && map[row][col] == 1)
                 dfs(row, col);
         }
    }
}