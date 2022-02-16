package SWEA.simulation.SWEA5644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5644 {
    static int T;
    static int M, A;    // M : 이동 시간, A : BC의 개수
    static int[] dr = {0, -1, 0, 1, 0};     // X, 상, 우, 하, 좌
    static int[] dc = {0, 0, 1, 0, -1};
    static int[] infoA, infoB;
    static int sum;
    static Battery[] batteries;

    static class Battery{
        int r, c, range, amount;

        public Battery(String r, String c, String range, String amount){
            this.r = Integer.parseInt(c);
            this.c = Integer.parseInt(r);
            this.range = Integer.parseInt(range);
            this.amount = Integer.parseInt(amount);
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/simulation/SWEA5644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());       // 이동시간
            A = Integer.parseInt(st.nextToken());       // BC 개수합
            sum = 0;
            infoA = new int[M];
            infoB = new int[M];
            batteries = new Battery[A];

            // A의 이동 정보
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++){
                infoA[i] = Integer.parseInt(st.nextToken());
            }

            // B의 이동 정보
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++){
                infoB[i] = Integer.parseInt(st.nextToken());
            }

            // 배터리 정보 저장
            for(int i = 0; i < A; i++){
                st = new StringTokenizer(br.readLine(), " ");
                batteries[i] = new Battery(st.nextToken(),st.nextToken(), st.nextToken(), st.nextToken());
            }

            // 초기 A 위치와 B 위치
            int rA = 1, cA = 1;
            int rB = 10, cB = 10;

            int total = 0;
            // 총 시간 M 만큼 반복하기
            for(int m = 0; m <= M; m++){
                // 첫 위치부터 배터리 합 구해야하니까
                // 배터리 최대 8개니까 다 돌려도 상관 없음
                int max = Integer.MIN_VALUE;
                for(int b1 = 0; b1 < A; b1++){
                    for(int b2 = 0; b2 < A; b2++){
                        int amountA = chkAmount(rA,cA, b1);
                        int amountB = chkAmount(rB,cB, b2);
                        total = amountA + amountB;
                        // 0이면 배터리 안쓰고 있는 중 이니까 total 값 그대로, 같은 배터리를 쓰고있으면 /2 해주기
                        if((b1 == b2) && amountA != 0 && amountB != 0){
                            total /= 2;
                        }
                        max = Math.max(max, total);

                    }

                }
                sum += max;
                // 더이상 이동할 곳 없음!
                if(m == M)  break;
                // A와 B 이동
                rA += dr[infoA[m]];
                cA += dc[infoA[m]];

                rB += dr[infoB[m]];
                cB += dc[infoB[m]];
            }
            sb.append("#").append(tc).append(" ").append(sum);
            System.out.println(sb);

        }
    }


    public static int chkAmount(int r, int c, int bc){

        // 현재위치에서 bc번 배터리까지의 거리
        int bcd = Math.abs(batteries[bc].r - r) + Math.abs(batteries[bc].c - c);

        if(bcd <= batteries[bc].range)  return batteries[bc].amount;
        return 0;
    }
}
