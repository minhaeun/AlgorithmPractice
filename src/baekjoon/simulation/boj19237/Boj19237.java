package baekjoon.simulation.boj19237;

import com.sun.jdi.request.ExceptionRequest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj19237 {
    public static int N, M, k, map[][];
    public static PriorityQueue<Shark> sharks;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Smell{
        int num, time;
        public Smell(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
    public static class Shark{
        int r, c, num;
        public Shark(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj19237/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        sharks = new PriorityQueue<>(new Comparator<Shark>() {
            @Override
            public int compare(Shark o1, Shark o2) {
                return o1.num - o2.num;
            }
        });

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0)  sharks.add(new Shark(i, j, map[i][j]));
            }
        }
        

    }
}
