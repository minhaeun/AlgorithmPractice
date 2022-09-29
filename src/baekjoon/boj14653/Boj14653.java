package baekjoon.boj14653;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14653 {
    static int N, K, Q;
    static boolean[] read;
    static int name[], count[];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj14653/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        read = new boolean[26];
        name = new int[10001];
        count = new int[10001];

        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            count[i] = Integer.parseInt(st.nextToken());
            name[i] = st.nextToken().charAt(0) - 'A';
        }

        if(count[Q] == 0){
            System.out.println(-1);
            return;
        }

        for(int i = K; i >= Q; i--){
            read[name[i]] = true;
            if(count[i] == count[i-1]){
                read[name[i-1]] = true;
            }
        }




        for(int i = 1; i < N; i++){
            if(!read[i]) sb.append((char)(i + 'A') + " ");
        }
        System.out.println(sb.toString().trim());

    }
}
