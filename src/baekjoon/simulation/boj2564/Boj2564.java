package baekjoon.simulation.boj2564;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2564 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/simulation/boj2564/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());// 세로길이
        int M = Integer.parseInt(st.nextToken());// 가로길이
        int shopCnt = Integer.parseInt(br.readLine());// 상점위치
        int[] dists = new int[shopCnt+1];// 각 위치별 거리(하나의 직선으로생각)
        for(int i=0;i<shopCnt+1; ++i) {	// 상점 개수만큼 반복한다.
            st = new StringTokenizer(br.readLine()," ");
            int dir = Integer.parseInt(st.nextToken());	// 방향
            int val = Integer.parseInt(st.nextToken());	// 값
            int dist = 0;	// 임시 거리 변수
            if(dir == 1) dist = val;// 북
            else if(dir == 2) dist = 2*N + M - val;	// 남
            else if(dir == 3) dist = 2*(N + M) - val;// 서
            else if(dir == 4) dist = N + val;// 동
            dists[i] = dist;// 거리를 넣어준다.
        }
        int me = dists[shopCnt];// 내 거리값을 저장한다.
        int sum =0;	// 거리의 합을 저장할 변수
        for(int i=0;i<shopCnt;++i) {
            int clockwise = Math.abs(me-dists[i]);// 시계 방향의 거리값
            sum += Math.min(clockwise, 2*(N+M) - clockwise);// 반시계랑 비교해서 더 작은 값을 더한다.
        }
        System.out.println(sum);		// 출력해준다.
    }
}
