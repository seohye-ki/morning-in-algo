import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int cnt = 0;
    static int[][] map;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();
        }

        //state 1:가로 2:세로 3:대각선
        dfs(0, 1, 1);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int state){
        //도달했다면
        if(x == N - 1 && y == N - 1){
            cnt++;
            return;
        }

        //가로 상태일때
        if(state == 1) {
            //가로 두기
            if(y + 1 < N && map[x][y + 1] == 0)
                dfs(x, y + 1, 1);
            //대각선 두기
            if(y + 1 < N && x + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0)
                dfs(x + 1, y + 1, 3);
        }
        //세로 상태일때
        else if(state == 2) {
            //세로 두기
            if(x + 1 < N && map[x + 1][y] == 0)
                dfs(x + 1, y, 2);
            //대각선 두기
            if(y + 1 < N && x + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0)
                dfs(x + 1, y + 1, 3);
        }
        //대각선 상태일때
        else {
            //가로 두기
            if(y + 1 < N && map[x][y + 1] == 0)
                dfs(x, y + 1, 1);
            //세로 두기
            if(x + 1 < N && map[x + 1][y] == 0)
                dfs(x + 1, y, 2);
            //대각선 두기
            if(y + 1 < N && x + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0)
                dfs(x + 1, y + 1, 3);
        }
    }
}