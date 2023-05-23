package baekjoon.boj1058;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1058 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1058/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] friend = new char[N][N];
        boolean[][] isFriend = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                friend[i][j] = str.charAt(j);
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            int towFriend = 0;
            for(int j = 0; j < N; j++){
                if(friend[i][j] == 'Y'){
                    isFriend[i][j] = true;
                    for(int k = 0; k < N; k++){
                        if(friend[j][k] == 'Y') isFriend[i][k] = true;
                    }
                }
            }
            for(int j = 0; j < N; j++){
                if(i == j)  continue;
                if(isFriend[i][j])  towFriend++;
            }
            max = Math.max(max, towFriend);
        }
        System.out.println(max);

    }
}
