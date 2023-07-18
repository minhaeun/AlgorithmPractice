package baekjoon.data_structure.boj10866;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj10866 {
    public static int N;
    public static Deque<Integer> deque;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj10866/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        deque = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            if(str.equals("push_front")){
                int x = Integer.parseInt(st.nextToken());
                pushFront(x);
            }else if(str.equals("push_back")){
                int x = Integer.parseInt(st.nextToken());
                pushBack(x);
            }else if(str.equals("pop_front")){
                popFront();
            }else if(str.equals("pop_back")){
                popBack();
            }else if(str.equals("size")){
                size();
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
    public static void pushFront(int x){
        deque.addFirst(x);
    }
    public static void pushBack(int x){
        deque.addLast(x);
    }
    public static void popFront(){
        if(deque.isEmpty()) sb.append(-1).append("\n");
        else{
            int x = deque.pollFirst();
            sb.append(x).append("\n");
        }
    }
    public static void popBack(){
        if(deque.isEmpty()) sb.append(-1).append("\n");
        else{
            int x = deque.pollLast();
            sb.append(x).append("\n");
        }
    }
    public static void size(){
        sb.append(deque.size()).append("\n");
    }
    public static void empty(){
        if(deque.isEmpty()) sb.append(1).append("\n");
        else sb.append(0).append("\n");
    }
    public static void front(){
        if(deque.isEmpty()) sb.append(-1).append("\n");
        else    sb.append(deque.getFirst()).append("\n");
    }
    public static void back(){
        if(deque.isEmpty()) sb.append(-1).append("\n");
        else    sb.append(deque.getLast()).append("\n");
    }
}
