package programmers.zip;

import java.util.*;

public class P176962 {
    public static class Plan{
        String name;
        int time, remain;
        public Plan(String name, String time, String remain) {
            this.name = name;
            StringTokenizer st = new StringTokenizer(time, ":");
            this.time = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            this.remain = Integer.parseInt(remain);
        }
        public Plan(String[] plan){
            this(plan[0], plan[1], plan[2]);
        }
        public int cal(){
            return time + remain;
        }
    }
    public static String[] solution(String[][] plansArr) {
        Plan[] plans = new Plan[plansArr.length];
        for(int i = 0; i < plansArr.length; i++) {
            plans[i] = new Plan(plansArr[i]);
        }
        Stack<Plan> stack = new Stack<>();
        ArrayList<String> answer = new ArrayList<>();

        Arrays.sort(plans, new Comparator<Plan>() {

            @Override
            public int compare(Plan o1, Plan o2) {
                return o1.time - o2.time;
            }
        });
        for(int i = 0; i < plans.length - 1; i++) {
            Plan now = plans[i];
            Plan next = plans[i + 1];

            if(now.cal() > next.time){
                now.remain = now.cal() - next.time;
                stack.push(now);
                continue;
            }
            answer.add(now.name);
            int rest = next.time - now.cal();
            while(rest > 0 && !stack.isEmpty()){
                Plan p = stack.peek();
                int diff = p.remain - rest;
                p.remain = diff;
                rest = diff * -1;
                if(diff > 0) break;
                answer.add(stack.pop().name);
            }
        }
        answer.add(plans[plans.length - 1].name);
        while(!stack.isEmpty()) answer.add(stack.pop().name);
        return answer.toArray(new String[answer.size()]);
    }
    public static void main(String[] args) {
        String[][] plans1 = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[][] plans2 = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[][] plans3 = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};

        System.out.println(Arrays.toString(solution(plans1)));
        System.out.println(Arrays.toString(solution(plans2)));
        System.out.println(Arrays.toString(solution(plans3)));

    }
}
