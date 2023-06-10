import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());    // 1. n개의 숫자
        String str = br.readLine();                 // 2. n개만큼 숫자 기록
        String[] arr = str.split("");         // 3. 문자열 자르기

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += Integer.parseInt(arr[i]);    // 4. 정수로 파싱하여 합 구하기
        }
        br.close();

        System.out.println(sum);
    }
}