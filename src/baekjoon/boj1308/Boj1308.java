package baekjoon.boj1308;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1308 {
    static int[] dayArray(int year) {
        int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            day[1] = 29;
        return day;
    }

    static long FindingDays(int year, int month, int day) {
        long days = 0;
        int[] date;
        for (int i = 1; i < year; i++) {
            date = dayArray(i);
            for (int j = 0; j < 12; j++) {
                days += date[j];
            }
        }
        date = dayArray(year);
        for (int i = 0; i < month-1; i++) {
            days += date[i];
        }
        days += day;
        return days;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1308/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int Tyear = Integer.parseInt(st.nextToken());
        int Tmonth = Integer.parseInt(st.nextToken());
        int Tday = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int Dyear = Integer.parseInt(st.nextToken());
        int Dmonth = Integer.parseInt(st.nextToken());
        int Dday = Integer.parseInt(st.nextToken());


        if ((Dyear - Tyear > 1000) || (Dyear - Tyear == 1000 && Dmonth > Tmonth)
                || (Dyear - Tyear == 1000 && Dmonth == Tmonth && Dday >= Tday))
            System.out.println("gg");
        else {
            long T_findingdays = FindingDays(Tyear, Tmonth, Tday);
            long D_findingdays = FindingDays(Dyear, Dmonth, Dday);
            System.out.println("D-" + (D_findingdays - T_findingdays));
        }

    }

}