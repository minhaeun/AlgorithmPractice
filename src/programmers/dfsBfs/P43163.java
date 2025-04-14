package programmers.dfsBfs;

public class P43163 {
    public static boolean visited[];
    public static int answer;
    public static int solution(String begin, String target, String[] words) {
        int len = words.length;
        answer = 0;
        visited = new boolean[len];
        dfs(begin, target, words, 0);

        return answer;
    }
    public static void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            int k = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) k++;
            }
            if(k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String begins1 = "hit", target1 = "cog", words1[] = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begins2 = "hit", target2 = "cog", words2[] = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begins1, target1, words1));
        System.out.println(solution(begins2, target2, words2));

    }
}
