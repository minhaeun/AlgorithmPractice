package baekjoon.boj1027;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1027 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1027/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;
        boolean[][] check = new boolean[N][N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            long x = 1;
            long y = -1000000001;
            int count = 0;

            for(int j = i + 1; j < N; j++){
                long dx = j - i;
                long dy = arr[j] - arr[i];

                if(y * dx < dy * x){
                    x = dx;
                    y = dy;
                    check[i][j] = true;
                    count++;
                }
            }

            for(int j = 0; j < i; j++){
                if(check[j][i]) count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);





    }
}
