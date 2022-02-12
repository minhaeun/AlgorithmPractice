package baekjoon.boj2635;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj2635 {
    static int N;
    static ArrayList<Integer> arrayList;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2635/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int value = 0, length = 0;
        int max = Integer.MIN_VALUE;
        for(int i = N; i > N / 2; i--){
            arrayList = new ArrayList<>();
            arrayList.add(N);
            int curN = N;
            int num = i;
            while(true){
                if(curN < 0)   break;
                int t = curN;
                if(num >= 0)    arrayList.add(num);
                curN = num;
                num = t - curN;

            }
            length = arrayList.size();
            max = Math.max(max, length);
            if(max == length)   result = arrayList;
        }
        System.out.println(max);
        int size = result.size();
        for(int i = 0; i < size; i++){
            System.out.print(result.get(i) + " ");
        }


    }
}
