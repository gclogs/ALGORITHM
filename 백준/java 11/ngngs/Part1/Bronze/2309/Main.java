import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] h = new int[9];

        int sum = 0;

        for(int i = 0; i < h.length; i++) {   // 1. 9개의 줄에 걸쳐 난쟁이들의 키가 주어짐
            h[i] = Integer.parseInt(br.readLine());
            sum += h[i];
        }

        Arrays.sort(h); // 2. 오름차순 정렬
        
        // 3. 일곱난쟁이가 아닌 난쟁이 2명 찾아내기
        int fake1 = 0;
        int fake2 = 0;

        // 4. 가짜 난쟁이 판별 (brute force)
        for(int i = 0; i < h.length - 1; i++) {
            for(int j = i+1; j < h.length; j++) {
                if(sum - h[i] - h[j] == 100) {    // sum - i번째 난쟁이 키 - j번째 난쟁이 키 = 100
                    fake1 = i;  // i번째 스파이
                    fake2 = j;  // j번째 스파이
                    break;
                }
            }
        }

        // 5. 진짜 난쟁이들 출력
        for(int i = 0; i < h.length; i++) {
            if(i == fake1 || i == fake2) {
                continue;
            }
            System.out.println(h[i]);
        }
    }
}
