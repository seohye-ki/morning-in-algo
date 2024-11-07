import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static final int INF = 987654321;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 0)
                    arr[i][j] = INF;
            }
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] > arr[k][j] + arr[i][k])
                        arr[i][j] = arr[k][j] + arr[i][k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] >= INF)
                    sb.append("0 ");
                else
                    sb.append("1 ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}