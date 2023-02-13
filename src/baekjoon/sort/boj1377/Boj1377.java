package baekjoon.sort.boj1377;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1377 {
    public static class Data implements Comparable<Data>{
        int index;
        int value;

        Data(int index, int value){
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(Data d) {
            return this.value - d.value;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/sort/boj1377/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data A[] = new Data[N];

        for(int i = 0; i < N; i++){
            A[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(A);
        int max = 0;
        for(int i = 0; i < N; i++){
            int diff = A[i].index - i;
            max = Math.max(max, diff);
        }

        System.out.println(max + 1);
    }
}
