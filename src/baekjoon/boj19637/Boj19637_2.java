package baekjoon.boj19637;

import javax.xml.transform.sax.SAXSource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj19637_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj19637/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] strArr = new String[N];
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            strArr[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int value = Integer.parseInt(br.readLine());
            int low = 0;
            int high = N - 1;
            int ans = 0;
            while(low <= high){
                int midIndex = (low + high) / 2;
                int midValue = arr[midIndex];

                if(value > midValue){
                    low = midIndex + 1;
                }else{
                    high = midIndex - 1;
                    ans = midIndex;
                }
            }
            sb.append(strArr[ans]).append("\n");
        }
        System.out.println(sb);
    }
}
