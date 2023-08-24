package baekjoon.boj20125;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj20125 {
    public static Point head, heart, waistS, waistE;
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20125/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        OUTER : for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == '*'){
                    head = new Point(i, j);
                    break OUTER;
                }
            }
        }

        heart = new Point(head.r + 1, head.c);

        waistS = new Point(heart.r + 1, heart.c);
        for(int i = waistS.r; i < N; i++){
            if(map[i][waistS.c] == '_'){
                waistE = new Point(i - 1, waistS.c);
                break;
            }
        }
        int armLeft = 0, armRight = 0;
        for(int i = 0; i < heart.c; i++){
            if(map[heart.r][i] == '*') armLeft++;
        }

        for(int i = heart.c; i < N; i++){
            if(map[heart.r][i] == '_'){
                armRight = i - heart.c - 1;
                break;
            }
            if(i == N - 1)  armRight = i - heart.c;
        }

        int legLeft = 0, legRight = 0;
        for(int i = waistE.r + 1; i < N; i++){
            if(map[i][waistE.c - 1] == '_')    {
                legLeft = i - waistE.r - 1;
                break;
            }
            if(i == N - 1)  legLeft = i - waistE.r;
        }

        for(int i = waistE.r + 1; i < N; i++){
            if(map[i][waistE.c + 1] == '_'){
                legRight = i - waistE.r - 1;
                break;
            }
            if(i == N - 1)  legRight = i - waistE.r;
        }
        sb.append(heart.r + 1).append(" ").append(heart.c + 1).append("\n").append(armLeft).append(" ").append(armRight).append(" ").append(waistE.r - waistS.r + 1).append(" ").append(legLeft).append(" ").append(legRight);
        System.out.println(sb);

    }
}
