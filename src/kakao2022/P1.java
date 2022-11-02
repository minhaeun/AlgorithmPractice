
package kakao2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 1", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.12.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }
    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] reterm = new int[26];
        StringTokenizer st = new StringTokenizer(today, ".");
        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());
        int todayDay = Integer.parseInt(st.nextToken());

        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i], " ");
            int alpha = st.nextToken().charAt(0) - 'A';
            int value = Integer.parseInt(st.nextToken());
            reterm[alpha] = value;
        }

        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i], " ");

            String date = st.nextToken();
            int alpha = st.nextToken().charAt(0) - 'A';

            st = new StringTokenizer(date, ".");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            int period = reterm[alpha];

            month += period;
            if(month > 12){
                year++;
                month -= 12;
            }
            day--;

            if(day == 0){
                day = 28;
                month -- ;
            }

            if(month == 0){
                year--;
                month = 12;
            }

            if(todayYear == year){
               if(todayMonth > month){
                    answer.add(i+1);
               }else if(todayMonth == month && todayDay > day){
                   answer.add(i+1);
               }
            }else if(todayYear > year){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
