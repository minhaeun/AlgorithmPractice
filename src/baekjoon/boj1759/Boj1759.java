package baekjoon.boj1759;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {
    static int L;
    static int C;
    static char[] alpha;
    static char[] arr;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj1759/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new char[C];
        arr = new char[L];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++){
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        generateSubset(0, 0, 0, 0);
        System.out.println(sb);

    }

    static void generateSubset(int idx, int count, int mo, int ja){

        if(count == L){
            if(mo >= 1 && ja >= 2){
                for(int i = 0; i < L; i++){
                    sb.append(arr[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for(int i = idx; i < C; i++){
            arr[count] = alpha[i];

            if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u'){
                generateSubset(i + 1, count + 1, mo + 1, ja);
            }else{
                generateSubset(i + 1, count + 1, mo, ja + 1);
            }
        }
    }
}
