package programmers.kakao2018;

import java.util.StringTokenizer;

public class P17683 {
    public static String solution(String m, String[] musicinfos) {
        StringTokenizer st1, st2;
        String answer = "(None)";
        int maxTime = 0;
        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");

        int len = musicinfos.length;
        for(int i = 0; i < len; i++){
            st1 = new StringTokenizer(musicinfos[i], ",");
            String time = st1.nextToken();
            st2 = new StringTokenizer(time, ":");
            int startH = Integer.parseInt(st2.nextToken());
            int startM = Integer.parseInt(st2.nextToken());
            int start = startH*60 + startM;

            time = st1.nextToken();
            st2 = new StringTokenizer(time, ":");
            int endH = Integer.parseInt(st2.nextToken());
            int endM = Integer.parseInt(st2.nextToken());
            int end = endH*60 + endM;

            int play = end - start;

            String title = st1.nextToken();
            String tmp = st1.nextToken().replace("C#", "c")
                    .replace("D#", "d")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");
            String melody = tmp;
            if(play <= tmp.length()){
                melody = tmp.substring(0, play);
            }else{
                for(int j = 0; j < play / tmp.length(); j++){
                    melody += tmp;
                }
                melody += tmp.substring(0, play % tmp.length());
            }
            if(melody.contains(m) && play > maxTime){
                maxTime = play;
                answer = title;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String m1 = "ABCDEFG", musicinfos1[] = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m2 = "CC#BCC#BCC#BCC#B", musicinfos2[] = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m3 = "ABC", musicinfos3[] = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m1, musicinfos1));
        System.out.println(solution(m2, musicinfos2));
        System.out.println(solution(m3, musicinfos3));

    }
}
