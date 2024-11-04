import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;
    static int N;
    static int M;
    static int[][] map;
    static int[][] copy;

    public static class point{
        int x, y;
        
        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //세로
        M = sc.nextInt(); //가로
        map = new int[N][M]; //맵

        //input
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
        }

        //벽 3개 선택
        dfs(0);
        
        System.out.println(max);
    }

    static void dfs(int dept) {
        //벽 다 세움
        if(dept == 3){
            //copy
            copy = new int[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++)
                    copy[i][j] = map[i][j];
            }
            
            //virus 퍼지기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(copy[i][j] == 2){
                        copy[i][j] = 3;
                        bfs(i, j);
                    }
                }
            }
            
            //안전구역 크기
            int cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(copy[i][j] == 0)
                        cnt++;
                }
            }
            max = Math.max(cnt, max);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(dept + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(int row, int col) {
        Queue<point> q = new LinkedList<>();
        q.add(new point(row, col));

        while(!q.isEmpty()){
            point curr = q.poll();
            for(int k = 0; k < 4; k++){
                int i = curr.x + dr[k];
                int j = curr.y + dc[k];
                if(0 <= i && i < N && 0 <= j && j < M && copy[i][j] == 0){
                    copy[i][j] = 3;
                    q.add(new point(i, j));
                }
            }
        }
    }
}