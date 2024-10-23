import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b)->(b - a));
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            if(num == 0) {
                //둘다 비어있을때
                if(minheap.isEmpty() && maxheap.isEmpty())
                    sb.append(0).append("\n");
                //minheap만 비어있을때
                else if(minheap.isEmpty())
                    sb.append(maxheap.poll()).append("\n");
                //maxheap만 비어있을때
                else if(maxheap.isEmpty())
                    sb.append(minheap.poll()).append("\n");
                else{
                    if(Math.abs(minheap.peek()) < Math.abs(maxheap.peek()))
                        sb.append(minheap.poll()).append("\n");
                    else
                        sb.append(maxheap.poll()).append("\n");
                    
                }
                    
            }
            else {
                //음수는 maxheap
                if(num < 0)
                    maxheap.add(num);
                //양수는 minheap
                else
                    minheap.add(num);
            }
        }
        System.out.println(sb);
    }
}