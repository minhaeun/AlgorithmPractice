package programmers.zip;

import java.util.Arrays;

public class P131130 {
    public static int count, visited[], len;
    public static int solution(int[] cards) {
        count = 1;
        len = cards.length;
        visited = new int[len];


        for(int i = 0; i < len; i++){
            if(visited[i] != 0) continue;
            visited[i] = count;
            dfs(cards[i] - 1, cards);
        }
        int[] arr = new int[count];

        for(int i = 0; i < len; i++){
            int value = visited[i];
            arr[value - 1]++;
        }

        Arrays.sort(arr);
        return arr[count - 1] * arr[count - 2];
    }

    public static void dfs(int num, int[] cards){

        if(visited[num] != 0){
            count++;
            return;
        }

        visited[num] = count;
        int value = cards[num];
        dfs(value - 1, cards);
    }


    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));

    }
}
