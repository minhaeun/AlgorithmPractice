package programmers.pccp;

import java.util.StringTokenizer;

public class P340213 {

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(video_len, ":");
        int m = Integer.parseInt(st.nextToken()) * 60;
        int s = Integer.parseInt(st.nextToken());
        int videoLen = m + s;

        st = new StringTokenizer(pos, ":");
        m = Integer.parseInt(st.nextToken()) * 60;
        s = Integer.parseInt(st.nextToken());
        int now = m + s;

        st = new StringTokenizer(op_start, ":");
        m = Integer.parseInt(st.nextToken()) * 60;
        s = Integer.parseInt(st.nextToken());
        int opStart = m + s;

        st = new StringTokenizer(op_end, ":");
        m = Integer.parseInt(st.nextToken()) * 60;
        s = Integer.parseInt(st.nextToken());
        int opEnd = m + s;

        int commandsLen = commands.length;

        if(now >= opStart && now <= opEnd) now = opEnd;

        for(int i = 0; i < commandsLen; i++){
            String str = commands[i];
            if(str.equals("prev")){
                now -= 10;
                if(now < 0) now = 0;
            }else if(str.equals("next")){
                now += 10;
                if(now > videoLen) now = videoLen;
            }
            if(now >= opStart && now <= opEnd) now = opEnd;
        }

        m = now / 60;
        s = now % 60;

        if(m < 10) sb.append(0);
        sb.append(m).append(":");
        if(s < 10) sb.append(0);
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        String video_len1 = "34:33", pos1 = "13:00", op_start1 = "00:55", op_end1 = "02:55", commands1[] = {"next", "prev"}, result1 = "13:00";
        String video_len2 = "10:55", pos2 = "00:05", op_start2 = "00:15", op_end2 = "06:55", commands2[] = {"prev", "next", "next"}, result2 = "06:55";
        String video_len3 = "07:22", pos3 = "04:05", op_start3 = "00:15", op_end3 = "04:07", commands3[] = {"next"}, result3 = "04:17";



        System.out.println(solution(video_len1, pos1, op_start1, op_end1, commands1));
        System.out.println(solution(video_len2, pos2, op_start2, op_end2, commands2));
        System.out.println(solution(video_len3, pos3, op_start3, op_end3, commands3));



    }
}
