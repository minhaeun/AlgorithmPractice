package baekjoon.data_structure.boj18258;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj18258 {
    public static int N, last;
    public static Queue<Integer> queue;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj18258/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();

        while(N-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            if(str.equals("push")){
                int X = Integer.parseInt(st.nextToken());
                last = X;
                push(X);
            }else if(str.equals("pop")){
                pop();
            }else if(str.equals("size")){
                sb.append(size()).append("\n");
            }else if(str.equals("empty")){
                empty();
            }else if(str.equals("front")){
                front();
            }else if(str.equals("back")){
                back();
            }

        }
        System.out.println(sb);
    }

    public static void push(int x){
        queue.offer(x);
    }
    public static void pop(){
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
        }else{
            int x = queue.poll();
            sb.append(x).append("\n");
        }
    }
    public static int size(){
        return queue.size();
    }
    public static void empty(){
        if(queue.isEmpty()){
            sb.append(1).append("\n");
        }else{
            sb.append(0).append("\n");
        }
    }
    public static void front(){
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
        }else{
            int x = queue.peek();
            sb.append(x).append("\n");
        }
    }
    public static void back(){
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
        }else{
            sb.append(last).append("\n");
        }
    }
}
