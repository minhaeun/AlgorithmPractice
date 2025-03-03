package programmers.zip;

public class P12952 {
    public static int N, arr[], answer;
    public static int solution(int n) {
        N = n;
        answer = 0;
        arr = new int[N];

        dfs(0);

        return answer;
    }

    public static void dfs(int depth){
        if(depth == N){
            answer++;
            return;
        }
        for(int i = 0; i < N; i++){
            arr[depth] = i;
            if(check(depth)) dfs(depth + 1);
        }
    }

    public static boolean check(int col){
        for(int i = 0; i < col; i++){
            if(arr[i] == arr[col]) return false;
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n1 = 4, n2 = 5;
        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }
}
