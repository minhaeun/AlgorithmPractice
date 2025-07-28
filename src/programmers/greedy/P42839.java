package programmers.greedy;


import java.util.HashSet;

public class P42839 {
    public static int N;
    public static boolean[] visited;
    public static HashSet<Integer> set;
    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();

        N = numbers.length();
        for(int i = 1; i < N + 1; i++){
            visited = new boolean[N];
            dfs(0, i, "", numbers);
        }

        for(int value : set){
            if(isPrime(value)) answer++;
        }

        return answer;
    }
    public static void dfs(int count, int len, String str, String numbers){
        if(count == len){
            int value = Integer.parseInt(str);
            set.add(value);
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(count + 1, len, str + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }
    public static boolean isPrime(int num){
        if(num < 2) return false;
        if(num == 2) return true;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
