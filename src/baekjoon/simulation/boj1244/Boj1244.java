package baekjoon.boj1244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1244 {
    static int N, M;
    static boolean[] switches;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1244/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 스위치 개수 (1 <= N <= 100)
        switches = new boolean[N + 1]; // 스위치 상태 표시 배열 ( 1번 부터 시작 )

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N + 1; i++){
            if(Integer.parseInt(st.nextToken()) == 1)
                switches[i] = true;     // 스위치가 켜져있는 경우 true로 바꿔줌 ( 원래 초기화 값 false)
        }

        M = Integer.parseInt(br.readLine()); // 학생 수 (남자 : 1, 여자 : 2)

        /*  남학생일 경우 : 배수로 스위치 상태가 바뀜 (3번일 경우 3번, 6번, 9번 ... )
            여학생일 경우 : 스위치 중심으로 대칭구간까지 상태가 바뀜
        */

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()){
                case "1" :  // 남자일 경우
                    int num1 = Integer.parseInt(st.nextToken());   // 남학생이 받은 스위치 번호
                    int value = num1;
                    while(true){
                        if(value >= N + 1)   break;      // 스위치가 범위를 넘어가면 break
                        switches[value] = !switches[value];     // 스위치 상태 변환
                        value += num1;   // 초기값 계속 더해주면서 스위치 넘어가기
                    }
                    break;
                case "2":   // 여자일 경우
                    int num2 = Integer.parseInt(st.nextToken()); // 여학생이 받은 스위치 번호
                    switches[num2] = !switches[num2];       // 여학생이 받은 스위치 상태 바꿔주기
                    int i = 1;
                    while(true){
                        if(num2 - i <= 0 || num2 + i >= N + 1) break;    // 범위 넘어가면
                        if(switches[num2 - i] != switches[num2 + i]) break; // 대칭이 아니라면
                        // 대칭이면 스위치 상태 바꿔줌
                        switches[num2 - i] = !switches[num2 - i];
                        switches[num2 + i] = !switches[num2 + i];
                        i++;
                    }

                    break;
            }
        }

        for(int i = 1; i <= N; i++){
            if(switches[i]) sb.append(1).append(" ");
            else    sb.append(0).append(" ");
            if(i % 20 == 0)
                sb.append("\n");
        }
        System.out.print(sb.toString());


    }
}
