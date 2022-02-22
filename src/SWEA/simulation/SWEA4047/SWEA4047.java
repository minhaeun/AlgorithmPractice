package SWEA.simulation.SWEA4047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA4047 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/simulation/SWEA4047/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String S = br.readLine();   // (1 <= |S| <= 1000)
            // 각 3자리 TXY, T 무늬(S, D, H, C), XY : 01 ~ 13
            boolean[][] used = new boolean[4][14];  // [무늬 4종][숫자 01~ 13, 00칸은 안씀]
            int[] cnt = {13, 13, 13, 13};   // 각 카드의 총 개수
            boolean error = false;
            for (int i = 0; i < S.length(); i+= 3){ // 3자리 문자열씩 읽을 수 있도록 순회
                int kind  = -1; // 무늬
                switch(S.charAt(i)){
                    case 'S': kind = 0; break;
                    case 'D': kind = 1; break;
                    case 'H': kind = 2; break;
                    case 'C': kind = 3; break;
                }
                int num = Integer.parseInt(S.substring(i + 1, i + 3));

                if(used[kind][num]) {    // 이미 동일 카드가 나왔었다면
                    error = true;
                    break;
                }
                used[kind][num] = true; // 카드 사용
                cnt[kind]--; // 무늬 별로 카드 사용 개수 카운팅
            }
            sb.append("#").append(tc).append(" ");
            if(error){
                sb.append("ERROR\n");
            }else{
                sb.append(cnt[0]).append(" ").append(cnt[1]).append(" ").append(cnt[2]).append(" ").append(cnt[3]).append("\n");
            }
        }
        System.out.print(sb.toString());


    }
}
