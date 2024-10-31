import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            String cmd = sc.next(); //명령어
            int n = sc.nextInt(); //deque에 들어있는 숫자 개수
            
            //parsing
            Deque<Integer> deque = new ArrayDeque<>();
            String parse = sc.next();
            parse = parse.replace("[", "");
            parse = parse.replace("]", "");
            String[] arr = parse.split(",");
            for(int i = 0; i < n; i++)
                deque.add(Integer.parseInt(arr[i]));

            //cmd
            boolean flag = false; //flase면 앞에서 true면 뒤에서
            int idx = 0;
            while(idx < cmd.length()){
                //reverse
                if(cmd.charAt(idx) == 'R')
                    flag = !flag;
                //delete
                else {
                    if(deque.size() > 0){
                        if(flag)
                            deque.pollLast();
                        else
                            deque.pollFirst();
                    }
                    else{
                        sb.append("error\n");
                        break;
                    }
                }
                idx++;
            }

            //print
            if(idx == cmd.length()){
                sb.append("[");
                while(!deque.isEmpty()){
                    if(flag)
                        sb.append(deque.pollLast());
                    else
                        sb.append(deque.pollFirst());
                    if(!deque.isEmpty())
                        sb.append(",");
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}