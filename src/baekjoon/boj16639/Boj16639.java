package baekjoon.boj16639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj16639 {
    public static int N;
    public static char[] input;
    public static int[][] min, max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        min = new int[N][N];
        max = new int[N][N];

        for(int i = 0; i < N; i++){
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }

        for(int i = 0; i < N; i+= 2){
            min[i][i] = input[i] - '0';
            max[i][i] = input[i] - '0';
        }

        for(int j = 2; j < N; j += 2){
            for(int i = 0; i < N - j; i += 2){
                for(int k = 2; k <= j; k += 2){
                    char op = input[i + k - 1];
                    int[] tmp = new int[4];
                    tmp[0] = calculate(max[i][i + k - 2], max[i + k][i + j], op);
                    tmp[1] = calculate(min[i][i + k - 2], max[i + k][i + j], op);
                    tmp[2] = calculate(max[i][i + k - 2], min[i + k][i + j], op);
                    tmp[3] = calculate(min[i][i + k - 2], min[i + k][i + j], op);
                    Arrays.sort(tmp);
                    max[i][i + j] = Math.max(max[i][i + j], tmp[3]);
                    min[i][i + j] = Math.min(min[i][i + j], tmp[0]);
                }
            }
        }
        System.out.println(max[0][N-1]);

    }

    public static int calculate(int n1, int n2, char op){
        int res = 0;
        switch (op){
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
        }
        return res;
    }
}
