package programmers.kakao2022;

import java.util.Arrays;

public class P92342 {
    public static int lionArr[], apeachArr[], N, lionSum, apeachSum, answer[], max;
    public static boolean visited[], isWin, isChange;
    public static int[] solution(int n, int[] info) {
        if(n == 1) return new int[]{-1};

        lionArr = new int[11];
        answer = new int[11];
        apeachArr = Arrays.copyOf(info, info.length);
        N = n;
        choice(0, 0);
        if(max == 0) return new int[]{-1};
        return answer;
    }
    public static void choice(int start, int count){
        if(count == N){
            check();
            if(isWin){
                if(isChange){
                    answer = lionArr.clone();
                    return;
                }
                for(int i = 10; i >= 0; i--){
                    if(lionArr[i] < answer[i]) break;
                    else if(lionArr[i] > answer[i]){
                        answer = lionArr.clone();
                        break;
                    }

                }
            }
            return;
        }

        for(int i = start; i < 11; i++){
            lionArr[i]++;
            choice(i, count + 1);
            lionArr[i]--;
        }
    }

    public static void check(){
        isWin = false;
        isChange = false;
        apeachSum = 0; lionSum = 0;
        for(int i = 0; i < 11; i++){
            int lion = lionArr[i];
            int apeach = apeachArr[i];

            if(apeach == 0 && lion == 0) continue;
            if(apeach >= lion){
                apeachSum += 10 - i;
            }else lionSum += 10 - i;
        }
        if(apeachSum < lionSum){
            int diff = lionSum - apeachSum;
            if(diff >= max){
                if(diff > max) isChange = true;
                max = diff;
                isWin = true;

            }
        }

    }

    public static void main(String[] args) {
        int n1 = 5, info1[] = {2,1,1,1,0,0,0,0,0,0,0};
        int n2 = 1, info2[] = {1,0,0,0,0,0,0,0,0,0,0};
        int n3 = 9, info3[] = {0,0,1,2,0,1,1,1,1,1,1};
        int n4 = 10, info4[] = {0,0,0,0,0,0,0,0,3,4,3};
        int n5 = 3, info5[] = {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1};


        System.out.println(Arrays.toString(solution(n1, info1)));
        System.out.println(Arrays.toString(solution(n2, info2)));
        System.out.println(Arrays.toString(solution(n3, info3)));
        System.out.println(Arrays.toString(solution(n4, info4)));
        System.out.println(Arrays.toString(solution(n5, info5)));
    }
}
