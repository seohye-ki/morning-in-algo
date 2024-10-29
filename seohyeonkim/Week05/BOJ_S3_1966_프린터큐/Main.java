import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            int N = sc.nextInt(); //문서 개수
            int idx = sc.nextInt(); //확인하고 싶은 문서
            int[] arr = new int[N]; //중요도 정렬
            Queue<int[]> queue = new LinkedList<>(); //프린터 큐
            //input
            for(int i = 0; i < N; i++){
                int num = sc.nextInt();
                arr[i] = num; //배열에 넣기
                queue.add(new int[] {num, i}); //큐에 넣기
            }
            
            int cnt = 1;
            int maxidx = N - 1;
            Arrays.sort(arr);
            int[] now;
            while(true){
                now = queue.poll();
                if(now[0] != arr[maxidx])
                    queue.add(now);
                else{
                    if(now[1] == idx){
                        sb.append(cnt).append("\n");
                        break;
                    }
                    maxidx--;
                    cnt++;
                }
            }
        }
        System.out.println(sb);
    }
}