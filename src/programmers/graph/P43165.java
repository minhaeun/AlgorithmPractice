package programmers.graph;

public class P43165 {
    static int count;

    public static int solution(int[] numbers, int target) {
        count = 0;

        dfs(0, 0, numbers, target);

        return count;
    }

    public static void dfs(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }

        dfs(depth+1, sum + numbers[depth], numbers, target);
        dfs(depth+1, sum - numbers[depth], numbers, target);
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int[] numbers2 = {4, 1, 2, 1};
        int target1 = 3, target2 = 4;

        System.out.println(solution(numbers1, target1));
        System.out.println(solution(numbers2, target2));
    }
}
