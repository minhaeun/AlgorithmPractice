package baekjoon.mathematics.boj1747;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1747 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1747/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] A = new boolean[1003002];

        A[0] = true;
        A[1] = true;
        for(int i = 2; i < Math.sqrt(A.length); i++){
            if(A[i])   continue;
            for(int j = i + i; j < A.length; j += i){
                A[j] = true;
            }
        }

        for(int i = N; i <= A.length; i++){
            if(isPalindrome(i) && !A[i]){
                System.out.println(i);
                return;
            }
        }

    }

    public static boolean isPalindrome(int num){
        char[] tmp = String.valueOf(num).toCharArray();
        int s = 0;
        int e = tmp.length - 1;
        while(s < e){
            if(tmp[s] == tmp[e]){
                s++;
                e--;
            }else return false;
        }

        return true;
    }
}
