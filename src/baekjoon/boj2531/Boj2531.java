package baekjoon.boj2531;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2531 {
    static int N, d, k, c, count;
    static int[] belt, kinds;
    static Queue<Integer> choice;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2531/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 접시 수
        d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        belt = new int[N];
        kinds = new int[N];
        choice = new LinkedList<>();

        for(int i = 0; i < N; i++){
            // 초밥 저장
            belt[i] = Integer.parseInt(br.readLine());
        }

        // 연속해서 초밥 먹기 시작
        for(int i = 0; i < k; i++){
            choice.offer(belt[i]);      // 선택한 초밥을 큐에 저장
            kinds[belt[i]]++;           // 초밥 종류 세기
            if(kinds[belt[i]] == 1){    //
                count++;
            }
        }






    }
}
