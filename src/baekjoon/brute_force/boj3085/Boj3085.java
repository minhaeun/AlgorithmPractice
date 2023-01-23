package baekjoon.brute_force.boj3085;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj3085 {
    public static char board[][];
    public static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj3085/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][];
        for(int i = 0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        }
        int max = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == N - 1 && j == N - 1) break;
                else if(i == N - 1){
                    int rightMax = swapRight(i, j);
                    max = Math.max(max, rightMax);
                }else if(j == N - 1){
                    int downMax = swapDown(i, j);
                    max = Math.max(max, downMax);
                }else{
                    // 오른쪽 swap
                    int rightMax = swapRight(i, j);
                    max = Math.max(max, rightMax);
                    //
                    int downMax = swapDown(i, j);
                    max = Math.max(max, downMax);
                }

            }
        }

        System.out.println(max);

    }
    public static int swapRight(int r1, int c1){
        char tmp = board[r1][c1];
        board[r1][c1] = board[r1][c1 + 1];
        board[r1][c1 + 1] = tmp;

        int max = 1;
        int count = 1;
        // r1행 개수
        for(int i = 0; i < N - 1; i++){
            if(board[r1][i] == board[r1][i + 1])    count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        count = 1;
        // c1열 개수
        for(int i = 0; i < N - 1; i++){
            if(board[i][c1] == board[i + 1][c1])    count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        count = 1;
        // c1 + 1열 개수
        for(int i = 0; i < N - 1; i++){
            if(board[i][c1 + 1] == board[i + 1][c1 + 1])    count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        tmp = board[r1][c1];
        board[r1][c1] = board[r1][c1 + 1];
        board[r1][c1 + 1] = tmp;
        return max;
    }

    public static int swapDown(int r1, int c1){
        char tmp = board[r1][c1];
        board[r1][c1] = board[r1 + 1][c1];
        board[r1 + 1][c1] = tmp;

        int max = 1;
        int count = 1;
        // r1행 개수
        for(int i = 0; i < N - 1; i++){
            if(board[r1][i] == board[r1][i + 1])    count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        count = 1;
        // c1열 개수
        for(int i = 0; i < N - 1; i++){
            if(board[i][c1] == board[i + 1][c1])    count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        count = 1;
        // r1 + 1행 개수
        for(int i = 0; i < N - 1; i++){
            if(board[r1 + 1][i] == board[r1 + 1][i + 1])    count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        tmp = board[r1][c1];
        board[r1][c1] = board[r1 + 1][c1];
        board[r1 + 1][c1] = tmp;
        return max;
    }

}
