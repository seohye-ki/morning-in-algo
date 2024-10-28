import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int tc = 0; tc < T; tc++){
            int K = sc.nextInt();
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            
            for(int i = 0; i < K; i++){
                String cmd = sc.next();
                int num = sc.nextInt();
                
                //add
                if(cmd.charAt(0) == 'I')
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                //poll
                else{
                    //비어있지 않다면 빼내기
                    if(!treeMap.isEmpty()){
                        int value;
                        //최소값 빼내기
                        if(num < 0)
                            value = treeMap.firstKey();
                        //최대값 빼내기
                        else
                            value = treeMap.lastKey();
                        if(treeMap.get(value) == 1)
                            treeMap.remove(value);
                        else
                            treeMap.put(value, treeMap.get(value) - 1);
                    }
                }
            }
            if(treeMap.isEmpty())
                sb.append("EMPTY\n");
            else{
                sb.append(treeMap.lastKey()).append(" ");
                sb.append(treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}