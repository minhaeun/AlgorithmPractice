package programmers.summerWinter2018;

public class P49993 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill.length();
        int[] arr = new int[len];
        if(len == 1) return skill_trees.length;
        for(String skill_tree : skill_trees) {
            for(int i = 0; i < len; i++) {
                char ch = skill.charAt(i);
                arr[i] = skill_tree.indexOf(ch);
            }
            boolean flag = false;
            for(int i = 1; i < len; i++){
                if((arr[i - 1] > arr[i] && arr[i] != -1) || (arr[i - 1] != arr[i] && arr[i - 1] == -1)){
                    flag = false;
                    break;
                }
                else flag = true;
            }
            if(flag) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String skill1 = "A", skill_trees1[] = {"AB"};
        System.out.println(solution(skill1, skill_trees1));
    }
}
