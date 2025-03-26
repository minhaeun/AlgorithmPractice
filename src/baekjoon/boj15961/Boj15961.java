package baekjoon.boj15961;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15961 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj15961/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] count = new int[d + 1];
        int[] sushi = new int[N];

        for(int i = 0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int type = 0;
        for(int i = 0; i < k; i++){
            if(count[sushi[i]] == 0) type++;
            count[sushi[i]]++;
        }

        int ans = type;
        for(int start = 0; start < N; start++){
            int end = (start + k) % N;
            if(count[sushi[start]] == 1) type--;
            count[sushi[start]]--;
            if(count[sushi[end]] == 0) type++;
            count[sushi[end]]++;

            int maxType = type;
            if(count[c] == 0) maxType++;
            ans = Math.max(ans, maxType);
        }
        System.out.println(ans);
    }
}
