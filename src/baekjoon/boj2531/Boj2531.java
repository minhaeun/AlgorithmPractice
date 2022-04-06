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
        kinds = new int[d + 1];
        choice = new LinkedList<>();

        for(int i = 0; i < N; i++){
            // 초밥 저장
            belt[i] = Integer.parseInt(br.readLine());
        }

        // 처음부터 연속해서 초밥 먹기 시작 (k <= N)
        for(int i = 0; i < k; i++){
            choice.offer(belt[i]);      // 선택한 초밥을 큐에 저장
            kinds[belt[i]]++;           // 해당되는 초밥 수 세기
            if(kinds[belt[i]] == 1){
                count++;            // 먹을 수 있는 초밥 종류 수 세기
            }
        }

        int max = count;
        // 회전초밥 전부 확인
        for(int i = k; i < N + k - 1; i++){
            // 큐에 종류가 하나밖에 없는 초밥이었다면 count - 1
            if(--kinds[choice.poll()] == 0) count--;
            // 초밥 종류 확인해서 +1
            int value = ++kinds[belt[i % N]];
            // 초밥이 1개밖에 없다면 연속 가능
            if(value == 1) count++;
            // 큐에 저장
            choice.offer(belt[i % N]);
            // 서비스초밥을 안먹었으면
            if(kinds[c] == 0)   max = Math.max(max, count + 1);
            // 먹었으면
            else    max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
