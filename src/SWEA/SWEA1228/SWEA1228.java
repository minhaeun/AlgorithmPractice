package SWEA.SWEA1228;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1228 {
    static int N;   // 암호문 길이
    static int M;   // 명령어 개수
    static ArrayList<String> arrayList;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("./src/SWEA/SWEA1228/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer command, st;
        int T = 10;

        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            arrayList = new ArrayList<>();
            command = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                if(i >= 10) break;      // index가 10보다 크면 삽입 필요 없음
                arrayList.add(command.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            command = new StringTokenizer(br.readLine(), "I");
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(command.nextToken(), " ");    // 명령어 한줄 씩
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(x >= 10)    continue;        // index가 10보다 크면 삽입 필요 없음
                for(int s = 0; s < y; s++){
                    if(x + s >= 10)  continue;       // index가 10보다 크면 삽입 필요 없음
                    arrayList.add(x + s, st.nextToken());
                }
            }
            sb.append("#").append(tc).append(" ");
            for(int i = 0; i < 10; i++)    sb.append(arrayList.get(i)).append(" ");
            System.out.println(sb);
        }
    }
}
