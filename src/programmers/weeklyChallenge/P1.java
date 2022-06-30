package programmers.weeklyChallenge;

public class P1 {
    public static int solution(int[][] sizes) {
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        for(int[] row : sizes){
            int w = Math.max(row[0], row[1]);
            int h = Math.min(row[0], row[1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        return maxW * maxH;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }

}
