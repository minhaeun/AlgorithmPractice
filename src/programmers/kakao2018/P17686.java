package programmers.kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P17686 {
    public static ArrayList<File> list = new ArrayList<>();
    public static class File{
        int id;
        String head, number, tail;
        public File(int id, String head, String number, String tail){
            this.id = id;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    public static String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        for(int i = 0; i < size; i++){
            String file = files[i];
            boolean flag = false;
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            int len = file.length();
            for(int j = 0; j < len; j++){
                char c = file.charAt(j);
                if(c >= '0' && c <= '9'){
                    number.append(c);
                    flag = true;
                }else{
                    if(!flag) head.append(c);
                    else{
                        tail.append(file.substring(j));
                        break;
                    }
                }
            }
            list.add(new File(i, head.toString(), number.toString(), tail.toString()));
        }

        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(o1.head.equalsIgnoreCase(o2.head)){
                    if(Integer.parseInt(o1.number) == Integer.parseInt(o2.number)){
                        return o1.id - o2.id;
                    }
                    return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
                }
                return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
            }
        });


        for(int i = 0; i < size; i++){
            File file = list.get(i);
            answer[i] = file.head + file.number + file.tail;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        System.out.println(Arrays.toString(solution(files1)));
        System.out.println(Arrays.toString(solution(files2)));
    }
}
