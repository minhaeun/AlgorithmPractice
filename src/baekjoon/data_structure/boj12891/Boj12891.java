package baekjoon.data_structure.boj12891;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {
    static int S, P, countArr[], checkArr[], count;
    static char[] DNA;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj12891/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        DNA = br.readLine().toCharArray();
        countArr = new int[4];
        checkArr = new int[4];
        count = 0;


        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < P; i++){
            char ch = DNA[i];
            switch (ch){
                case 'A':
                    countArr[0]++;
                    break;
                case 'C':
                    countArr[1]++;
                    break;
                case 'G':
                    countArr[2]++;
                    break;
                case 'T':
                    countArr[3]++;
                    break;
            }
        }
        for(int j = P; j < S; j++){
            int i = j - P;

            if(check()) count++;
            add(DNA[j]);
            remove(DNA[i]);

        }
        if(check()) count++;
        System.out.println(count);

    }
    public static boolean check(){
        for(int k = 0; k < 4; k++){
            if(countArr[k] < checkArr[k])   return false;
        }
        return true;
    }

    public static void add(char ch){
        switch (ch){
            case 'A':
                countArr[0]++;
                break;
            case 'C':
                countArr[1]++;
                break;
            case 'G':
                countArr[2]++;
                break;
            case 'T':
                countArr[3]++;
                break;
        }
    }

    public static void remove(char ch){
        switch (ch){
            case 'A':
                countArr[0]--;
                break;
            case 'C':
                countArr[1]--;
                break;
            case 'G':
                countArr[2]--;
                break;
            case 'T':
                countArr[3]--;
                break;
        }
    }
}
