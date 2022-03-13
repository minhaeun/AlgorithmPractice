package baekjoon.simulation.boj15787;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15787 {
    static int N, M, answer;
    static int map[];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/simulation/boj15787/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //기차의 수
        M = Integer.parseInt(st.nextToken()); //명령의 수

        map = new int[N+1]; //1~N개의 기차. 각 기차에는 20개의 좌석

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());


            if(cmd==1) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                //i번째 기차에 x번째 좌석에 사람을 태워라. 사람 이미 있으면 continue => or
                map[i] = map[i] | (1<<x);

            }else if(cmd==2) {
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                //i번째 기차에 x번째 좌석 사람 하차 => and
                map[i] = map[i] & ~(1<<x);

            }else if(cmd==3) {
                int i = Integer.parseInt(st.nextToken());

                //모두 한칸씩 뒤로감.
                map[i] = map[i] << 1;
                //만약 20번째 사람있으면 하차
                map[i] = map[i] & ((1<<21)-1);

            }else if(cmd==4) {
                int i = Integer.parseInt(st.nextToken());

                //모두 한칸씩 앞으로
                map[i] = map[i] >> 1;
                map[i] = map[i] & ~1;

            }


        }



        //M 명령 후 1번기차부터 순서대로 은하수를 건넌다
        boolean visited[] = new boolean[1 << 21];
        for (int i = 1; i <= N; i++) {

            if(visited[map[i]]) continue;
            else {
                answer++;
                visited[map[i]]=true;
            }
        }


        System.out.println(answer);

    }
}
