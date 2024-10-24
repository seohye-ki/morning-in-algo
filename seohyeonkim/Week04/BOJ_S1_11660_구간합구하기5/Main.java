import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int num = sc.nextInt();
                arr[i][j] += num;
                if(i > 0)
                    arr[i][j] += arr[i - 1][j];
                if(j > 0)
                    arr[i][j] += arr[i][j - 1];
                if(i > 0 && j > 0)
                    arr[i][j] -= arr[i - 1][j - 1];
            }
        }
        for(int i = 0; i < M; i++){
            int x1 = sc.nextInt() - 1;
            int y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;
            int sum = arr[x2][y2];
            if(y1 > 0)
                sum -= arr[x2][y1 - 1];
            if(x1 > 0)
                sum -= arr[x1 - 1][y2];
            if(x1 > 0 && y1 > 0)
                sum += arr[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}