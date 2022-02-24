
package baekjoon.boj1107;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1107 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj1107/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cur = 100;
        int M = Integer.parseInt(br.readLine());
        boolean[] broke = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 0 ~ 9 까지 버튼 중 고장난 버튼은 true로 바꾸기
        for(int i = 0; i < M; i++){
            broke[Integer.parseInt(st.nextToken())] = true;
        }

        if(N == 100){
            System.out.println(0);
            return;
        }











    }
}
