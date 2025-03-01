package programmers.zip;

import java.util.StringTokenizer;

public class P155651 {
    public static int solution(String[][] book_time) {
        StringTokenizer st;

        int len = book_time.length;
        int[] rooms = new int[24*60+10];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(book_time[i][j], ":");
                int h = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int sum = h * 60 +  m;
                if(j == 1){
                    sum += 10;
                    rooms[sum]--;
                }else rooms[sum]++;
            }
        }

        int max = 0;
        for(int i = 1; i < 60*24+10; i++){
            rooms[i] += rooms[i - 1];
            max = Math.max(max, rooms[i]);
        }

        return max;
    }
    public static void main(String[] args) {
        String[][] book_time1 = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] book_time2 = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        String[][] book_time3 = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};

        System.out.println(solution(book_time1));
        System.out.println(solution(book_time2));
        System.out.println(solution(book_time3));

    }
}
