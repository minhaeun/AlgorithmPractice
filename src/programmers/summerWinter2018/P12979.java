package programmers.summerWinter2018;

public class P12979 {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = stations.length;

        if(stations[0] != 1) answer = cal(stations[0] - w - 1, w);
        for(int i = 0; i < len - 1; i++){
            answer += cal(stations[i + 1] - stations[i] - 1 - w*2, w);
        }
        if(stations[len - 1] != n)
            answer += cal(n - stations[len - 1] - w, w);

        return answer;
    }
    public static int cal(int value, int w){
        if(value <= 0) return 0;
        int std = 2*w + 1;
        if(value % std != 0) return (value / std) + 1;
        return value / std;
    }
    public static void main(String[] args) {
        int n1 = 11, stations1[] = {4, 11}, w1 = 1;
        int n2 = 16, stations2[] = {9}, w2 = 2;
        int n3 = 5, stations3[] = {1,2, 3, 4, 5}, w3 = 1;

        System.out.println(solution(n1, stations1, w1));
        System.out.println(solution(n2, stations2, w2));
        System.out.println(solution(n3, stations3, w3));

    }
}
