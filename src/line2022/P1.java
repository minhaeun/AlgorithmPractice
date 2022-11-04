package line2022;


public class P1 {
    static int[] arr;



    public static void main(String[] args) {
        int[][] queries = {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};

        System.out.println(solution(queries));
    }

    public static int solution(int[][] queries) {
        int answer = 0;

        arr = new int[1001];

        for(int i = 0; i < queries.length; i++){
            int input = queries[i][1];
            int before = arr[queries[i][0]];
            arr[queries[i][0]] += input;
            int value = arr[queries[i][0]];
            if(value % 2 == 0){
                value -=1;
            }

            double tmp1 = Math.log(value) / Math.log(2);
            int power1 = (int)Math.ceil(tmp1);
            long result1 = (long)Math.pow(2, power1);

            if(before != 0) {
                double tmp2 = Math.log(before) / Math.log(2);
                int power2 = (int) Math.ceil(tmp2);
                long result2 = (long) Math.pow(2, power2);

                if (result2 != result1) {
                    answer += before;
                }
            }
        }

        return answer;
    }

}
