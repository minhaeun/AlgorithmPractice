package baekjoon.boj1327;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1327 {
    public static int N, K;
    public static char[] arr, copy;
    public static String arr_str, copy_str;
    public static class Node{
        String str;
        int cnt;
        public Node(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1327/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N];
        arr = br.readLine().replace(" ", "").toCharArray();

        copy = Arrays.copyOf(arr, N);
        Arrays.sort(arr);
        arr_str = new String(arr);
        copy_str = new String(copy);
        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        Set<String> search = new HashSet<>();
        queue.offer(new Node(copy_str, 0));

        while(!queue.isEmpty()){
            Node ci = queue.poll();
            String str = ci.str;
            int cnt = ci.cnt;

            if(arr_str.equals(str)) return cnt;
            if(!search.contains(str)){
                search.add(str);
                for(int i = 0; i <= N - K; i++){
                    queue.offer(new Node(reverseStr(str, i, i + K), cnt + 1));
                }
            }
        }
        return -1;
    }

    public static String reverseStr(String str, int i, int j){
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, i));

        String reverse = str.substring(i, j);
        for(int t = K - 1; t >= 0; t--){
            sb.append(reverse.charAt(t));
        }
        sb.append(str.substring(j, N));
        return sb.toString();
    }
}
