package baekjoon.boj14719;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14719 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj14719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[W];
        int maxIndex = 0, max = 0;
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }

        // 좌
        int sum = 0, stand = arr[0];
        for(int i = 1; i < maxIndex; i++){
            if(stand <= arr[i]){
                stand = arr[i];
                continue;
            }
            sum += stand - arr[i];
        }

        // 우
        stand = arr[W - 1];
        for(int i = W-2; i > maxIndex; i--){
            if(stand <= arr[i]){
                stand = arr[i];
                continue;
            }
            sum += stand - arr[i];
        }
        System.out.println(sum);
    }
}
