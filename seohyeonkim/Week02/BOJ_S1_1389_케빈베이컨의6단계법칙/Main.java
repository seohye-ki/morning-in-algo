import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static final int INF = 987654321;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adjArr = new int[V + 1][V + 1];

        //인접행렬 초기화
        for(int i = 1; i <= V; i++){
            Arrays.fill(adjArr[i], INF);
            adjArr[i][i] = 0;
        }
        
        for(int i  = 0; i < E; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adjArr[x][y] = 1;
            adjArr[y][x] = 1;
        }

        //플로이드 워셜
        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    if(adjArr[i][j] > adjArr[i][k] + adjArr[k][j])
                        adjArr[i][j] = adjArr[i][k] + adjArr[k][j];
                }
            }
        }
        
        //가장 작은 사람 찾기
        int min = INF;
        int num = 0;
        for(int i = 1; i <= V; i++){
            int sum = 0;
            for(int j = 1; j <= V; j++){
                if(adjArr[i][j] != INF)
                    sum += adjArr[i][j];
            }
            if(min > sum){
                min = sum;
                num = i;
            }
        }
        System.out.println(num);
    }
}