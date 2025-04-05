package programmers.zip;

public class P132265 {
    public static int solution(int[] topping) {
        int answer = 0;

        int[] arr1 = new int[10001];
        int[] arr2 = new int[10001];
        int len = topping.length;
        int arr1Count = 0, arr2Count = 0;
        for(int i = 0; i < len; i++){
            arr2[topping[i]]++;
            if(arr2[topping[i]] == 1) arr2Count++;
        }
        for(int i = 0; i < len; i++){
            arr1[topping[i]]++;
            if(arr1[topping[i]] == 1) arr1Count++;
            arr2[topping[i]]--;
            if(arr2[topping[i]] == 0) arr2Count--;
            if(arr1Count == arr2Count) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1, 2, 3, 1, 4};

        System.out.println(solution(topping1));
        System.out.println(solution(topping2));
    }
}
