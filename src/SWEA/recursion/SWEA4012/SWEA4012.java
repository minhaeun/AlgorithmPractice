package SWEA.recursion.SWEA4012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA4012 {
    static int T, N;
    static int min;
    static int[][] S;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/recursion/SWEA4012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            S = new int[N][N];
            visit = new boolean[N];

            for(int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int c = 0; c < N; c++){
                    S[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            combination(0, N, N/2);

            sb.append("#").append(tc).append(" ").append(min);
            System.out.println(sb);
        }


    }

    public static void combination(int start, int n, int r){
        if(r == 0){
            min = Math.min(min, getSum());
            return;
        }

        for(int i = start; i < n; i++){
            visit[i] = true;
            combination(i + 1, n, r - 1);
            visit[i] = false;
        }
    }

    public static int getSum(){
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for(int i = 0; i < N; i++){
            if(visit[i])    a.add(i);
            else    b.add(i);
        }

        int sumA = 0, sumB = 0;

        for(int i = 0; i < a.size() - 1; i++){
            for(int j = i; j < a.size(); j++){
                sumA += S[a.get(i)][a.get(j)] + S[a.get(j)][a.get(i)];
                sumB += S[b.get(i)][b.get(j)] + S[b.get(j)][b.get(i)];
            }
        }

        return Math.abs(sumA - sumB);

    }
}
