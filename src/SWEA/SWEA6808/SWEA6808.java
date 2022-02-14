package SWEA.SWEA6808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6808 {
    static int T;
    static int[] card, arr1, arr2, p;
    static int sum, sum2, answer, answer2;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA6808/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        T = Integer.parseInt(br.readLine());


        for(int t = 1; t <= T; t++){
            card = new int[19];     // 카드 번호 (1~18)
            arr1 = new int[9];      // 규영이 카드
            arr2 = new int[9];      // 인영이 카드
            p = new int[9];
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 9; i++){     // 입력받는 카드 9개
                int num = Integer.parseInt(st.nextToken());     // 규영이 카드
                card[num] = 1;      // 카드 표시
                arr1[i] = num;
            }
            int idx = 0;
            for(int i = 1; i <= 18; i++){
                // 남은 카드
                if(card[i] == 0){
                    arr2[idx++] = i;        // 인영이 카드
                }
            }
            answer = 0;
            answer2 = 0;
            permutation(0, 0);

            sb.append("#").append(t).append(" ").append(answer).append(" ").append(answer2);
            System.out.println(sb);
        }

    }

    public static void permutation(int count, int flag){
        if(count == 9){
            sum = 0;
            sum2 = 0;
            for(int i = 0; i < 9; i++){
                if(arr1[i] > p[i]){
                    sum += arr1[i] + p[i];
                }
                if(arr1[i] < p[i]){
                    sum2 += arr1[i] + p[i];
                }
            }
            if(sum > sum2) answer++;
            if(sum < sum2) answer2++;
            return;
        }

        for(int i = 0; i < 9; i++){
            if((flag & 1 << i) != 0)    continue;
            p[count] = arr2[i];
            permutation(count + 1, flag | 1<< i);
        }
    }



}
