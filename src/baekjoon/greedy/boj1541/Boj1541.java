package baekjoon.greedy.boj1541;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1541 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/greedy/boj1541/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int count = st.countTokens();
        int sum = 0;
        String[] str = new String[count];

        for(int i = 0; i < count; i++){
            str[i] = st.nextToken();
        }

        for(int i = 0; i < count; i++){
            int tmp = mySum(str[i]);
            if(i == 0)  sum += tmp;
            else sum -= tmp;
        }
        System.out.println(sum);
    }
    static int mySum(String a){
        int sum = 0;
        StringTokenizer st = new StringTokenizer(a, "[+]");
        int count = st.countTokens();
        String[] tmp = new String[count];
        for(int i = 0; i < count; i++){
            tmp[i] = st.nextToken();
        }
        for(int i = 0; i < count; i++){
            sum += Integer.parseInt(tmp[i]);
        }
        return sum;
    }
}
