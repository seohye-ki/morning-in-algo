import java.util.*;
import java.io.*;

class ImPokemonMaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer, String> poke_num = new HashMap<>(); //숫자가 key인 map
        Map<String, Integer> poke_str = new HashMap<>(); //문자가 key인 map
        for(int i = 0; i < N; i++){
            String str = sc.next();
            poke_num.put(i, str);
            poke_str.put(str, i);
        }
        for(int i = 0; i < M; i++){
            String cmd = sc.next();
            //숫자라면
            if('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9')
                sb.append(poke_num.get(Integer.parseInt(cmd) - 1)).append('\n');
            //문자라면
            else
                sb.append(poke_str.get(cmd) + 1).append('\n');
        }
        System.out.println(sb);
    }
}