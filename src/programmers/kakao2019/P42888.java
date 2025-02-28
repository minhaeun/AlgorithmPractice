package programmers.kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P42888 {
    public static String[] solution(String[] record) {
        ArrayList<String[]> list = new ArrayList<>();
        StringTokenizer st;
        HashMap<String, String> map = new HashMap<>();

        for(String str : record){
            st = new StringTokenizer(str);
            String word = st.nextToken();
            String user = st.nextToken();

            if(word.equals("Leave")){
                list.add(new String[]{user, "님이 나갔습니다."});
            }else{
                String name = st.nextToken();
                map.put(user, name);
                if(word.equals("Enter")){
                    list.add(new String[]{user, "님이 들어왔습니다."});
                }
            }
        }
        String[] ans = new String[list.size()];
        int idx = 0;
        for(String[] str : list) ans[idx++] = map.get(str[0]) + str[1];

        return ans;
    }
    public static void main(String[] args) {
        String[] record1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record1)));
    }
}
