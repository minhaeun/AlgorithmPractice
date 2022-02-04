package SWEA.SWEA2001;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA2001/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] grid = new int[N][N];

            // 입력 받기
            for(int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int c = 0; c < N; c++){
                    grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            //배열 탐색하면서 MxM 확인
            for(int i = 0; i < N-M+1; i++){
                for(int j = 0; j < N-M+1; j++){
                    // MxM
                    int sum = 0;
                    for(int r = 0; r < M; r++){
                        for(int c = 0; c < M; c++){
                            sum += grid[i + r][j + c];
                        }
                    }
                    if(max < sum){
                        max = sum;
                    }
                }
            }
            sb.append("#" + tc + " ").append(max);
            System.out.println(sb);
        }

    }
}
