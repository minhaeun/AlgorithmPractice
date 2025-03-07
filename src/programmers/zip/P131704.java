package programmers.zip;


public class P131704 {
    public static int solution(int[] order) {
        int len = order.length;
        boolean[] arr = new boolean[len + 1];
        int count = 1;
        int front = order[0] - 1;
        int back = order[0] + 1;
        arr[order[0]] = true;
        for(int i = 1; i < len; i++){
            if(front < 0) front = 0;
            if(back > len) back = len;
            if(order[i - 1] > order[i]){
                while(arr[front] && front > 0) front--;
                if(front == order[i]){
                    count++;
                    arr[front] = true;
                    front--;
                }else break;
            }else{
                while(arr[back] && back < len) back++;
                if(back == order[i]){
                    count++;
                    arr[back] = true;
                    back++;
                }else{
                    while(order[i] != back){
                        front = back;
                        back++;
                    }
                    arr[back] = true;
                    count++;
                    back++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] order1 = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};
        int[] order3 = {3, 5, 4, 2, 1};

        // System.out.println(solution(order1));
        // System.out.println(solution(order2));
        System.out.println(solution(order3));

    }
}
