import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, score;
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int total = 0;

        for(int i = 0; i < n; i++) {
            score = Integer.parseInt(st.nextToken());
            total += score;     // 1. 종합 점수 계산
            if(score > max) {   // 2. 최댓값 찾기
                max = score;
            }
        }
        
        // 3. 100*종합점수 / 개수 / 최댓값
        // 예제 1.) 100.0 * 180 / 3 / 80 = 75.0
        // 예제 2.) 100.0 * 60 / 3 / 30 = 66.666667
        System.out.println( (float)(100.0 * total / n / max) );
    }
}