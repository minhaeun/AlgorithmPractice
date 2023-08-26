package baekjoon.boj20920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj20920 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20920/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.length() < M)    continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    if(o1.getKey().length() == o2.getKey().length()){
                        return  o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getKey().length() - o1.getKey().length();
                }
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry: list){
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);

    }
}
