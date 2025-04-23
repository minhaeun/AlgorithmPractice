package programmers.kakao2020;

public class P60059 {
    public static boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;
        for(int d = 0; d < 4; d++){
            if(d != 0) key = rotate(key);
            for(int r = -(len - 1); r < len - 1; r++){
                for(int c = -(len - 1); c < len - 1; c++){
                    if(check(key, lock, r, c)) return true;
                }
            }
        }
        return false;
    }
    public static int[][] rotate(int[][] key){
        int len = key.length;
        int[][] result = new int[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                result[i][j] = key[len - 1 - j][i];
            }
        }
        return result;
    }
    public static boolean check(int[][] key, int[][] lock, int r, int c){
        int lockLen = lock.length;
        int keyLen = key.length;
        for(int i = 0; i < lockLen; i++){
            for(int j = 0; j < lockLen; j++){
                if(i + r < 0 || i + r >= keyLen || j + c < 0 || j + c >= keyLen){
                    if(lock[i][j] == 0) return false;
                }else{
                    if(lock[i][j] == key[i + r][j + c]) return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] key1 = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, lock1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key1, lock1));

    }
}
