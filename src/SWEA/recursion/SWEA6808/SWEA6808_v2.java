package SWEA.recursion.SWEA6808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA6808_v2 {
    static int T;
    static int[] card, arr1, arr2, p;
    static int answer, answer2;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/recursion/SWEA6808/input.txt"));
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
            Arrays.sort(arr2);
            answer = 0;
            answer2 = 0;
            do{
                int a = 0, b = 0;
                for(int i = 0; i < 9; i++){
                    if(arr1[i] > arr2[i])   a += arr1[i] + arr2[i];
                    else    b += arr1[i] + arr2[i];
                }
                if(b > a)   answer2++;
                else    answer++;
            }while(np());
            sb.append("#" + t + " " + answer + " " + answer2);
            System.out.println(sb);
        }

    }

    public static boolean np(){
        int i =  8;
        while(i > 0 && arr2[i - 1] >= arr2[i])   --i;

        if(i == 0)  return false;

        int j = 8;
        while(arr2[i - 1] >= arr2[j])   --j;

        swap(i - 1, j);

        int k = 8;
        while(i < k ){
            swap(i++, k--);
        }
        return true;
    }

    public static void swap(int i, int j){
        int temp = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = temp;
    }


}
