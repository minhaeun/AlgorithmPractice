package baekjoon.boj1027;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1027_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1027/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] visible = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++){
            visible[i]++;
            visible[i + 1]++;
            double slope = arr[i + 1] - arr[i];
            for(int j = i + 2; j < N; j++){
                double nextSlope = (double) (arr[j] - arr[i]) / (j - i);
                if(nextSlope <= slope)  continue;
                slope = nextSlope;
                visible[i]++;
                visible[j]++;
            }
        }
        Arrays.sort(visible);
        System.out.println(visible[visible.length - 1]);

    }
}
