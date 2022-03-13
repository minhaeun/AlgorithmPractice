
package baekjoon.brute_force.boj1107;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1107 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/brute_force/boj1107/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broke = new boolean[10];

        if(M != 0)
            st = new StringTokenizer(br.readLine(), " ");

        // 0 ~ 9 까지 버튼 중 고장난 버튼은 true로 바꾸기
        for(int i = 0; i < M; i++){
            broke[Integer.parseInt(st.nextToken())] = true;
        }

        if(N == 100){
            System.out.println(0);
            return;
        }

        int ans = Math.abs(N - 100);
        for(int i = 0; i <= 1000000; i++){
            String str = String.valueOf(i);

            boolean isPossible = true;
            for(int j = 0; j < str.length(); j++){
                int btn = str.charAt(j) - '0';
                if(broke[btn]){
                    isPossible = false;
                    break;
                }
            }

            if(isPossible){
                int cnt = str.length() + Math.abs(i - N);
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);

    }
}
