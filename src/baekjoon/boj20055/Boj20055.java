package baekjoon.boj20055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20055 {
    public static int N, K;
    public static int[] belt;
    public static boolean[] roboat;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20055/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        roboat = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 2 * N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while(true){
            count++;
            beltMove();
            robotMove();

            if(isEnd()) break;
        }
        System.out.println(count);
    }

    public static boolean isEnd(){
        int check = 0;
        for(int i = 0; i < 2 * N; i++){
            if(belt[i] == 0)  check++;
            if(check >= K)  return true;
        }
        return false;
    }

    public static void robotMove(){
        if(roboat[N - 1])    roboat[N - 1] = false;

        for(int i = N-2; i >= 0; i--){
            if(!roboat[i + 1] && roboat[i] && belt[i + 1] > 0){
                roboat[i] = false;
                roboat[i + 1] = true;
                belt[i + 1]--;
            }
        }

        if(belt[0] >= 1 && !roboat[0]){
            roboat[0] = true;
            belt[0]--;
        }
    }

    public static void beltMove(){
        int tmp = belt[2 * N -1];
        for(int i = 2*N-1; i > 0; i--){
            belt[i] = belt[i - 1];
        }
        belt[0] = tmp;
        for(int i = N - 1; i > 0; i--){
            roboat[i] = roboat[i -1];
        }
        roboat[0] = false;
    }

}
