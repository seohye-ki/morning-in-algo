import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static long[] heap = new long[100010];
    static int size = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            long num = sc.nextLong();
            if(num == 0){
                long min = poll(); //값 제거
                sb.append(min).append("\n");
            }
            else
                add(num); //값 추가
        }
        System.out.println(sb);
    }

    static void heapify(int idx) {
        int min = idx;
        int left = idx * 2;
        int right = idx * 2 + 1;

        if(left <= size && heap[left] < heap[min])
            min = left;

        if(right <= size && heap[right] < heap[min])
            min = right;

        if(min != idx){
            long tmp = heap[idx];
            heap[idx] = heap[min];
            heap[min] = tmp;
            heapify(min);
        }
    }
    
    static long poll() {
        if(size == 0) //heap이 비어있다면
            return 0;
        
        long min = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;
        size--;
        heapify(1);
        return min;
    }

    static void add(long num) {
        size++;
        heap[size] = num;
        int idx = size;
        while(idx > 1){
            if(heap[idx] < heap[idx / 2]){
                long tmp = heap[idx];
                heap[idx] = heap[idx / 2];
                heap[idx / 2] = tmp;
                idx = idx / 2;
            }
            else
                break;
        }
    }
}