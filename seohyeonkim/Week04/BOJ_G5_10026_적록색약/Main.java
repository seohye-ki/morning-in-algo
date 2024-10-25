import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr1;
    static int[][] arr2;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr1 = new int[N][N];
        arr2 = new int[N][N];
        visited = new boolean[N][N];

        //R: 0, G: 1, B: 2
        for(int i = 0; i < N; i++){
            String str = sc.next();
            for(int j = 0; j < N; j++){
                if(str.charAt(j) == 'R'){
                    arr1[i][j] = 1;
                    arr2[i][j] = 1;
                }
                else if(str.charAt(j) == 'G'){
                    arr1[i][j] = 2;
                    arr2[i][j] = 1;
                }
                else
                    arr1[i][j] = arr2[i][j] = 3;
            }
        }        

        //정상
        int cnt1 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == false) {
                    dfs(i, j, arr1[i][j], 0);
                    cnt1++;
                }
            }
        }

        //적록색약
        visited = new boolean[N][N];
        int cnt2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] == false) {
                    dfs(i, j, arr2[i][j], 1);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    static void dfs(int i, int j, int value, int type){
        visited[i][j] = true;

        for(int k = 0; k < 4; k++){
            int row = i + dr[k];
            int col = j + dc[k];
            if(0 <= row && row < N && 0 <= col && col < N && !visited[row][col]){
                if(type == 0){
                    if(arr1[row][col] == value)
                        dfs(row, col, value, type);
                }
                else {
                    if(arr2[row][col] == value)
                        dfs(row, col, value, type);
                }
            }
        }
    }
}