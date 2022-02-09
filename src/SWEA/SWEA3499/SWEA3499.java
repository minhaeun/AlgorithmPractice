package SWEA.SWEA3499;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA3499 {
    static int N;
    static ArrayList<String> arrayList1, arrayList2;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("./src/SWEA/SWEA3499/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb;
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            sb = new StringBuilder();
            int i = 0;

            for(; i < N/2; i++){
                arrayList1.add(st.nextToken());
            }
            if(N % 2 != 0){
                arrayList1.add(st.nextToken());
                i++;
            }
            for(; i < N; i++){
                arrayList2.add(st.nextToken());
            }
            int len1 = arrayList2.size();
            for(int j = 0; j < len1; j++){
                arrayList1.add(2*j+1, arrayList2.get(j));
            }
            sb.append("#").append(tc).append(" ");
            int len2 = arrayList1.size();
            for(int j = 0; j < len2; j++)   sb.append(arrayList1.get(j)).append(" ");
            System.out.println(sb);

            arrayList1.clear();
            arrayList2.clear();
        }
    }
}
