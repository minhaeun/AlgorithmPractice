package baekjoon.boj10815;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj10815 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj10815/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            if(hashSet.contains(Integer.parseInt(st.nextToken())))  sb.append(1);
            else    sb.append(0);
            sb.append(" ");
        }

        System.out.println(sb.toString());

    }

}
