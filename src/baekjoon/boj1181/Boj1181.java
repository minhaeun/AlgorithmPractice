package baekjoon.boj1181;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj1181 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1181/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())  return o1.compareTo(o2);
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(arr[0]);
        for(int i = 1; i < N; i++){
            if(arr[i - 1].equals(arr[i]))   continue;
            System.out.println(arr[i]);
        }

    }
}
