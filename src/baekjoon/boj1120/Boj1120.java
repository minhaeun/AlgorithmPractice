package baekjoon.boj1120;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1120 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1120/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String A = st.nextToken();
        String B = st.nextToken();

        int answer = 50;
        for(int i = 0; i < B.length() - A.length() + 1; i++){
            int temp = 0;
            for(int j = i; j < A.length() + i; j++){
                if(B.charAt(j) != A.charAt(j - i)){
                    temp++;
                }
            }
            answer = (answer > temp) ? temp:answer;
        }
        System.out.println(answer);
    }
}
