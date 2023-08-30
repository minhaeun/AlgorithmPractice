package baekjoon.data_structure.boj2304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2304_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj2304/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] bars = new int[1001];
        int maxH = 0, maxIndex = 0, maxL = 0, minL = 1001;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            bars[l] = h;
            if(maxH < h){
                maxH = h;
                maxIndex = l;
            }
            if(maxL < l)    maxL = l;
            if(minL > l)    minL = l;
        }
        int before = 0, sum = maxH, count = 0;
        for(int i = minL ; i <= maxIndex; i++){
            if(before <= bars[i]) {
                sum += count * before;
                count = 0;
                count++;
                before = bars[i];
            }else{
                count++;
            }
        }
        before = 0;
        count = 0;
        for(int i = maxL; i >= maxIndex; i--){
            if(before <= bars[i]) {
                sum += count * before;
                count = 0;
                count++;
                before = bars[i];
            }else{
                count++;
            }
        }
        System.out.println(sum);
    }
}
