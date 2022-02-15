package baekjoon.boj2529;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2529 {
    static boolean[] numbers;
    static int N;
    static char[] sign;
    static ArrayList<String> arrayList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2529/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sign = br.readLine().toCharArray();
        numbers = new boolean[10];
        arrayList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            numbers[i] = true;
            dfs(0, i, i + "");
        }

        System.out.println(arrayList.get(arrayList.size() - 1));
        System.out.println(arrayList.get(0));

    }

    public static void dfs(int count, int num, String str){
        if(count == N){
            arrayList.add(str);
            numbers[num] = false;
            return;
        }

        for(int i = 0; i < 10; i++){
            if(numbers[i])  continue;
            if(num == i)  continue;
            if(sign[2 * count] == '>'){

                if(num < i)     continue;

            }else if(sign[2 * count] == '<'){
                if(num > i)   continue;
            }
            numbers[i] = true;
            dfs(count + 1, i, str + i);
        }
        numbers[num] = false;
    }

}
