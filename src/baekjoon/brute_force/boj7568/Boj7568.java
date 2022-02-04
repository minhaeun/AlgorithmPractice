package baekjoon.brute_force.boj7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj7568 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj7568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());   // 몸무게
            arr[i][1] = Integer.parseInt(st.nextToken());   // 키
        }

        for(int i = 0; i < N; i++){
            int rank = 1;

            for(int j = 0; j < N; j++){
                if(i == j)  continue;      // 등수 같으면 넘어가기
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){ // 덩치가 작으면
                    rank++;                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}
