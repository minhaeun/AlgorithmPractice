package baekjoon.boj20056;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj20056 {

    public class Shark{
        int r, c, m, s, d;
        public Shark(int r, int c, int m, int s, int d){
            this.r = r;     // 행
            this.c = c;     // 열
            this.m = m;     // 질량
            this.s = s;     // 속력
            this.d = d;     // 방향
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20056/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }
}
